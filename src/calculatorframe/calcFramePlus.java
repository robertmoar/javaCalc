package calculatorframe;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class calcFramePlus implements ActionListener {
    //  we declare here the needed arrays and variables of each type
    //  we are going to use later in the algorithm
    JFrame frame;
    JTextField textField;
    // array of buttons
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    // buttons type of JButton
    JButton addButton, subButton, mulButton, clrButton, negButton;
    JButton decButton, equButton, delButton, divButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    double num1=0, num2=0, result=0;
    char operator;
    // in order to be able to call calcFramePlus from another file
    // we need to make it public, otherwise we need to work only in the same file package
    public calcFramePlus () {
        // frame properties
            frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 550);
            frame.setLayout(null);

        //text field properties
            textField = new JTextField();
            textField.setBounds(50,25, 300, 50);
            textField.setFont(myFont);
            textField.setEditable(false);

        // assign buttons to a variable to be able to work with them
        // with the constructor method (not the buttons but his logic)
            addButton = new JButton("+");
            subButton = new JButton("-");
            mulButton = new JButton("*");
            divButton = new JButton("/");
            decButton = new JButton(".");
            equButton = new JButton("=");
            delButton = new JButton("Delete");
            clrButton = new JButton("Clear");
            negButton = new JButton("(-)");

       // assign created buttons(logic) to any position inside of the array of buttons
            functionButtons[0] = addButton;
            functionButtons[1] = subButton;
            functionButtons[2] = mulButton;
            functionButtons[3] = clrButton;
            functionButtons[4] = decButton;
            functionButtons[5] = equButton;
            functionButtons[6] = delButton;
            functionButtons[7] = divButton;
            functionButtons[8] = negButton;

       // with this bucle, we add actionlisteners to each button(logic),
       // and with .this, we make it related to the inside class scope
            for (int i = 0; i < 9; i++) {
                functionButtons[i].addActionListener(this);
                functionButtons[i].setFont(myFont);
                functionButtons[i].setFocusable(false);
            }

        //  we create the visible part of the buttons with the constructor method
        //  asigning font amd actionlistener
            for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
             }

        // we set the size and shape of the clear, substract nad delete buttons
            negButton.setBounds(50,430, 100, 50);
            delButton.setBounds(150, 430, 100, 50);
            clrButton.setBounds(250, 430, 100, 50);

        // layout and colors for the GUI of the panel
            panel = new JPanel();
            panel.setBounds(50, 100, 300, 300);
            panel.setLayout(new GridLayout(4, 4, 10, 10));
            panel.setBackground(Color.GRAY);

        // we add each button to the panel
            panel.add(numberButtons[1]);
            panel.add(numberButtons[2]);
            panel.add(numberButtons[3]);
            panel.add(addButton);
            panel.add(numberButtons[4]);
            panel.add(numberButtons[5]);
            panel.add(numberButtons[6]);
            panel.add(subButton);
            panel.add(numberButtons[7]);
            panel.add(numberButtons[8]);
            panel.add(numberButtons[9]);
            panel.add(mulButton);
            panel.add(decButton);
            panel.add(numberButtons[0]);
            panel.add(equButton);
            panel.add(divButton);

       // we invoque the panel to make it appear on the screen
            frame.add(panel);
            frame.add(negButton);
            frame.add(clrButton);
            frame.add(delButton);
            frame.add(textField);
       // this line make it visible
            frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      // logic of the calculator
        for (int i=0; i<10; i++) {
            if(e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // decimal dot, to make decimal operations (basic)
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        // sum button
        if(e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        //substraction button
        if(e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        //multipli button
        if(e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // divide button
        if(e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // equal button
        if(e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
        }
        // clear button, wipes out all the text field
        if(e.getSource() == clrButton) {
            textField.setText("");
        }
        // delete button, substrac -1 to the text field
        if(e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        // negative button, cast the numbers into his negative value
        if(e.getSource() == negButton) {
            double temp=Double.parseDouble(textField.getText());
            temp*= -1;
            textField.setText(String.valueOf(temp));
            }
    }
}

