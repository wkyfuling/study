package com.example.mathquiz;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates math questions and evaluates user answers.
 */
public class MathQuizEngine {
    private final Random random = new SecureRandom();
    private final Difficulty difficulty;
    private final int totalQuestions;
    private final List<MathQuestion> questions = new ArrayList<>();

    public MathQuizEngine(Difficulty difficulty, int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Total questions must be positive");
        }
        this.difficulty = difficulty;
        this.totalQuestions = totalQuestions;
        generateQuestions();
    }

    public List<MathQuestion> getQuestions() {
        return questions;
    }

    private void generateQuestions() {
        for (int i = 0; i < totalQuestions; i++) {
            questions.add(createQuestion());
        }
    }

    private MathQuestion createQuestion() {
        MathQuestion.Operation[] operations = MathQuestion.Operation.values();
        MathQuestion.Operation op = operations[random.nextInt(operations.length)];

        int min = difficulty.getMin();
        int max = difficulty.getMax();

        int left = random.nextInt(max - min + 1) + min;
        int right = random.nextInt(max - min + 1) + min;

        switch (op) {
            case ADD:
                return new MathQuestion(left, right, op, left + right);
            case SUBTRACT:
                return new MathQuestion(left, right, op, left - right);
            case MULTIPLY:
                return new MathQuestion(left, right, op, left * right);
            case DIVIDE:
                int divisor = Math.max(1, right);
                int quotient = random.nextInt(max / Math.max(1, divisor) + 1);
                int dividend = divisor * quotient;
                return new MathQuestion(dividend, divisor, op, quotient);
            default:
                throw new IllegalStateException("Unexpected value: " + op);
        }
    }
}
