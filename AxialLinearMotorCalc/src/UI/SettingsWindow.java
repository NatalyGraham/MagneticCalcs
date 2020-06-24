package UI;

import UI.utilities.JFilePicker;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFileChooser;


public class SettingsWindow {

    private JFrame setWindow;
    //private JPanel initialSettings;
    private JPanel labelSet;
    private JPanel fieldSet;
    private final int dimX = 650;
    private final int dimY = 400;
    private String title;
    private String defaultPathFemm = "C:\\femm42\\bin\\femm.exe";
    private String defaultPathProject = "D:\\Projects\\MagneticProjects";

    private JLabel text01, text02, text03, text04, text05, text06;

    public SettingsWindow() {

        //setWindow.setLayout(null);
        title = "Настройки";
        setWindow = new JFrame(title);
        setWindow.setSize(dimX, dimY);
        setWindow.setLocationRelativeTo(null);
        setWindow.setResizable(false);
        setWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setWindow.setBackground(Color.LIGHT_GRAY);
        setWindow.setVisible(true);


        //initialSettings = new JPanel();
        //initialSettings.setBorder(BorderFactory.createTitledBorder("Настройки по умолчанию"));
        labelSet = new JPanel();
        labelSet.setLayout(new BoxLayout(labelSet, BoxLayout.Y_AXIS));

        //initialSettings.setLayout(new BoxLayout(initialSettings, BoxLayout.Y_AXIS));

//        labelSet = new JPanel();
//        labelSet.setLayout(new BoxLayout(initialSettings, BoxLayout.Y_AXIS));

        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Укажите путь к файлу femm.exe:       "));
        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Дирректория проекта                 "));
        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Тип магнитной задачи                 "));
        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Выберите систему измерения           "));
        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Частота, Гц                          "));
        labelSet.add(new JLabel(" "));
        labelSet.add(new JLabel("   Выерите число параллельных расчетов  "));
        labelSet.add(new JLabel(" "));

        fieldSet = new JPanel();
        fieldSet.setLayout(new BoxLayout(fieldSet, BoxLayout.Y_AXIS));

        fieldSet.add(new JLabel("              "));
        fieldSet.add(new JLabel("              "));

//        JTextField femmPath = new JTextField("C:\\femm42\\bin\\femm.exe", 20);
//        femmPath.setHorizontalAlignment(JTextField.LEFT);
//        fieldSet.add(femmPath);
//        fieldSet.add(femmPath);
//
//        fieldSet.add(new JLabel("rere    "));

        // Ввод пути к Femm
        JFilePicker fpFemm = new JFilePicker("   Укажите путь к файлу femm.exe:       ",
                defaultPathFemm,
                "Browse...");

        fpFemm.setMode(JFilePicker.MODE_OPEN);
        fpFemm.addFileTypeFilter(".exe", "Windows Executable File");
        fpFemm.setFileTypeFilter(".exe", "Windows Executable File");
        fpFemm.getFileChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);


        // Ввод пути к проекту
        JFilePicker fpProject = new JFilePicker("   Дирректория проекта                             ",
                defaultPathProject,
                "Browse...");

        fpProject.setMode(JFilePicker.MODE_SAVE);
        fpProject.getFileChooser().setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY);

        fieldSet.add(fpFemm);
        fieldSet.add(fpProject);


        //initialSettings.add(labelSet);
        //setWindow.getContentPane().add(BorderLayout.WEST, labelSet);
        setWindow.getContentPane().add(BorderLayout.NORTH, fieldSet);


    }

    public void addComboBox(int posX, int posY) {

        JComboBox newComboBox = new JComboBox();
        newComboBox.setLocation(posX, posY);
        newComboBox.setSize(130, 27);
        newComboBox.setEditable(true);
        newComboBox.addItem("Serif");
        newComboBox.addItem("SansSerif");
        newComboBox.addItem("MonoSpaced");
        newComboBox.addItem("Dialog");
        newComboBox.addItem("DialogInput");
        newComboBox.addItem("Arial");
        setWindow.add(newComboBox);
    }


}
