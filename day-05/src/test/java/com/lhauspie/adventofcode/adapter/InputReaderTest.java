package com.lhauspie.adventofcode.adapter;

import com.lhauspie.adventofcode.model.Move;
import com.lhauspie.adventofcode.model.Position;
import com.lhauspie.adventofcode.model.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputReaderTest {

    @Test
    public void testInputExample() {
        // GIVEN
        var input = """
                    [D]    
                [N] [C]    
                [Z] [M] [P]
                 1   2   3 
                """;

        // WHEN
        Ship ship = InputReader.inputShipContentToShip(input);

        // THEN
        assertEquals("N", ship.take(Position.of(1)).getMark());
        assertEquals("Z", ship.take(Position.of(1)).getMark());
        assertEquals("D", ship.take(Position.of(2)).getMark());
        assertEquals("C", ship.take(Position.of(2)).getMark());
        assertEquals("M", ship.take(Position.of(2)).getMark());
        assertEquals("P", ship.take(Position.of(3)).getMark());
    }

    @Test
    public void testInput() {
        // GIVEN
        var input = """
                        [H]         [S]         [D]
                    [S] [C]         [C]     [Q] [L]
                    [C] [R] [Z]     [R]     [H] [Z]
                    [G] [N] [H] [S] [B]     [R] [F]
                [D] [T] [Q] [F] [Q] [Z]     [Z] [N]
                [Z] [W] [F] [N] [F] [W] [J] [V] [G]
                [T] [R] [B] [C] [L] [P] [F] [L] [H]
                [H] [Q] [P] [L] [G] [V] [Z] [D] [B]
                 1   2   3   4   5   6   7   8   9
                """;

        // WHEN
        Ship ship = InputReader.inputShipContentToShip(input);

        // THEN
        assertEquals("J", ship.take(Position.of(7)).getMark());
        assertEquals("F", ship.take(Position.of(7)).getMark());
        assertEquals("Z", ship.take(Position.of(7)).getMark());

        assertEquals("D", ship.take(Position.of(9)).getMark());
        assertEquals("L", ship.take(Position.of(9)).getMark());
        assertEquals("Z", ship.take(Position.of(9)).getMark());
        assertEquals("F", ship.take(Position.of(9)).getMark());
        assertEquals("N", ship.take(Position.of(9)).getMark());
        assertEquals("G", ship.take(Position.of(9)).getMark());
        assertEquals("H", ship.take(Position.of(9)).getMark());
        assertEquals("B", ship.take(Position.of(9)).getMark());
    }

    @Test
    public void canParseInputMoveContent() {
        // WHEN
        Move move = InputReader.inputMoveContentToMove("move 1 from 2 to 1");

        // THEN
        assertEquals(1, move.getQuantity().getValue());
        assertEquals(2, move.getSource().getValue());
        assertEquals(1, move.getTarget().getValue());
    }
}
