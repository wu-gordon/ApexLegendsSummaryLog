package ui.gui;

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

    public void newPanels() {
        this.homePagePanel = new HomePagePanel();
        this.rankedDivisionsPanel = new RankedDivisionsPanel();
        this.gameDataInputPanel = new GameDataInputPanel();
        this.rankedPointsCalculationPanel = new RankedPointsCalculationPanel();
        this.printMatchHistoryPanel = new PrintMatchHistoryPanel();
    }

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

    public void openHomePage() {
        add(this.homePagePanel.getMenuPanel());
        homePageEnterButtonAction();
        homePageQuitButtonAction();
    }

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

    public void openRankedDivisionsPage() {
        add(this.rankedDivisionsPanel.getDivisionsPanel());
    }

    public void divisionButtonActions() {
        divisionsPageBronzeButtonAction();
        divisionsPageSilverButtonAction();
        divisionsPageGoldButtonAction();
        divisionsPagePlatinumButtonAction();
        divisionsPageDiamondButtonAction();
        divisionsPageMastersPredatorButtonAction();
        divisionsPageEnterButton();
    }

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

    public void menuSelect2() {
        matchLog.printSummaryLog();
    }

    public void menuSelect3() {
        try {
            matchLog = jsonReader.read();
            System.out.println("Loaded all Apex matches from " + JSON_STORE);
        } catch (IOException ex) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    public void homePageQuitButtonAction() {
        homePagePanel.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

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

    public void openGameDataInputPage() {
        add(this.gameDataInputPanel.getGameDataInputPanel());
        this.apexMatch = new ApexMatch();
    }

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

    public void openMatchHistoryPage() {
        add(this.printMatchHistoryPanel.getMatchHistoryPanel());
    }

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

    public void setRankDivisionForNextPanel() {
        apexMatch.storeRankedDivision(apexMatch.getRank());
        rankDivisionLabel.setText(apexMatch.getRank());
        rankedPointsCalculationPanel.getRankedPointsPanel().add(rankDivisionLabel);
    }

    public void setKPValueForNextPanel() {
        int kpValue = Integer.parseInt(gameDataInputPanel.getKPTextField().getText());
        apexMatch.storeKillParticipation(kpValue);
        gameDataInputPanel.getKPTextField().setText("");
        kpLabel.setText(String.valueOf(apexMatch.getKp()));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(kpLabel);
    }

    public void setPlacementValueForNextPanel() {
        int placementValue = Integer.parseInt(gameDataInputPanel.getPlacementTextField().getText());
        apexMatch.storePlacement(placementValue);
        gameDataInputPanel.getPlacementTextField().setText("");
        placementLabel.setText(String.valueOf(apexMatch.getPlacement()));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(placementLabel);
    }

    public void setRankedPointsValueForNextPanel() {
        apexMatch.setRp(rpCalc.calculateRankEntryCost(apexMatch.getRank(),
                apexMatch.getPlacement(), apexMatch.getKp()));
        rpLabel.setText(String.valueOf(rpCalc.calculateRankEntryCost(apexMatch.getRank(),
                apexMatch.getPlacement(), apexMatch.getKp())));
        rankedPointsCalculationPanel.getRankedPointsPanel().add(rpLabel);
    }

    public void openRankedPointsCalculationPage() {
        add(this.rankedPointsCalculationPanel.getRankedPointsPanel());
        rankedPointsCalculationAddButton();
    }

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
