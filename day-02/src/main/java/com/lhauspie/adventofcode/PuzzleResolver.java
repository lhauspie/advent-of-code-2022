package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.adapter.RightDecryptor;
import com.lhauspie.adventofcode.adapter.WrongDecryptor;
import com.lhauspie.adventofcode.model.Game;
import com.lhauspie.adventofcode.model.Round;
import com.lhauspie.adventofcode.model.Score;

import java.util.Scanner;

public class PuzzleResolver {

    public static Score resolveFirstPuzzle(Scanner scanner) {
        var game = new Game();

        while (scanner.hasNextLine()) {
            String[] letters = scanner.nextLine().split(" ");
            var opponentHandShape = WrongDecryptor.decryptOpponentEncryptedValue(letters[0]);
            var myHandShape = WrongDecryptor.decryptMyEncryptedValue(letters[1]);
            game.play(new Round(myHandShape, opponentHandShape));
        }

        return game.getGameScore();
    }

    public static Score resolveSecondPuzzle(Scanner scanner) {
        var game = new Game();

        while (scanner.hasNextLine()) {
            String[] letters = scanner.nextLine().split(" ");
            var opponentHandShape = RightDecryptor.decryptOpponentEncryptedValue(letters[0]);
            var myHandShape = RightDecryptor.decryptMyEncryptedValue(opponentHandShape, letters[1]);
            game.play(new Round(myHandShape, opponentHandShape));
        }

        return game.getGameScore();
    }
}
