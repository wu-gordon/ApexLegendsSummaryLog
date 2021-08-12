package ui.gui;

import javax.swing.*;
import java.awt.*;

// Panel 4: A panel that confirms rank division, kill participation, and placement values, while displaying the total
// calculated ranked points (RP) for the game values put in by the player; Add button brings you back to the home page
// where you can continue adding ranked game data or Save, Load, Print, Quit
public class GameDataInputPanel {
    private JPanel gameDataInputPanel;
    private JLabel division;
    private JLabel killsAssists;
    private JLabel placement;
    private JButton gameDataEnterButton;
    private JTextField kpTextField;
    private JTextField placementTextField;

    // EFFECTS: creates appropriate instances
    public GameDataInputPanel() {
        this.gameDataInputPanel = new JPanel();
        this.gameDataInputPanel.setLayout(null);

        this.division = new JLabel("Division: ");
        this.killsAssists = new JLabel("Kills / Assists (KP): ");
        this.placement = new JLabel("Placement: ");
        this.kpTextField = new JTextField();
        this.placementTextField = new JTextField();
        this.gameDataEnterButton = new JButton("Enter");

        launchGameDataInputPanel();
    }

    // EFFECTS: launches the game data input panel
    public void launchGameDataInputPanel() {
        divisionInput();
        kpInput();
        placementInput();
        gameDataEnterButton();
    }

    // EFFECTS: sets the ranked division as a label from button press
    public void divisionInput() {
        this.division.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.division.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.division.setBounds(80, 47, 300, 40);
        this.gameDataInputPanel.add(this.division);
    }

    // EFFECTS: introduces a text field for kill participation (KP)
    public void kpInput() {
        this.killsAssists.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.killsAssists.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.killsAssists.setBounds(80,127,500,40);
        this.kpTextField.setBounds(600, 120, 300, 50);
        this.gameDataInputPanel.add(this.killsAssists);
        this.gameDataInputPanel.add(this.kpTextField);
    }

    // EFFECTS: introduces a text field for placement
    public void placementInput() {
        this.placement.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.placement.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.placement.setBounds(80, 207, 500, 40);
        this.placementTextField.setBounds(600, 200, 300, 50);
        this.gameDataInputPanel.add(this.placement);
        this.gameDataInputPanel.add(this.placementTextField);
    }

    // EFFECTS: creates an enter button that leads to the ranked points calculation panel
    public void gameDataEnterButton() {
        this.gameDataEnterButton.setFont(new Font("HK Grotesk", Font.BOLD, 25));
        this.gameDataEnterButton.setBounds(445, 700, 100, 40);
        this.gameDataInputPanel.add(this.gameDataEnterButton);
    }

    public JPanel getGameDataInputPanel() {
        return gameDataInputPanel;
    }

    public JButton getGameDataEnterButton() {
        return gameDataEnterButton;
    }

    public JTextField getKPTextField() {
        return kpTextField;
    }

    public JTextField getPlacementTextField() {
        return placementTextField;
    }
}
