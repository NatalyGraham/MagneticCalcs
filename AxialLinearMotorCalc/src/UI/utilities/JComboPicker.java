package UI.utilities;

import javax.swing.*;
import java.awt.*;


public class JComboPicker extends JPanel {

    private JLabel label;
    private JComboBox comboBox;

    public JComboPicker(String textFieldLabel, String[] comboList) {


        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        // creates the GUI
        label = new JLabel(textFieldLabel);
        comboBox = new JComboBox(comboList);
        comboBox.setEditable(true);
        comboBox.setFont(Font.getFont(Font.SERIF));

        add(label);
        add(comboBox);

    }

}
