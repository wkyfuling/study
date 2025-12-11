package com.example.mathquiz;

import java.util.Locale;
import java.util.Scanner;

/**
 * Simple console-based math quiz for primary school students.
 */
public class MathQuizApp {
    private final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        new MathQuizApp().run();
    }

    private void run() {
        printBanner();
        Difficulty difficulty = chooseDifficulty();
        int questionCount = chooseQuestionCount();

        MathQuizEngine engine = new MathQuizEngine(difficulty, questionCount);

        int score = 0;
        for (int i = 0; i < engine.getQuestions().size(); i++) {
            MathQuestion question = engine.getQuestions().get(i);
            System.out.printf("题目 %d/%d: %s", i + 1, questionCount, question.getPrompt());
            double answer = readDouble();
            if (question.isCorrect(answer)) {
                System.out.println("✓ 回答正确！\n");
                score++;
            } else {
                System.out.printf("✗ 回答错误，正确答案是 %.2f。\n\n", question.getAnswer());
            }
        }

        System.out.printf("测试结束！您的得分是 %d/%d。%n", score, questionCount);
    }

    private void printBanner() {
        System.out.println("============================");
        System.out.println("   小学生数学测试系统");
        System.out.println("============================\n");
    }

    private Difficulty chooseDifficulty() {
        System.out.println("请选择难度: 1) 简单  2) 中等  3) 困难");
        while (true) {
            System.out.print("输入数字 1-3: ");
            int option = readInt();
            switch (option) {
                case 1:
                    return Difficulty.EASY;
                case 2:
                    return Difficulty.MEDIUM;
                case 3:
                    return Difficulty.HARD;
                default:
                    System.out.println("无效的选择，请重新输入。");
            }
        }
    }

    private int chooseQuestionCount() {
        System.out.print("请输入题目数量(5-30): ");
        while (true) {
            int count = readInt();
            if (count >= 5 && count <= 30) {
                return count;
            }
            System.out.print("数量应在5到30之间，请重新输入: ");
        }
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("请输入有效的整数: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("请输入数字答案: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
