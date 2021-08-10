package ui.gui;

import javax.swing.*;
import java.awt.*;

public class PrintMatchHistoryPanel {
    private JPanel matchHistoryPanel;
    private JLabel matchSpacing1;
    private JLabel matchHistoryTitle;
    private JLabel matchSpacing2;

    public PrintMatchHistoryPanel() {
        this.matchHistoryPanel = new JPanel();
        this.matchHistoryPanel.setLayout(new BoxLayout(this.matchHistoryPanel, BoxLayout.Y_AXIS));

        this.matchSpacing1 = new JLabel(" ");
        this.matchHistoryTitle = new JLabel("Match History:");
        this.matchSpacing2 = new JLabel(" ");

        matchHistorySpacing1();
        launchMatchHistoryPanel();
    }

    public void launchMatchHistoryPanel() {
        matchHistoryHeader();
        matchHistorySpacing2();
    }

    public void matchHistorySpacing1() {
        this.matchSpacing1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchSpacing1.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.matchHistoryPanel.add(this.matchSpacing1);
    }

    public void matchHistoryHeader() {
        this.matchHistoryTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchHistoryTitle.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.matchHistoryPanel.add(this.matchHistoryTitle);
    }

    public void matchHistorySpacing2() {
        this.matchSpacing2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.matchSpacing2.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.matchHistoryPanel.add(this.matchSpacing2);
    }

    public JPanel getMatchHistoryPanel() {
        return matchHistoryPanel;
    }
}
