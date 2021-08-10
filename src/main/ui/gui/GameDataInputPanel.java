package ui.gui;

import javax.swing.*;
import java.awt.*;

public class GameDataInputPanel {
    private JPanel gameDataInputPanel;
    private JLabel division;
    private JLabel killsAssists;
    private JLabel placement;
    private JButton gameDataEnterButton;
    private JTextField kpTextField;
    private JTextField placementTextField;

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

    public void launchGameDataInputPanel() {
        divisionInput();
        kpInput();
        placementInput();
        gameDataEnterButton();
    }

    public void divisionInput() {
        this.division.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.division.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.division.setBounds(80, 47, 300, 40);
        this.gameDataInputPanel.add(this.division);
    }

    public void kpInput() {
        this.killsAssists.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.killsAssists.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.killsAssists.setBounds(80,127,500,40);
        this.kpTextField.setBounds(600, 120, 300, 50);
        this.gameDataInputPanel.add(this.killsAssists);
        this.gameDataInputPanel.add(this.kpTextField);
    }

    public void placementInput() {
        this.placement.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.placement.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.placement.setBounds(80, 207, 500, 40);
        this.placementTextField.setBounds(600, 200, 300, 50);
        this.gameDataInputPanel.add(this.placement);
        this.gameDataInputPanel.add(this.placementTextField);
    }

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
