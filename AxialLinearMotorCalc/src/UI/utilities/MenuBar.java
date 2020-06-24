package UI.utilities;

import javax.swing.*;

public class MenuBar extends JMenuBar{
    private JMenuBar mainMenu;
    private JMenu file, edit, view, help;
    private JMenuItem newProject, open, openRecent, save, saveAs, settings, exit;
    private final int mainMenuHeight = 25;
    public String kkk;

    public MenuBar(int horisontalSize) {

        super();

        mainMenu.setSize(horisontalSize, mainMenuHeight);
    }

    public void addSubmenu(){

        file = new JMenu("Файл");
        edit = new JMenu("Редактирование");
        view = new JMenu("Просмотр");
        help = new JMenu("Help");


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

        mainMenu.add(file);
        mainMenu.add(edit);
        mainMenu.add(view);
        mainMenu.add(help);

    }
}
