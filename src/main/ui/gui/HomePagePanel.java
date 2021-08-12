package ui.gui;

import javax.swing.*;
import java.awt.*;

// Panel 1: The main home page panel with drop down menu options: Add, Save, Print, Load
public class HomePagePanel {
    private JPanel menuPanel;
    private JLabel menuOptions;
    private JLabel menuHeaderTitle1;
    private JLabel menuHeaderTitle2;
    private JLabel spacing1;
    private JLabel spacing2;
    private JLabel spacing3;
    private JLabel spacing4;
    private JLabel spacing5;
    private JLabel spacing6;
    private JLabel spacing7;
    private JButton enterButton;
    private JButton quitButton;

    private ImageIcon apexIcon;
    private JLabel apexImageLabel;
    private JComboBox<String> selections;

    // EFFECTS: creates appropriate instances
    public HomePagePanel() {
        // home page panel
        this.menuPanel = new JPanel();
        this.menuPanel.setLayout(new BoxLayout(this.menuPanel, BoxLayout.Y_AXIS));
        this.spacing1 = new JLabel(" ");
        this.menuHeaderTitle1 = new JLabel("APEX LEGENDS");
        this.spacing2 = new JLabel(" ");
        this.menuHeaderTitle2 = new JLabel("Ranked Points (RP) Match History Log");
        this.spacing3 = new JLabel(" ");
        this.spacing4 = new JLabel(" ");
        this.menuOptions = new JLabel("Please select one of the options below: ");
        this.spacing5 = new JLabel(" ");
        this.spacing6 = new JLabel(" ");
        this.enterButton = new JButton("Enter");
        this.spacing7 = new JLabel(" ");
        this.quitButton = new JButton("Quit");

        homeSpacing1();
        launchHomePanel();
    }

    // EFFECTS: launches the home page panel
    public void launchHomePanel() {
        menuTitle1();
        homeSpacing2();
        menuTitle2();
        homeSpacing3();
        addApexLogo();
        homeSpacing4();
        dropDownMenuOptions();
        homeSpacing5();
        dropDownBox();
        homeSpacing6();
        homePageEnterButton();
        homeSpacing7();
        homePageQuitButton();
    }

    // EFFECTS: creates a space between top frame -> title 1
    public void homeSpacing1() {
        this.spacing1.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.menuPanel.add(this.spacing1);
    }

    // EFFECTS: creates the title of application part 1
    public void menuTitle1() {
        this.menuHeaderTitle1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.menuHeaderTitle1.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.menuPanel.add(this.menuHeaderTitle1);
    }

    // EFFECTS: creates a space between title 1 -> title 2
    public void homeSpacing2() {
        this.spacing2.setFont(new Font("HK Grotesk", Font.BOLD, 10));
        this.menuPanel.add(this.spacing2);
    }

    // EFFECTS: creates the title of application part 2
    public void menuTitle2() {
        this.menuHeaderTitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.menuHeaderTitle2.setFont(new Font("HK Grotesk", Font.BOLD, 32));
        this.menuPanel.add(this.menuHeaderTitle2);
    }

    // EFFECTS: creates a space between title 2 -> logo
    public void homeSpacing3() {
        this.spacing3.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.menuPanel.add(this.spacing3);
    }

    // EFFECTS: creates a label for apex logo image
    public void addApexLogo() {
        this.apexIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource(
                "pathfinder-apex-logo.png")));
        this.apexImageLabel = new JLabel(apexIcon);
        this.apexImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.menuPanel.add(apexImageLabel);
    }

    // EFFECTS: creates a space between logo -> options text
    public void homeSpacing4() {
        this.spacing4.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.menuPanel.add(this.spacing4);
    }

    // EFFECTS: creates drop down menu options Add, Save, Print, Load
    public void dropDownMenuOptions() {
        this.menuOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.menuOptions.setFont(new Font("HK Grotesk", Font.BOLD, 22));
        this.menuPanel.add(this.menuOptions);
    }

    // EFFECTS: creates a space between options text -> drop box
    public void homeSpacing5() {
        this.spacing5.setFont(new Font("HK Grotesk", Font.BOLD, 25));
        this.menuPanel.add(this.spacing5);
    }

    // EFFECTS: creates the drop down menu box with included options
    public void dropDownBox() {
        String[] choices = {"Add - Ranked game data", "Save - Apex matches to file", "Print - Match history data",
                "Load - Match history data"};

        this.selections = new JComboBox<String>(choices);
        this.selections.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.selections.setFont(new Font("HK Grotesk", Font.PLAIN, 20));
        this.selections.setMaximumSize(selections.getPreferredSize());
        this.menuPanel.add(selections);
    }

    // EFFECTS: creates a space between drop box -> enter
    public void homeSpacing6() {
        this.spacing6.setFont(new Font("HK Grotesk", Font.BOLD, 120));
        this.menuPanel.add(this.spacing6);
    }

    // EFFECTS: creates an enter button
    public void homePageEnterButton() {
        this.enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.enterButton.setFont(new Font("HK Grotesk", Font.BOLD, 25));
        this.menuPanel.add(this.enterButton);
    }

    // EFFECTS: creates a space between enter and quit button
    public void homeSpacing7() {
        this.spacing7.setFont(new Font("HK Grotesk", Font.BOLD, 20));
        this.menuPanel.add(this.spacing7);
    }

    // EFFECTS: creates the quit button
    public void homePageQuitButton() {
        this.quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.quitButton.setFont(new Font("HK Grotesk", Font.BOLD, 25));
        this.menuPanel.add(this.quitButton);
    }

    public JPanel getMenuPanel() {
        return this.menuPanel;
    }

    public JButton getEnterButton() {
        return this.enterButton;
    }

    public JButton getQuitButton() {
        return this.quitButton;
    }

    public JComboBox getSelections() {
        return this.selections;
    }
}
