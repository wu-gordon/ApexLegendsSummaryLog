package ui.gui;

import javax.swing.*;
import java.awt.*;

// Panel 5: (Selected: Print - Match history data) A panel with Apex match data from all of the games added to
// the match log for the session; Match History Log
public class PrintMatchHistoryPanel {
    private JPanel matchHistoryPanel;
    private JLabel matchSpacing1;
    private JLabel matchHistoryTitle;
    private JLabel matchSpacing2;

    // EFFECTS: creates appropriate instances
    public PrintMatchHistoryPanel() {
        this.matchHistoryPanel = new JPanel();
        this.matchHistoryPanel.setLayout(new BoxLayout(this.matchHistoryPanel, BoxLayout.Y_AXIS));

        this.matchSpacing1 = new JLabel(" ");
        this.matchHistoryTitle = new JLabel("Match History:");
        this.matchSpacing2 = new JLabel(" ");

        matchHistorySpacing1();
        launchMatchHistoryPanel();
    }

    // EFFECTS: launches the match history panel
    public void launchMatchHistoryPanel() {
        matchHistoryHeader();
        matchHistorySpacing2();
    }

    // EFFECTS: creates a space between top frame -> title
    public void matchHistorySpacing1() {
        this.matchSpacing1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchSpacing1.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.matchHistoryPanel.add(this.matchSpacing1);
    }

    // EFFECTS: creates the title for this panel
    public void matchHistoryHeader() {
        this.matchHistoryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchHistoryTitle.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.matchHistoryPanel.add(this.matchHistoryTitle);
    }

    // EFFECTS: creates a space between title -> match history log
    public void matchHistorySpacing2() {
        this.matchSpacing2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchSpacing2.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.matchHistoryPanel.add(this.matchSpacing2);
    }

    public JPanel getMatchHistoryPanel() {
        return matchHistoryPanel;
    }
}
