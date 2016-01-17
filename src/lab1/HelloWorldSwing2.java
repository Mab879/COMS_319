package lab1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class HelloWorldSwing2 {

    private JFrame frmHelloworldswing;
    private JTextField txtHelloWorld;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelloWorldSwing window = new HelloWorldSwing();
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
    public HelloWorldSwing() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmHelloworldswing = new JFrame();
        frmHelloworldswing.setTitle("HelloWorldSwing");
        frmHelloworldswing.setBounds(100, 100, 450, 300);
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

        JPanel panel_2 = new JPanel();
        frmHelloworldswing.getContentPane().add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("Show!");
        panel_2.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Exit");
        panel_2.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("Hello");
        frmHelloworldswing.getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
    }

}
