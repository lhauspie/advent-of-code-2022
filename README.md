# Advent of Code 2022

This year, I decided to practice some development practices that I'm not comfortable with.

By coding during this Advent of Code I hope to learn or improve some development practices like TDD, DDD, Clean Code.

Just let try and see what will happen during this journey.

## Starting by the model

As we start the puzzle resolution process by a partial understanding of the problem to solve, almost in all the case, starting by coding the model will locks us quite easily in an inadequate model that could be difficult to adapt.


## Over engineering

The first thing I can notice is that if we start to over engineer the model, we'll have some difficulties to adapt it in case of partial comprehension of the global problem.
It was particularly the case during the day-05 and day-06.
I spent a lot of time to adapt the model.
The good thing is that the resulting model is really near to the reality.

Over engineering is time expensive.


## Adding test during the refactor phase

Sometimes, I refactored my code to split the problem in smaller pieces.
During the refactor, I made some regressions, we're human after all. And as human, we make some mistakes.

But the problem is that when we have tens of tests KO, it's pretty difficult to know where the issue comes from exactly...

So I started to add some tests during the refactor phase in `day-15` and it was much more easier to detect bugs as soon as possible.


## Code quality and modeling

Often, when I read code that I don't know (on open source projects for example), I am surprised by the readability and I often think that I wouldn't be able to deliver code of this quality.

One thing I realized with this Advent of Code is that the first draft of a code is often rotten and it needs to be refactored to refine the model, functions, variable names, class names and so on.

Another thing I realized is that the modeling of a problem remains personal.
You can always argue with a developer's choices in modeling, so you have to learn to receive this kind of feedback as a developer and not be egotistical.

A quality code is a long way to go, but it's rewarding once it's done.

## TDD

TDD is a practice that ensures that the application's behavior is consistent with that expected by the tests.
It does not, however, allow to be completely bug free.
If the test is buggy, the code will inevitably be buggy too.

The great strength of TDD is to start from very simple cases and to complete the cases little by little, which allows to complete the code as we go along to cover all the cases or all the features.

Unfortunately, this approach is not 100% adapted to solving advent of code puzzles.
Why not? Simply because there are too few test cases and it becomes easy to code unrealistic or even completely wrong tests due to a bad understanding of the problem.

Let's take the example of the day-24 puzzle, it's about counting the minimum number of rounds to go from a starting point to a goal point.
The statement gives only 1 example and it becomes difficult to imagine other examples while being sure of the expected result.
Example given in the statement:
```
#.######
#>>.<^<#
#.<..<<#
#>v.><>#
#<^v^^>#
######.#
```
It should give the result `18`.

But how can I be sure that a new example that I would have created myself gives a particular result?
I would have to do some manual simulations to calculate the result without being sure that I could get to the end of the simulation.
I'm pretty sure that changing a single blizzard could make it impossible to reach the end point...

TDD is therefore an extraordinary practice that allows you to complete your code as you go along to cover all the cases and let the design emerge.
But this practice is not very well adapted to solve the puzzles of the advent of code because it is necessary to code very quickly the whole algorithm even to solve a much smaller problem like the following one.
```
#.###
#>.<#
#.^.#
###.#
```

So, as usual, TDD is not a silver bullet to solve all development issues.
The problem must be splittable into smaller pieces to benefit from the iterative approach of TDD.