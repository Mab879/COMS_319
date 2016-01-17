package lab1;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class HelloWorldSwing2 {

    private JFrame frmHelloworldswing;
    private JTextField txtHelloWorld;
    private JLabel labelHelloWorld;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelloWorldSwing2 window = new HelloWorldSwing2();
                    window.frmHelloworldswing.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public HelloWorldSwing2() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmHelloworldswing = new JFrame();
        frmHelloworldswing.setTitle("HelloWorldSwing!");
        frmHelloworldswing.setSize(370, 220);
        frmHelloworldswing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frmHelloworldswing.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Text: ");
        panel.add(lblNewLabel);

        txtHelloWorld = new JTextField();
        txtHelloWorld.setText("Hello World");
        panel.add(txtHelloWorld);
        txtHelloWorld.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Size");
        panel.add(lblNewLabel_2);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"tiny", "small", "medium", "large"}));
        panel.add(comboBox);
        comboBox.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
            String sizeName = (String) cb.getSelectedItem();
            if (sizeName == "tiny") {
                labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont((float) 8.0));
            } else if (sizeName == "small") {
                labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont((float) 12.0));
            } else if(sizeName == "medium") {
                labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont((float) 20.0));
            }
            else if(sizeName == "large") {
                labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont((float) 24.0));

            }
        });

        JPanel panel_1 = new JPanel();
        frmHelloworldswing.getContentPane().add(panel_1, BorderLayout.WEST);
        panel_1.setLayout(new MigLayout("", "[109px]", "[23px][][][]"));

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Plain");
        panel_1.add(rdbtnNewRadioButton, "cell 0 0");

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Bold");
        panel_1.add(rdbtnNewRadioButton_1, "cell 0 1");

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Itaics");
        panel_1.add(rdbtnNewRadioButton_2, "cell 0 2");

        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Bold Itaics");
        panel_1.add(rdbtnNewRadioButton_3, "cell 0 3");

        rdbtnNewRadioButton.addActionListener(e -> {
            labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont(Font.PLAIN));
            rdbtnNewRadioButton.setSelected(true);
            rdbtnNewRadioButton_1.setSelected(false);
            rdbtnNewRadioButton_2.setSelected(false);
            rdbtnNewRadioButton_3.setSelected(false);
        });

        rdbtnNewRadioButton_1.addActionListener(e -> {
            labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont(Font.BOLD));
            rdbtnNewRadioButton.setSelected(false);
            rdbtnNewRadioButton_1.setSelected(true);
            rdbtnNewRadioButton_2.setSelected(false);
            rdbtnNewRadioButton_3.setSelected(false);
        });


        rdbtnNewRadioButton_2.addActionListener(e -> {
            labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont(Font.ITALIC));
            rdbtnNewRadioButton.setSelected(false);
            rdbtnNewRadioButton_1.setSelected(false);
            rdbtnNewRadioButton_2.setSelected(true);
            rdbtnNewRadioButton_3.setSelected(false);
        });

        rdbtnNewRadioButton_3.addActionListener(e -> {
            labelHelloWorld.setFont(labelHelloWorld.getFont().deriveFont(Font.BOLD + Font.ITALIC));
            rdbtnNewRadioButton.setSelected(false);
            rdbtnNewRadioButton_1.setSelected(false);
            rdbtnNewRadioButton_2.setSelected(false);
            rdbtnNewRadioButton_3.setSelected(true);
        });

        JPanel panel_2 = new JPanel();
        frmHelloworldswing.getContentPane().add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Show!");
        panel_2.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Exit");
        panel_2.add(btnNewButton_1);

        btnNewButton.addActionListener(e -> {
            if(labelHelloWorld.getForeground() == Color.black) {
                labelHelloWorld.setForeground(Color.red);
            }
            else {
                labelHelloWorld.setForeground(Color.black);
            }
            labelHelloWorld.setText(txtHelloWorld.getText());
        });

        btnNewButton_1.addActionListener(e -> {
            System.exit(1);
        });

        labelHelloWorld = new JLabel("Hello World");
        frmHelloworldswing.getContentPane().add(labelHelloWorld, BorderLayout.CENTER);
    }

}
