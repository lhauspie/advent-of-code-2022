package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.v2.Device;
import com.lhauspie.adventofcode.model.v2.subroutine.NoValidMarkerFoundException;
import com.lhauspie.adventofcode.model.v2.subroutine.StartOfMessageMarkerSubRoutine;
import com.lhauspie.adventofcode.model.v2.subroutine.StartOfPacketMarkerSubRoutine;
import com.lhauspie.adventofcode.model.v2.subroutine.SubRoutine;

import java.util.Scanner;

public class PuzzleResolver {

    public static int resolveFirstPuzzle(Scanner scanner) throws NoValidMarkerFoundException {
        return resolveWithSubRoutine(scanner, new StartOfPacketMarkerSubRoutine());
    }

    public static int resolveSecondPuzzle(Scanner scanner) throws NoValidMarkerFoundException {
        return resolveWithSubRoutine(scanner, new StartOfMessageMarkerSubRoutine());
    }

    private static int resolveWithSubRoutine(Scanner scanner, SubRoutine subRoutine)  throws NoValidMarkerFoundException {
        var device = new Device(subRoutine);
        String signal = scanner.nextLine();
        for (int charIndex = 0; charIndex < signal.length(); charIndex++) {
            device.receive(signal.charAt(charIndex));
        }
        return device.getSubRoutine().getNbAnalysedChars();
    }
}
