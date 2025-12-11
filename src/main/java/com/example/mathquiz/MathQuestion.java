package com.example.mathquiz;

import java.util.Objects;

/**
 * Represents a single arithmetic question with an expected numeric answer.
 */
public class MathQuestion {
    public enum Operation {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("×"),
        DIVIDE("÷");

        private final String symbol;

        Operation(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    private final int left;
    private final int right;
    private final Operation operation;
    private final double answer;

    public MathQuestion(int left, int right, Operation operation, double answer) {
        this.left = left;
        this.right = right;
        this.operation = Objects.requireNonNull(operation);
        this.answer = answer;
    }

    public String getPrompt() {
        return left + " " + operation.getSymbol() + " " + right + " = ";
    }

    public double getAnswer() {
        return answer;
    }

    public boolean isCorrect(double value) {
        double tolerance = 0.01;
        return Math.abs(value - answer) < tolerance;
    }
}
