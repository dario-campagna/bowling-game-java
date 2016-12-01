package it.esteco.bowling;

public class Game {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += strikeScore(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += spareScore(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeScore(int frameIndex) {
        return 10 + rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int spareScore(int frameIndex) {
        return 10 + rolls[frameIndex + 2];
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
}
