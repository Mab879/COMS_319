package lab1;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class HelloWorldSwing {
    private static JTextField textField;
    private static JLabel l;

    public static void main(String[] args) {
        JFrame f = new JFrame("HelloWorldSwing");
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
                l.setFont(l.getFont().deriveFont((float) 8.0));
            } else if (sizeName == "small") {
                l.setFont(l.getFont().deriveFont((float) 12.0));
            } else if(sizeName == "medium") {
                l.setFont(l.getFont().deriveFont((float) 20.0));
            }
            else if(sizeName == "large") {
                l.setFont(l.getFont().deriveFont((float) 24.0));

            }
        });
        p.add(combo);
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
            l.setFont(l.getFont().deriveFont(Font.PLAIN));
            r1.setSelected(true);
            r2.setSelected(false);
            r3.setSelected(false);
            r4.setSelected(false);
        });

        r2.addActionListener(e -> {
            l.setFont(l.getFont().deriveFont(Font.BOLD));
            r1.setSelected(false);
            r2.setSelected(true);
            r3.setSelected(false);
            r4.setSelected(false);
        });


        r3.addActionListener(e -> {
            l.setFont(l.getFont().deriveFont(Font.ITALIC));
            r1.setSelected(false);
            r2.setSelected(false);
            r3.setSelected(true);
            r4.setSelected(false);
        });

        r4.addActionListener(e -> {
            l.setFont(l.getFont().deriveFont(Font.BOLD + Font.ITALIC));
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
        l = new JLabel("Hello World!");
        p.add(l);
        return p;
    }

    private static JPanel setupBottom() {
        JPanel p = new JPanel();
        JButton b1 = new JButton("Show!");
        JButton b2 = new JButton("Exit");
        p.add(b1);
        p.add(b2);

        b1.addActionListener(e -> {
            l.setText(textField.getText());
        });

        b2.addActionListener(e -> {
            System.exit(1);
        });

        return p;
    }



}
