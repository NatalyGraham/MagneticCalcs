package UI;

import UI.utilities.JFilePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class RunProject implements ActionListener {

    private JFrame setWindow;
    //private JPanel initialSettings;
    private JPanel labelSet;
    private JPanel fieldSet;

    JButton runButton;
    private final int dimX = 1000;
    private final int dimY = 600;
    private String title;
    private String defaultPathFemm = "C:\\femm42\\bin\\femm.exe";
    private String defaultPathLuaScript = "D:\\Projects\\MagneticProjects\\somescript.lua";

    private JLabel text01, text02, text03, text04, text05, text06;

    public String getDefaultPathFemm() {
        return defaultPathFemm;
    }

    public String getDefaultPathLuaScript() {
        return defaultPathLuaScript;
    }

    public RunProject() {

        //setWindow.setLayout(null);
        title = "Новый проект";
        setWindow = new JFrame(title);
        setWindow.setSize(dimX, dimY);
        setWindow.setLocationRelativeTo(null);
        setWindow.setResizable(true);
        setWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setWindow.setBackground(Color.LIGHT_GRAY);
        setWindow.setVisible(true);

        runButton = new JButton("Run");
        runButton.addActionListener(this);



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
        JFilePicker fpProject = new JFilePicker("   Укажите путь к скрипту с расширением .lua:    ",
                defaultPathLuaScript,
                "Browse...");

        fpProject.setMode(JFilePicker.MODE_OPEN);
        fpProject.addFileTypeFilter(".lua", "LUA script File");
        fpProject.setFileTypeFilter(".lua", "LUA script File");
        fpProject.getFileChooser().setFileSelectionMode(
                JFileChooser.FILES_ONLY);

        fieldSet.add(fpFemm);
        fieldSet.add(fpProject);
        fieldSet.add(runButton);


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


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            new RunFemm("C:\\femm42\\bin\\femm.exe",
                    "-lua-script=D:\\Projects\\MagneticProjects\\somescript.lua");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
