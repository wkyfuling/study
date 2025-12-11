package com.example.mathquiz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * Swing-based GUI for the math quiz.
 */
public class MathQuizGUI extends JFrame {
    private static final DecimalFormat SCORE_FORMAT = new DecimalFormat("0");

    private final JComboBox<Difficulty> difficultyBox = new JComboBox<>(Difficulty.values());
    private final JSpinner questionSpinner = new JSpinner(new SpinnerNumberModel(10, 5, 30, 1));
    private final JButton startButton = new JButton("开始测试");

    private final JLabel progressLabel = new JLabel("准备开始", SwingConstants.CENTER);
    private final JLabel questionLabel = new JLabel("请选择难度并开始", SwingConstants.CENTER);
    private final JTextField answerField = new JTextField();
    private final JButton submitButton = new JButton("提交答案");
    private final JLabel feedbackLabel = new JLabel(" ", SwingConstants.CENTER);

    private MathQuizEngine engine;
    private int currentIndex;
    private int score;

    public MathQuizGUI() {
        super("小学生数学测试系统 (GUI)");
        buildUI();
        wireEvents();
    }

    private void buildUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(520, 360));
        setLocationRelativeTo(null);

        JPanel content = new JPanel(new BorderLayout(12, 12));
        content.setBorder(new EmptyBorder(12, 12, 12, 12));
        setContentPane(content);

        JLabel title = new JLabel("小学生数学测试系统", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        content.add(title, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("测试设置"));
        content.add(topPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(new JLabel("难度"), gbc);
        gbc.gridx = 1;
        topPanel.add(difficultyBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        topPanel.add(new JLabel("题目数量"), gbc);
        gbc.gridx = 1;
        topPanel.add(questionSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        topPanel.add(startButton, gbc);

        JPanel centerPanel = new JPanel(new BorderLayout(8, 8));
        centerPanel.setBorder(BorderFactory.createTitledBorder("答题区"));
        content.add(centerPanel, BorderLayout.CENTER);

        progressLabel.setFont(progressLabel.getFont().deriveFont(Font.PLAIN, 14f));
        centerPanel.add(progressLabel, BorderLayout.NORTH);

        questionLabel.setFont(questionLabel.getFont().deriveFont(Font.BOLD, 18f));
        centerPanel.add(questionLabel, BorderLayout.CENTER);

        JPanel answerPanel = new JPanel(new BorderLayout(6, 6));
        answerField.setEnabled(false);
        submitButton.setEnabled(false);
        answerPanel.add(answerField, BorderLayout.CENTER);
        answerPanel.add(submitButton, BorderLayout.EAST);
        centerPanel.add(answerPanel, BorderLayout.SOUTH);

        feedbackLabel.setOpaque(true);
        feedbackLabel.setBackground(new Color(245, 245, 245));
        feedbackLabel.setBorder(new EmptyBorder(8, 8, 8, 8));
        content.add(feedbackLabel, BorderLayout.SOUTH);
    }

    private void wireEvents() {
        startButton.addActionListener(e -> startQuiz());
        submitButton.addActionListener(e -> submitAnswer());
        answerField.addActionListener(e -> submitAnswer());
    }

    private void startQuiz() {
        Difficulty difficulty = (Difficulty) difficultyBox.getSelectedItem();
        int total = ((Number) questionSpinner.getValue()).intValue();
        engine = new MathQuizEngine(difficulty, total);
        currentIndex = 0;
        score = 0;
        feedbackLabel.setText(" ");
        feedbackLabel.setBackground(new Color(245, 245, 245));

        answerField.setEnabled(true);
        submitButton.setEnabled(true);
        answerField.setText("");
        answerField.requestFocusInWindow();
        updateQuestionView();
    }

    private void submitAnswer() {
        if (engine == null || currentIndex >= engine.getQuestions().size()) {
            return;
        }

        String input = answerField.getText().trim();
        double value;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "请输入数字答案", "提示", JOptionPane.INFORMATION_MESSAGE);
            answerField.requestFocusInWindow();
            return;
        }

        MathQuestion question = engine.getQuestions().get(currentIndex);
        boolean correct = question.isCorrect(value);
        if (correct) {
            score++;
            feedbackLabel.setText("✓ 回答正确！");
            feedbackLabel.setBackground(new Color(210, 245, 210));
        } else {
            feedbackLabel.setText(String.format("✗ 正确答案是 %.2f", question.getAnswer()));
            feedbackLabel.setBackground(new Color(245, 220, 220));
        }

        currentIndex++;
        if (currentIndex >= engine.getQuestions().size()) {
            endQuiz();
        } else {
            updateQuestionView();
            answerField.setText("");
            answerField.requestFocusInWindow();
        }
    }

    private void updateQuestionView() {
        MathQuestion question = engine.getQuestions().get(currentIndex);
        int total = engine.getQuestions().size();
        progressLabel.setText(String.format("题目 %d/%d", currentIndex + 1, total));
        questionLabel.setText(question.getPrompt());
    }

    private void endQuiz() {
        answerField.setEnabled(false);
        submitButton.setEnabled(false);
        String scoreText = SCORE_FORMAT.format(score);
        String totalText = SCORE_FORMAT.format(engine.getQuestions().size());
        String message = String.format("测试结束！您的得分是 %s/%s。", scoreText, totalText);
        progressLabel.setText("测试完成");
        questionLabel.setText(message);
        JOptionPane.showMessageDialog(this, message, "成绩", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            setSystemLookAndFeel();
            new MathQuizGUI().setVisible(true);
        });
    }

    private static void setSystemLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {
            // Fallback to default if setting look and feel fails.
        }
    }
}
