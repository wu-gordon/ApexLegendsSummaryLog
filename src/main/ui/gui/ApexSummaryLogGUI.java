package ui.gui;

import exceptions.PlacementNotWithinRange;
import model.ApexMatch;
import model.MatchLog;
import model.RankedPointsCalculator;

import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Graphical User Interface (GUI) for Apex Ranked Points (RP) Match History Log
public class ApexSummaryLogGUI extends JFrame {
    private JLabel rankDivisionLabel;
    private JLabel kpLabel;
    private JLabel placementLabel;
    private JLabel rpLabel;

    private MatchLog matchLog;
    private RankedPointsCalculator rpCalc;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/matchLog.json";

    private HomePagePanel homePagePanel;
    private RankedDivisionsPanel rankedDivisionsPanel;
    private GameDataInputPanel gameDataInputPanel;
    private RankedPointsCalculationPanel rankedPointsCalculationPanel;
    private PrintMatchHistoryPanel printMatchHistoryPanel;

    private PlayMusic playMusic;
    private ApexMatch apexMatch;

    // EFFECTS: launches gui, creates appropriate instances
    public ApexSummaryLogGUI() {
        setTitle("Apex Legends Ranked Points (RP) Match History Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocation(790, 215);
        setResizable(false);

        this.matchLog = new MatchLog();
        this.rpCalc = new RankedPointsCalculator();
        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);

        newPanels();

        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);

        newLabels();

        this.playMusic = new PlayMusic();
        openHomePage();

//        this.playMusic.musicPlayer("./src/main/ui/gui/Apex-Legends-Season-7-Ascension-Music-Pack-_High-Quality_-"
//                + "320k.wav");

