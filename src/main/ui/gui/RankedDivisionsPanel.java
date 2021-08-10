package ui.gui;

import javax.swing.*;
import java.awt.*;

public class RankedDivisionsPanel {
    private JPanel divisionsPanel;
    private JLabel divisionsHeaderTitle;
    private JLabel divisionSpace1;
    private JLabel divisionSpace2;
    private JLabel divisionSpace3;
    private JLabel divisionSpace4;
    private JLabel divisionSpace5;
    private JLabel divisionSpace6;
    private JLabel divisionSpace7;
    private JButton bronze;
    private JButton silver;
    private JButton gold;
    private JButton platinum;
    private JButton diamond;
    private JButton mastersPredator;

    public RankedDivisionsPanel() {
        this.divisionsPanel = new JPanel();
        this.divisionsPanel.setLayout(new BoxLayout(this.divisionsPanel, BoxLayout.Y_AXIS));
        this.bronze = new JButton("Bronze");
        this.silver = new JButton("Silver");
        this.gold = new JButton("Gold");
        this.platinum = new JButton("Platinum");
        this.diamond = new JButton("Diamond");
        this.mastersPredator = new JButton("Masters/Predator");

        divisionSpacing1();
        launchRankedDivisionsPanel();
    }

    public void launchRankedDivisionsPanel() {
        rankedTitle1();
        divisionSpacing2();
        bronzeButton();
        divisionSpacing3();
        silverButton();
        divisionSpacing4();
        goldButton();
        divisionSpacing5();
        platinumButton();
        divisionSpacing6();
        diamondButton();
        divisionSpacing7();
        mastersPredatorButton();
    }

    public void divisionSpacing1() {
        this.divisionSpace1 = new JLabel(" ");
        this.divisionSpace1.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace1);
    }

    public void rankedTitle1() {
        this.divisionsHeaderTitle = new JLabel("Select Your Ranked Division:");
        this.divisionsHeaderTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.divisionsHeaderTitle.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.divisionsPanel.add(this.divisionsHeaderTitle);
    }

    public void divisionSpacing2() {
        this.divisionSpace2 = new JLabel(" ");
        this.divisionSpace2.setFont(new Font("HK Grotesk", Font.BOLD, 95));
        this.divisionsPanel.add(this.divisionSpace2);
    }

    public void bronzeButton() {
        this.divisionsPanel.add(bronze);
        this.bronze.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.bronze.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.bronze.setBackground(Color.getHSBColor(0.1f, 0.4f, 0.5f));
        this.divisionsPanel.add(this.bronze);
    }

    public void divisionSpacing3() {
        this.divisionSpace3 = new JLabel(" ");
        this.divisionSpace3.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace3);
    }

    public void silverButton() {
        this.divisionsPanel.add(silver);
        this.silver.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.silver.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.silver.setBackground(Color.gray);
        this.divisionsPanel.add(this.silver);
    }

    public void divisionSpacing4() {
        this.divisionSpace4 = new JLabel(" ");
        this.divisionSpace4.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace4);
    }

    public void goldButton() {
        this.divisionsPanel.add(gold);
        this.gold.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.gold.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.gold.setBackground(Color.getHSBColor(251, 251, 251));
        this.divisionsPanel.add(this.gold);
    }

    public void divisionSpacing5() {
        this.divisionSpace5 = new JLabel(" ");
        this.divisionSpace5.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace5);
    }

    public void platinumButton() {
        this.divisionsPanel.add(platinum);
        this.platinum.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.platinum.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.platinum.setBackground(Color.getHSBColor(0.5f, 0.4f, 0.7f));
        this.divisionsPanel.add(this.platinum);
    }

    public void divisionSpacing6() {
        this.divisionSpace6 = new JLabel(" ");
        this.divisionSpace6.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace6);
    }

    public void diamondButton() {
        this.divisionsPanel.add(diamond);
        this.diamond.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.diamond.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.diamond.setBackground(Color.getHSBColor(0.6f, 0.1f, 7f));
        this.divisionsPanel.add(this.diamond);
    }

    public void divisionSpacing7() {
        this.divisionSpace7 = new JLabel(" ");
        this.divisionSpace7.setFont(new Font("HK Grotesk", Font.BOLD, 30));
        this.divisionsPanel.add(this.divisionSpace7);
    }

    public void mastersPredatorButton() {
        this.divisionsPanel.add(mastersPredator);
        this.mastersPredator.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.mastersPredator.setFont(new Font("HK Grotesk", Font.BOLD, 40));
        this.mastersPredator.setBackground(Color.getHSBColor(12f, 0.6f, 0.8f));
        this.divisionsPanel.add(this.mastersPredator);
    }

    public JPanel getDivisionsPanel() {
        return divisionsPanel;
    }

    public JButton getBronzeButton() {
        return bronze;
    }

    public JButton getSilverButton() {
        return silver;
    }

    public JButton getGoldButton() {
        return gold;
    }

    public JButton getPlatinumButton() {
        return platinum;
    }

    public JButton getDiamondButton() {
        return diamond;
    }

    public JButton getMastersPredatorButton() {
        return mastersPredator;
    }
}
