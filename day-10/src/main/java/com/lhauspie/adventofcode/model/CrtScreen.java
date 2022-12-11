package com.lhauspie.adventofcode.model;

public class CrtScreen {
    public static final int WIDTH = 40;
    public static final int HIGH = 6;

    private int spriteCenterPosition = 1;
    private int cycleCount = 0;
    private char[][] draws = new char[HIGH][WIDTH];

    public void executeInstruction(String instruction) {
        if (instruction.startsWith("addx")) {
            addX(Integer.parseInt(instruction.split(" ")[1]));
        } else {
            noop();
        }
    }

    public char getScreenContentAt(int x, int y) {
        return draws[y][x];
    }

    public String toString() {
        String screenContent = "";
        for (int i = 0; i < draws.length; i++) {
            for (int j = 0; j < draws[i].length; j++) {
                screenContent += draws[i][j];
            }
            screenContent += System.lineSeparator();
        }
        return screenContent;
    }

    private void addX(int addX) {
        draw();
        draw();
        spriteCenterPosition += addX;
    }

    private void noop() {
        draw();
    }

    private void draw() {
        drawChar();
        cycleCount++;
    }

    private void drawChar() {
        draws[getCurrentY()][getCurrentX()] = getCharToDraw();
    }

    private int getCurrentX() {
        return cycleCount % WIDTH;
    }

    private int getCurrentY() {
        return cycleCount / WIDTH;
    }

    private char getCharToDraw() {
        return spriteIsAtCurrentPosition() ? '#' : '.';
    }

    private boolean spriteIsAtCurrentPosition() {
        int currentX = getCurrentX();
        return spriteCenterPosition == currentX - 1
                || spriteCenterPosition == currentX
                || spriteCenterPosition == currentX + 1;
    }
}
