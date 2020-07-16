package UI.utilities;

import javax.swing.*;
import java.awt.*;


public class JTextFieldPicker extends JPanel {

    private JLabel label;
    private JTextField textField;
    //private JComboBox comboBox;

    public JTextFieldPicker(String textFieldLabel, String textFieldDefault) {


        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        // creates the GUI
        label = new JLabel(textFieldLabel);
        textField = new JTextField(textFieldDefault, 10);
        textField.setFont(Font.getFont(Font.SERIF));


        add(label);
        add(textField);

    }

}
