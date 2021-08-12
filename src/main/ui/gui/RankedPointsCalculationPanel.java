package ui.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Panel 3: A panel that sets rank division from panel 2, with 2 additional text fields for player to insert their
// kill participation (KP) and placement values
public class RankedPointsCalculationPanel extends JFrame implements ActionListener {
    private JPanel rankedPointsPanel;
    private JLabel division;
    private JLabel killsAssists;
    private JLabel placement;
    private JLabel rankedPoints;
    private JButton addButton;

    // EFFECTS: creates appropriate instances
    public RankedPointsCalculationPanel() {
        this.rankedPointsPanel = new JPanel();
        this.rankedPointsPanel.setLayout(null);

        this.division = new JLabel("Division: ");
        this.killsAssists = new JLabel("Kills / Assists (KP): ");
        this.placement = new JLabel("Placement: ");
        this.rankedPoints = new JLabel("RP: ");
        this.addButton = new JButton("Add new match");

        launchRankedPointsCalculationPanel();
    }

    // EFFECTS: launches the ranked points calculation panel
    public void launchRankedPointsCalculationPanel() {
        rankedDivisionValueSet();
        killParticipationValueSet();
        placementValueSet();
        rankedPointsValueSet();
        rankedPointsAddButton();
    }

    // EFFECTS: sets the rank division as a label
    public void rankedDivisionValueSet() {
        this.division.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.division.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.division.setBounds(80, 47, 300, 40);
        this.rankedPointsPanel.add(this.division);
    }

    // EFFECTS: sets the kill participation (KP) value as a label
    public void killParticipationValueSet() {
        this.killsAssists.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.killsAssists.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.killsAssists.setBounds(80,127,500,40);
        this.rankedPointsPanel.add(this.killsAssists);
    }

    // EFFECTS: sets the placement value as a label
    public void placementValueSet() {
        this.placement.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.placement.setFont(new Font("HK Grotesk", Font.BOLD, 35));
        this.placement.setBounds(80, 207, 500, 40);
        this.rankedPointsPanel.add(this.placement);
    }

    // EFFECTS: sets the ranked points (RP) total as a label
    public void rankedPointsValueSet() {
        this.rankedPoints.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.rankedPoints.setFont(new Font("HK Grotesk", Font.BOLD, 60));
        this.rankedPoints.setBounds(380, 430, 300, 60);
        this.rankedPointsPanel.add(this.rankedPoints);
    }

    // EFFECTS: creates an add button that brings you back to the home page panel
    public void rankedPointsAddButton() {
        this.addButton.setFont(new Font("HK Grotesk", Font.BOLD, 25));
        this.addButton.setBounds(380, 700, 230, 40);
        this.rankedPointsPanel.add(this.addButton);
    }

    public JPanel getRankedPointsPanel() {
        return rankedPointsPanel;
    }

    public JButton getRankedPointsAddButton() {
        return addButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
