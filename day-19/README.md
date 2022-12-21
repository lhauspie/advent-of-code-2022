# How to build

```
mvn clean package
```

# How to run

```
java -jar target/advent-of-code-2022-day-19-1.0.0-SNAPSHOT.jar
```

# Some notes

This problem seems to be a tree search problem.

I modeled the problem as a tree.
First step, I only have one ore-collecting robot that is collecting ores.
Second step, ask if it's possible to build another ore, another clay, another obsidian, another geode, and doing nothing.
For each step, is it possible to build another ore, another clay, another obsidian, another geode, and doing nothing ? If yes, let's try this state.
And so on.

Doing that in an iterative manner will lead to instantiate 5^24 states = `59.604.644.775.390.620`. This multiplied by 8 integers + 4 booleans, what represents 32 * 8 octet per state = `15.258.789.062.500.000.000` Octets => `14.210.854.715` Gi. Too much for my little machine.

This is the code that leads to a OutOfMemoryError:
```java
private long getLargestNumberOfGeodesThatCanBeOpened() {
    BlueprintSimulationState state = new BlueprintSimulationState(this);
    List<BlueprintSimulationState> statesToExplore = new ArrayList<>();
    for (int time = 0; time < 24; time++) {
        List<BlueprintSimulationState> nextStatesToExplore = new ArrayList<>();
        nextStatesToExplore.add(state.buildNothing());
        for (BlueprintSimulationState currentState : statesToExplore) {
            nextStatesToExplore.add(currentState.buildNothing());
            if (currentState.oreCollectingRobotCanBeBuilt()) {
                nextStatesToExplore.add(currentState.buildOreCollectingRobot());
            }
            if (currentState.clayCollectingRobotCanBeBuilt()) {
                nextStatesToExplore.add(currentState.buildClayCollectingRobot());
            }
            if (currentState.obsidianCollectingRobotCanBeBuilt()) {
                nextStatesToExplore.add(currentState.buildObsidianCollectingRobot());
            }
            if (currentState.geodeCrackingRobotCanBeBuilt()) {
                nextStatesToExplore.add(currentState.buildGeodeCrackingRobot());
            }
        }
        statesToExplore = nextStatesToExplore;
    }

    // statesToExplore contains now the possible states at time 24 (24 minutes later)
    return statesToExplore.stream()
            .max(Comparator.comparingLong(BlueprintSimulationState::getNumberOfCrackedGeodes))
            .orElseThrow(() -> new RuntimeException("No Maximum state found"))
            .getNumberOfCrackedGeodes();
}
```

The good news is that the tree has a depth of 24 (for 24 minutes of simulation) which is largely feasible in recursive. Let's have a try with this approach.
Soo I hope to not reach the StackOverflowError.

Well... I didn't reach the StackOverflowError but it takes a lot of time (i.e. 2+ seconds for deep diving in 19 minutes). There still has a lot of states to explore after these depth of 19.
The piece of code that leads to too much time is:
```java
private long getLargestNumberOfGeodesThatCanBeOpenedAfter(BlueprintSimulationState currentState, int timeLeft) {
    // times up
    if (timeLeft == 0) {
        return currentState.getNumberOfCrackedGeodes();
    }

    List<Long> numbersOfGeodesCrackedAfterBuildRobot = new ArrayList<>();
    numbersOfGeodesCrackedAfterBuildRobot.add(getLargestNumberOfGeodesThatCanBeOpenedAfter(currentState.buildNothing(), timeLeft - 1));
    if (currentState.oreCollectingRobotCanBeBuilt()) {
        numbersOfGeodesCrackedAfterBuildRobot.add(getLargestNumberOfGeodesThatCanBeOpenedAfter(currentState.buildOreCollectingRobot(), timeLeft - 1));
    }
    if (currentState.clayCollectingRobotCanBeBuilt()) {
        numbersOfGeodesCrackedAfterBuildRobot.add(getLargestNumberOfGeodesThatCanBeOpenedAfter(currentState.buildClayCollectingRobot(), timeLeft - 1));
    }
    if (currentState.obsidianCollectingRobotCanBeBuilt()) {
        numbersOfGeodesCrackedAfterBuildRobot.add(getLargestNumberOfGeodesThatCanBeOpenedAfter(currentState.buildObsidianCollectingRobot(), timeLeft - 1));
    }
    if (currentState.geodeCrackingRobotCanBeBuilt()) {
        numbersOfGeodesCrackedAfterBuildRobot.add(getLargestNumberOfGeodesThatCanBeOpenedAfter(currentState.buildGeodeCrackingRobot(), timeLeft - 1));
    }

    return numbersOfGeodesCrackedAfterBuildRobot.stream()
            .max(Long::compare)
            .orElseThrow(() -> new RuntimeException("No element in numbersOfGeodesCrackedAfterBuildRobot"));
}
```

It should be possible to bypass some obvious states that lead to pour geode cracking.
Even if my intuition tells me that doing nothing can sometimes be beneficial to build a high value Robot, I should have a try to not explore doing nothing. This will decrease the possible states from 5^24 to 4^24.

My intuition was right. Sometimes, doing nothing leads to a better situation.
So it's not the good method to reduce the number of possibilities.

What If I can jump to a significant state change instead of evaluating all the intermediate states ?

I can know the time we have to wait before creating the next Robot.
Let's say I have 3 OreCollectingRobots and only 1 Ore in hand, so to build an ObsidianCollectingRobot that need 10 Ore, I have to wait 3 minutes. So no need to simulate the 3 DoingNothing states (without creating them) to reach the next useful State.

Let's have a try to reduce the calculation time by reducing the number of SimulationState to explore.

Ok, I succeed to reduce drastically the resolution time but at cost of a bug.
The answer is not good.

Ah, I found it, I had a ceil problem when dividing the number of resources per the number of robots for this resource to know the time to be spent before building a new robot. 


## Part 2

As usual, just increasing the volumes of calculation to do.

As I used a recursive algo to find the best steps to do to maximize the number geodes, I don't suffer any OutOfMemoryError because the tree has only a depth of 32.

I just had to wait longer to resolve the second puzzle.

I suppose there is some other optimisation to implement but having the right answer in 2 minutes 30 sec is acceptable for me.
Searching improvement will cost me a lot of time, and I'm too tired.

