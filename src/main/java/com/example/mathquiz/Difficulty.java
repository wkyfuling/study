package com.example.mathquiz;

/**
 * Difficulty level controls the range of numbers used in generated questions.
 */
public enum Difficulty {
    EASY(0, 10),
    MEDIUM(0, 50),
    HARD(0, 100);

    private final int min;
    private final int max;

    Difficulty(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
