package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.exceptions.InvalidExpressionException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EvaluatorUI extends JFrame implements ActionListener {
    // 20 buttons on the calculator numbered from left to right, top to bottom.
    private static final String[] BUTTON_TEXT = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", "^", "=", "/",
        "(", ")", "C", "CE",
    };

    private final TextField expressionTextField = new TextField();
    private final Evaluator evaluator = new Evaluator();

    public static void main(String[] argv) {
        new EvaluatorUI();
    }

    /** Creates the Calculator GUI and sets up all button listeners. */
    public EvaluatorUI() {
        setLayout(new BorderLayout());
        expressionTextField.setPreferredSize(new Dimension(600, 50));
        expressionTextField.setFont(new Font("Courier", Font.BOLD, 28));

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        Panel buttonPanel = new Panel();
        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        Button[] buttons = new Button[BUTTON_TEXT.length];
        for (int i = 0; i < BUTTON_TEXT.length; i++) {
            buttons[i] = new Button(BUTTON_TEXT[i]);
            buttons[i].setFont(new Font("Courier", Font.BOLD, 28));
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * This function is triggered anytime a button is pressed on the Calculator GUI.
     *
     * @param actionEventObject Event object generated when a button is pressed.
     */
    public void actionPerformed(ActionEvent actionEventObject) {
        String actionCommand = actionEventObject.getActionCommand();
        if (actionCommand.equals("C")) {
            String expression = expressionTextField.getText();
            if (!expression.isEmpty()) {
                expressionTextField.setText(expression.substring(0, expression.length() - 1));
            }
        } else if (actionCommand.equals("CE")) {
            expressionTextField.setText("");
        } else if (actionCommand.equals("=")) {
            String expression = expressionTextField.getText();
            if (expression.isEmpty()) {
                return;
            }

            try {
                int value = evaluator.evaluateExpression(expression);
                expressionTextField.setText(String.format("%d", value));
            } catch (InvalidExpressionException exception) {
                expressionTextField.setText("ERROR");
                exception.printStackTrace();
            }
        } else {
            expressionTextField.setText(expressionTextField.getText() + actionCommand);
        }
    }
}
