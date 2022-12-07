package com.lhauspie.adventofcode.model.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignalTest {

    @Test
    public void firstMarkerIsEqualsToChars() {
        assertEquals(Marker.of("azer"), Signal.of("azertytreza").nextMarker());
    }

    @Test
    public void secondMarkerIsEqualsToCharsOneToFive() {
        var signal = Signal.of("azertytreza");
        signal.nextMarker();
        assertEquals(Marker.of("zert"), signal.nextMarker());
    }

    @Test
    public void thirdMarkerIsEqualsToCharsTwoToSix() {
        var signal = Signal.of("azertytreza");
        signal.nextMarker();
        signal.nextMarker();
        assertEquals(Marker.of("erty"), signal.nextMarker());
    }

    @Test
    public void getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartMarker() {
        var signal = Signal.of("azaearatayauaiaoapaoiuytrez");
        assertEquals(21, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }

    @Test
    public void firstInputExampleShouldReturnSeven() {
        var signal = Signal.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        assertEquals(7, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }

    @Test
    public void secondInputExampleShouldReturnFive() {
        var signal = Signal.of("bvwbjplbgvbhsrlpgdmjqwftvncz");
        assertEquals(5, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }

    @Test
    public void thirdInputExampleShouldReturnSix() {
        var signal = Signal.of("nppdvjthqldpwncqszvftbrmjlhg");
        assertEquals(6, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }

    @Test
    public void fourthInputExampleShouldReturnTen() {
        var signal = Signal.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        assertEquals(10, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }

    @Test
    public void fifthInputExampleShouldReturnEleven() {
        var signal = Signal.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");
        assertEquals(11, signal.getNumberOfCharsFromBeginningOfBufferToEndOfFirstStartOfPacketMarker());
    }
}
