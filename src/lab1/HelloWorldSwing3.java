package lab1;

import java.awt.*;
import javax.swing.*;

import static java.lang.Thread.sleep;

public class HelloWorldSwing3 {
    private static JTextField textField, timeOutTextField;
    private static JLabel outputLabel, errorLabel;
    private static JCheckBox timeOutCheckBox;
    private static JFrame f;
    public static void main(String[] args) {
        f = new JFrame("HelloWorldSwing");
        f.setSize(370, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel m = new JPanel();
        m.setLayout(new BoxLayout(m, BoxLayout.Y_AXIS));
        f.add(m, BorderLayout.PAGE_START);
        m.add(setupTop(), BorderLayout.LINE_START);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
        middlePanel.add(setupMiddleLeft(), BorderLayout.WEST);
        middlePanel.add(setupMiddleRight(), BorderLayout.EAST);
        m.add(middlePanel);
        m.add(setupBottom());
        f.setVisible(true);
    }

    private static JPanel setupTop() {
        JPanel p = new JPanel();
        p.add(new JLabel("Text: "));
        textField = new JTextField("Hello World!");
        p.add(textField);
        String[] sizes = { "tiny", "small", "medium", "large" };
        JComboBox<String> combo = new JComboBox<String>(sizes);
        combo.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
            String sizeName = (String) cb.getSelectedItem();
            if (sizeName == "tiny") {
                outputLabel.setFont(outputLabel.getFont().deriveFont((float) 8.0));
            } else if (sizeName == "small") {
                outputLabel.setFont(outputLabel.getFont().deriveFont((float) 12.0));
            } else if(sizeName == "medium") {
                outputLabel.setFont(outputLabel.getFont().deriveFont((float) 20.0));
            }
            else if(sizeName == "large") {
                outputLabel.setFont(outputLabel.getFont().deriveFont((float) 24.0));

            }
        });
        p.add(combo);
        timeOutCheckBox = new JCheckBox();
        p.add(timeOutCheckBox);
        p.add(new JLabel("clear after: "));
        timeOutTextField = new JTextField("5");
        p.add(timeOutTextField);
        return p;
    }

    private static JPanel setupMiddleLeft() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        JRadioButton r1 = new JRadioButton("Plain");
        JRadioButton r2 = new JRadioButton("Bold");
        JRadioButton r3 = new JRadioButton("Italic");
        JRadioButton r4 = new JRadioButton("Bold Italic");

        r1.addActionListener(e -> {
            outputLabel.setFont(outputLabel.getFont().deriveFont(Font.PLAIN));
            r1.setSelected(true);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(false);
        });

        r2.addActionListener(e -> {
            outputLabel.setFont(outputLabel.getFont().deriveFont(Font.BOLD));
            r1.setSelected(false);
            r2.setSelected(true);
            r3.setSelected(false);
            r4.setSelected(false);
        });


        r3.addActionListener(e -> {
            outputLabel.setFont(outputLabel.getFont().deriveFont(Font.ITALIC));
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(true);
            r4.setSelected(false);
        });

        r4.addActionListener(e -> {
            outputLabel.setFont(outputLabel.getFont().deriveFont(Font.BOLD + Font.ITALIC));
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(true);
        });

        p.add(r1);
        p.add(r2);
        p.add(r3);
        p.add(r4);

        return p;
    }

    private static JPanel setupMiddleRight() {
        JPanel p = new JPanel();
        outputLabel = new JLabel("Hello World!");
        p.add(outputLabel);
        return p;
    }

    private static JPanel setupBottom() {
        JPanel p = new JPanel();
        JButton b1 = new JButton("Show!");
        JButton b2 = new JButton("Exit");
        errorLabel = new JLabel("");
        p.add(b1);
        p.add(errorLabel);
        p.add(b2);

        b1.addActionListener(e -> {
            outputLabel.setText(textField.getText());
            if(timeOutCheckBox.isSelected()) {
                long timeOut = 5;
                try {
                    timeOut = Integer.parseInt(timeOutTextField.getText());
                    errorLabel.setText("");
                }
                catch (NumberFormatException ex) {
                    errorLabel.setText("Timeout is not a number.");
                    timeOutTextField.setText("5");
                    timeOut = 5;
                }
                f.repaint();
                if(timeOut < 0 || timeOut > 10) {
                    errorLabel.setText("Timeout must be an integer between 1 and 10.");
                }
            }
        });

        b2.addActionListener(e -> {
            System.exit(1);
        });

        return p;
    }



}
