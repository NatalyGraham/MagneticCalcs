package UI;

import UI.utilities.JComboPicker;
import UI.utilities.JFilePicker;
import UI.utilities.JTextFieldPicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;


public class SettingsWindow implements ActionListener {

    private JFrame setWindow;
    private JPanel labelSet;
    private JPanel fieldSet;
    private JButton acceptBt;
    private JButton declineBt;
    private final int dimX = 650;
    private final int dimY = 400;
    private String title;
    private final String defaultPathFemm = "C:\\femm42\\bin\\femm.exe";
    private final String defaultPathProject = "D:\\Projects\\MagneticProjects";


    public SettingsWindow() {

        title = "Настройки";
        setWindow = new JFrame(title);
        setWindow.setSize(dimX, dimY);
        setWindow.setLocationRelativeTo(null);
        setWindow.setResizable(false);
        setWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setWindow.setBackground(Color.LIGHT_GRAY);
        setWindow.setVisible(true);


        labelSet = new JPanel();
        //labelSet.setLayout(new BoxLayout(labelSet, BoxLayout.Y_AXIS));

        fieldSet = new JPanel();
        fieldSet.setLayout(new BoxLayout(fieldSet, BoxLayout.Y_AXIS));

        fieldSet.add(new JLabel("              "));
        fieldSet.add(new JLabel("              "));


        // Ввод пути к Femm
        JFilePicker fpFemm = new JFilePicker("   Укажите путь к файлу femm.exe:         ",
                defaultPathFemm,
                "Browse...");

        fpFemm.setMode(JFilePicker.MODE_OPEN);
        fpFemm.addFileTypeFilter(".exe", "Windows Executable File");
        fpFemm.setFileTypeFilter(".exe", "Windows Executable File");
        fpFemm.getFileChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);


        // Ввод пути к проекту
        JFilePicker fpProject = new JFilePicker("   Дирректория проекта по умолчанию: ",
                defaultPathProject,
                "Browse...");

        fpProject.setMode(JFilePicker.MODE_SAVE);
        fpProject.getFileChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);


        String[] cpDim = {"mm", "m"};
        JComboPicker cpDimention = new JComboPicker("Выберите систему измерения           ", cpDim);

        String[] cpType = {"Axisymmetric", "Planar"};
        JComboPicker cpMagType = new JComboPicker("Тип магнтной задачи                            ", cpType);

        String[] cpParCalcs = {"1", "2", "3", "4", "5", "6"};
        JComboPicker cpParallrelCalcs = new JComboPicker("Число параллельных расчетов      ", cpParCalcs);

        JTextFieldPicker defaultFrequency = new JTextFieldPicker("Частота, Гц                                              ",
                "0");


        fieldSet.add(fpFemm);
        fieldSet.add(fpProject);
        fieldSet.add(cpDimention);
        fieldSet.add(cpMagType);
        fieldSet.add(cpParallrelCalcs);
        fieldSet.add(defaultFrequency);

        acceptBt = new JButton("Применить");
        acceptBt.addActionListener(this);
        declineBt = new JButton("Отмена");
        declineBt.addActionListener(this);


        labelSet.add(acceptBt);
        labelSet.add(declineBt);

        setWindow.getContentPane().add(BorderLayout.NORTH, fieldSet);
        setWindow.getContentPane().add(BorderLayout.SOUTH, labelSet);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptBt)
            //TODO: сделать сохранялку введенных параметров
           setWindow.dispose();
        if (e.getSource() == declineBt)
            setWindow.dispose();
    }
}
