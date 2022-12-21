package com.lhauspie.adventofcode.day19;

import com.lhauspie.adventofcode.day19.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleResolver {

    public static long resolveFirstPuzzle(Scanner scanner) {
        List<Blueprint> blueprints = parseBlueprintList(scanner);
        return blueprints.stream()
                .map(blueprint -> blueprint.getQualityLevel(24))
                .mapToLong(value -> value)
                .sum();
    }

    public static long resolveSecondPuzzle(Scanner scanner) {
        List<Blueprint> blueprints = parseBlueprintList(scanner);
        return blueprints.stream()
                .limit(3)
                .map(blueprint -> blueprint.getLargestNumberOfGeodesThatCanBeOpened(32))
                .mapToLong(value -> value)
                .reduce((left, right) -> left * right)
                .getAsLong();
    }

    private static List<Blueprint> parseBlueprintList(Scanner scanner) {
        Pattern blueprintPattern = Pattern.compile("Blueprint ([0-9]+): Each ore robot costs ([0-9]+) ore. Each clay robot costs ([0-9]+) ore. Each obsidian robot costs ([0-9]+) ore and ([0-9]+) clay. Each geode robot costs ([0-9]+) ore and ([0-9]+) obsidian.");

        List<Blueprint> blueprints = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Matcher blueprintMatcher = blueprintPattern.matcher(scanner.nextLine());
            blueprintMatcher.find();

            blueprints.add(
                    new Blueprint(
                            Integer.parseInt(blueprintMatcher.group(1)),
                            new OreCollectingRobotRecipe(Integer.parseInt(blueprintMatcher.group(2))),
                            new ClayCollectingRobotRecipe(Integer.parseInt(blueprintMatcher.group(3))),
                            new ObsidianCollectingRobotRecipe(Integer.parseInt(blueprintMatcher.group(4)), Integer.parseInt(blueprintMatcher.group(5))),
                            new GeodeCrackingRobotRecipe(Integer.parseInt(blueprintMatcher.group(6)), 0, Integer.parseInt(blueprintMatcher.group(7)))
                    )
            );
        }
        return blueprints;
    }
}
