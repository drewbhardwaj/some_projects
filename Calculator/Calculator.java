/** This code is contributed by @drewbhardwaj;*/

package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField tField;
    JButton[] numBut = new JButton[10];
    JButton[] funBut = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Magneto", Font.BOLD, 40);

    double num1 = 0, num2 = 0, result = 0;
    char op;

    Calculator() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 550);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);

        tField = new JTextField();
        tField.setBounds(10, 25, 300, 50);
        tField.setFont(myFont);
        tField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<--");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        funBut[0] = addButton;
        funBut[1] = subButton;
        funBut[2] = mulButton;
        funBut[3] = divButton;
        funBut[4] = decButton;
        funBut[5] = equButton;
        funBut[6] = delButton;
        funBut[7] = clrButton;
        funBut[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funBut[i].addActionListener(this);
            funBut[i].setFont(myFont);
            funBut[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++) {
            numBut[i] = new JButton(String.valueOf(i));
            numBut[i].addActionListener(this);
            numBut[i].setFont(myFont);
            numBut[i].setFocusable(false);
        }

        negButton.setBounds(10, 430, 90, 50);
        delButton.setBounds(110, 430, 90, 50);
        clrButton.setBounds(210, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(10, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numBut[1]);
        panel.add(numBut[2]);
        panel.add(numBut[3]);
        panel.add(addButton);
        panel.add(numBut[4]);
        panel.add(numBut[5]);
        panel.add(numBut[6]);
        panel.add(subButton);
        panel.add(numBut[7]);
        panel.add(numBut[8]);
        panel.add(numBut[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numBut[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(tField);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numBut[i]) {
                tField.setText(tField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            tField.setText(tField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(tField.getText());
            op = '+';
            tField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(tField.getText());
            op = '-';
            tField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(tField.getText());
            op = '*';
            tField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(tField.getText());
            op = '/';
            tField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(tField.getText());

            switch (op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            tField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            tField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = tField.getText();
            tField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                tField.setText(tField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(tField.getText());
            temp *= -1;
            tField.setText(String.valueOf(temp));
        }
    }
}