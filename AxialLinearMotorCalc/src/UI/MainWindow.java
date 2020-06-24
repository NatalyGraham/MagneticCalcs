package UI;

import UI.utilities.MenuBar;
import UI.utilities.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

    private JFrame mainWindow;
    private final int dimX = 1000;
    private final int dimY = 750;
    private final int mainMenuHeight = 25;
    private String title;
    private JMenuBar mainMenu;
    private JMenu file, edit, view, help;
    private JMenuItem newProject, open, openRecent, save, saveAs, settings, exit;

    public JFrame getMainWindow() {
        return mainWindow;
    }

    public MainWindow() {

        title = "MagneticCalcs";
        mainWindow = new JFrame(title);
        mainWindow.setSize(dimX, dimY);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setBackground(Color.LIGHT_GRAY);
        mainWindow.setVisible(true);

        mainMenu = new JMenuBar();
        mainMenu.setSize(dimX, mainMenuHeight);

        file = new JMenu("Файл");
        edit = new JMenu("Редактирование");
        view = new JMenu("Просмотр");
        help = new JMenu("Help");
        mainMenu.add(file);
        mainMenu.add(edit);
        mainMenu.add(view);
        mainMenu.add(help);

        newProject = new JMenuItem("Новый проект");
        open = new JMenuItem("Открыть");
        openRecent = new JMenuItem("Открыть недавние");
        save = new JMenuItem("Сохранить");
        saveAs = new JMenuItem("Сохранить как");
        settings = new JMenuItem("Настройки");
        exit = new JMenuItem("Выйти");

        file.add(newProject);
        file.add(open);
        file.add(openRecent);
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(settings);
        file.addSeparator();
        file.add(exit);

        //TODO: add ActionListener onto ALL menus
        newProject.addActionListener(this);
        settings.addActionListener(this);

        //*/

        //openRecent, save, saveAs, settings, exit
        StatusBar sB = new StatusBar();
        mainWindow.add(sB, BorderLayout.SOUTH);

        mainWindow.setJMenuBar(mainMenu);





    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newProject)
            new NewProjectWindow();
        if (e.getSource() == settings)
            new SettingsWindow();
    }
}