        setVisible(true);
    }

    // EFFECTS: creates new instances of all 5 panels *not enough space in constructor*
    public void newPanels() {
        this.homePagePanel = new HomePagePanel();
        this.rankedDivisionsPanel = new RankedDivisionsPanel();
        this.gameDataInputPanel = new GameDataInputPanel();
        this.rankedPointsCalculationPanel = new RankedPointsCalculationPanel();
        this.printMatchHistoryPanel = new PrintMatchHistoryPanel();
    }

    // EFFECTS: creates new instances of all ranked division labels *not enough space in constructor*
    public void newLabels() {
        this.rankDivisionLabel = new JLabel();
        this.rankDivisionLabel.setFont(new Font("HK Grotesk", Font.PLAIN, 35));
        this.rankDivisionLabel.setBounds(250, 47, 300, 40);

        this.kpLabel = new JLabel();
        this.kpLabel.setFont(new Font("HK Grotesk", Font.PLAIN, 35));
        this.kpLabel.setBounds(420, 127, 200, 40);

        this.placementLabel = new JLabel();
        this.placementLabel.setFont(new Font("HK Grotesk", Font.PLAIN, 35));
        this.placementLabel.setBounds(290, 207, 200, 40);

        this.rpLabel = new JLabel();
        this.rpLabel.setFont(new Font("HK Grotesk", Font.PLAIN, 60));
        this.rpLabel.setBounds(512, 430, 300, 60);
    }

    // EFFECTS: adds home page panel content to main frame
    public void openHomePage() {
        add(this.homePagePanel.getMenuPanel());
        homePageEnterButtonAction();
        homePageQuitButtonAction();
    }

    // EFFECTS: sends player to the next panel depending on the selected drop down menu option on home page panel
    public void homePageEnterButtonAction() {
        this.homePagePanel.getEnterButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (homePagePanel.getSelections().getSelectedIndex() == 0) {
                    homePagePanel.getMenuPanel().setVisible(false);
                    rankedDivisionsPanel.getDivisionsPanel().setVisible(true);
                    openRankedDivisionsPage();
                    divisionButtonActions();
                } else if (homePagePanel.getSelections().getSelectedIndex() == 1) {
                    menuSelect1();
                } else if (homePagePanel.getSelections().getSelectedIndex() == 2) {
                    menuSelect2();
                    openMatchHistoryPage();
                    homePagePanel.getMenuPanel().setVisible(false);
                    printMatchHistoryPanel.getMatchHistoryPanel().setVisible(true);
                    printMatches();
                } else if (homePagePanel.getSelections().getSelectedIndex() == 3) {
                    menuSelect3();
                }
            }
        });
    }

    // EFFECTS: closes the application if quit button is pressed
    public void homePageQuitButtonAction() {
        homePagePanel.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // EFFECTS: saves apex matches to file on button press
    public void menuSelect1() {
        try {
            jsonWriter.open();
            jsonWriter.write(matchLog);
            jsonWriter.close();

            JSONObject jsonObject = new JSONObject();
            System.out.println("Saved all Apex matches to " + JSON_STORE);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: sends player to print match history panel, prints apex match history log on button press
    public void menuSelect2() {
        matchLog.printSummaryLog();
    }

    // EFFECTS: adds match history panel to main frame
    public void openMatchHistoryPage() {
        add(this.printMatchHistoryPanel.getMatchHistoryPanel());
    }

    // EFFECTS: prints all Apex match data
    public void printMatches() {
        System.out.println(matchLog.getMatches().size());
        for (ApexMatch match : matchLog.getMatches()) {
            JLabel printLabel = new JLabel();
            printLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            printLabel.setText(match.toString());
            printLabel.setFont(new Font("HK Grotesk", Font.PLAIN, 23));
            printMatchHistoryPanel.getMatchHistoryPanel().add(printLabel);
        }
    }

    // EFFECTS: loads apex match history data
    public void menuSelect3() {
        try {
            matchLog = jsonReader.read();
            System.out.println("Loaded all Apex matches from " + JSON_STORE);
        } catch (IOException ex) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: adds ranked divisions panel content to main frame
    public void openRankedDivisionsPage() {
        add(this.rankedDivisionsPanel.getDivisionsPanel());
    }

    // EFFECTS: sends player to game data input panel upon appropriate ranked division button press
    public void divisionButtonActions() {
        divisionsPageBronzeButtonAction();
        divisionsPageSilverButtonAction();
        divisionsPageGoldButtonAction();
        divisionsPagePlatinumButtonAction();
        divisionsPageDiamondButtonAction();
        divisionsPageMastersPredatorButtonAction();
        divisionsPageEnterButton();
    }

    // EFFECTS: sends player to game data input panel with set rank "Bronze"
    public void divisionsPageBronzeButtonAction() {
        rankedDivisionsPanel.getBronzeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("bronze");
                rankDivisionLabel.setText("bronze");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: sends player to game data input panel with set rank "Silver"
    public void divisionsPageSilverButtonAction() {
        rankedDivisionsPanel.getSilverButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("silver");
                rankDivisionLabel.setText("silver");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: sends player to game data input panel with set rank "Gold"
    public void divisionsPageGoldButtonAction() {
        rankedDivisionsPanel.getGoldButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("gold");
                rankDivisionLabel.setText("gold");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: sends player to game data input panel with set rank "Platinum"
    public void divisionsPagePlatinumButtonAction() {
        rankedDivisionsPanel.getPlatinumButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("platinum");
                rankDivisionLabel.setText("platinum");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: sends player to game data input panel with set rank "Diamond"
    public void divisionsPageDiamondButtonAction() {
        rankedDivisionsPanel.getDiamondButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("diamond");
                rankDivisionLabel.setText("diamond");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: sends player to game data input panel with set rank "Masters/Predator"
    public void divisionsPageMastersPredatorButtonAction() {
        rankedDivisionsPanel.getMastersPredatorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openGameDataInputPage();
                apexMatch.storeRankedDivision("masters/predator");
                rankDivisionLabel.setText("masters/predator");
                gameDataInputPanel.getGameDataInputPanel().add(rankDivisionLabel);
                rankedDivisionsPanel.getDivisionsPanel().setVisible(false);
                gameDataInputPanel.getGameDataInputPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: adds game data input panel to main frame, creates instance for Apex match
    public void openGameDataInputPage() {
        add(this.gameDataInputPanel.getGameDataInputPanel());
        this.apexMatch = new ApexMatch();
    }

    // EFFECTS: sends player to game data input page on button press
    public void divisionsPageEnterButton() {
        gameDataInputPanel.getGameDataEnterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRankedPointsCalculationPage();
                setRankDivisionForNextPanel();
                setKPValueForNextPanel();
                setPlacementValueForNextPanel();
                setRankedPointsValueForNextPanel();
                gameDataInputPanel.getGameDataInputPanel().setVisible(false);
                rankedPointsCalculationPanel.getRankedPointsPanel().setVisible(true);
            }
        });
    }

    // EFFECTS: adds ranked points calculation page content to main frame
    public void openRankedPointsCalculationPage() {
        add(this.rankedPointsCalculationPanel.getRankedPointsPanel());
        rankedPointsCalculationAddButton();
    }

    // EFFECTS: stores ranked division input for ranked points calculation panel
    public void setRankDivisionForNextPanel() {
        apexMatch.storeRankedDivision(apexMatch.getRank());
        rankDivisionLabel.setText(apexMatch.getRank());
        rankedPointsCalculationPanel.getRankedPointsPanel().add(rankDivisionLabel);
    }

    // EFFECTS: stores kill participation input for ranked points calculation panel
    public void setKPValueForNextPanel() {
        int kpValue = Integer.parseInt(gameDataInputPanel.getKPTextField().getText());
        apexMatch.storeKillParticipation(kpValue);
        gameDataInputPanel.getKPTextField().setText("");
        kpLabel.setText(String.valueOf(apexMatch.getKp()));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(kpLabel);
    }

    // EFFECTS: stores placement input for ranked points calculation panel
    public void setPlacementValueForNextPanel() {
        int placementValue = Integer.parseInt(gameDataInputPanel.getPlacementTextField().getText());
        try {
            apexMatch.storePlacement(placementValue);
        } catch (PlacementNotWithinRange placementNotWithinRange) {
            System.out.println("Placement value is not within range. Try again");
        }
        gameDataInputPanel.getPlacementTextField().setText("");
        placementLabel.setText(String.valueOf(apexMatch.getPlacement()));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(placementLabel);
    }

    // EFFECTS: stores ranked points calculation value for ranked points calculation panel
    public void setRankedPointsValueForNextPanel() {
        apexMatch.setRp(rpCalc.calculateRankEntryCost(apexMatch.getRank(),
                apexMatch.getPlacement(), apexMatch.getKp()));
        rpLabel.setText(String.valueOf(rpCalc.calculateRankEntryCost(apexMatch.getRank(),
                apexMatch.getPlacement(), apexMatch.getKp())));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(rpLabel);
    }

    // EFFECTS: sends player back to home page panel to Add, Save, Print, Load on button press
    public void rankedPointsCalculationAddButton() {
        rankedPointsCalculationPanel.getRankedPointsAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matchLog.addToList(apexMatch);
                rankedPointsCalculationPanel.getRankedPointsPanel().setVisible(false);
                homePagePanel.getMenuPanel().setVisible(true);
            }
        });
    }
}
