package it.unimol.quiztime.gui;

import it.unimol.quiztime.entities.Player;
import it.unimol.quiztime.gui.design.RoundJTextField;
import it.unimol.quiztime.gui.design.StyledButtonUI;
import it.unimol.quiztime.handler.HandlerPlayer;
import it.unimol.quiztime.handler.HandlerQuiz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFrame extends JFrame {
    public HandlerQuiz handlerQuiz = new HandlerQuiz();
    public HandlerPlayer handlerPlayer = new HandlerPlayer();
    List<Player> bestPlayers;

    private JLabel background;
    private final String imagePath = "out/img.png";
    private JPanel buttonsPanel;
    private JButton quitButton;
    private JButton playButton;

    private JTextField first = new JTextField();
    private JTextField second = new JTextField();
    private JTextField third = new JTextField();
    private JTextField txtclassifica= new JTextField();


    public HomeFrame() {
        super();

        handlerPlayer.firstPlayer();
        this.setAlwaysOnTop(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(255,255,255));

        txtclassifica.setBackground(new Color(0, 0, 0));
        txtclassifica.setForeground(new Color(255, 255, 255));
        txtclassifica.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));
        txtclassifica.setPreferredSize(new Dimension(150,80));
        txtclassifica.setBorder(BorderFactory.createBevelBorder(1));
        txtclassifica.setHorizontalAlignment(JTextField.CENTER);
        txtclassifica.setEditable(false);
        txtclassifica.setText("RANKING: ");


        first = new RoundJTextField(20);
        first.setPreferredSize(new Dimension(80,60));
        first.setBackground(new Color(94, 135, 216));
        first.setText("FIRST: "+handlerPlayer.firstPlayer().getAlias()+" - "+handlerPlayer.firstPlayer().getPoint());
        first.setHorizontalAlignment(JTextField.CENTER);
        first.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 16));
        first.setForeground(Color.white);
        first.setEditable(false);



        second = new RoundJTextField(20);
        second.setPreferredSize(new Dimension(80,60));
        second.setBackground(new Color(68, 104, 176));
        second.setText("SECOND: "+handlerPlayer.secondPlayer().getAlias()+" - "+handlerPlayer.secondPlayer().getPoint());
        second.setHorizontalAlignment(JTextField.CENTER);
        second.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 16));
        second.setForeground(Color.white);
        second.setEditable(false);



        third = new RoundJTextField(20);
        third.setPreferredSize(new Dimension(80,60));
        third.setBackground(new Color(40, 71, 126));
        third.setText("THIRD: "+handlerPlayer.thirdPlayer().getAlias()+" - "+handlerPlayer.thirdPlayer().getPoint());
        third.setHorizontalAlignment(JTextField.CENTER);
        third.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 16));
        third.setForeground(Color.white);
        third.setEditable(false);

        this.loadBackground();



        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setOpaque(false);
        this.buttonsPanel.setBorder(BorderFactory.createEmptyBorder(700, 0, 0, 0));
        this.background.add(buttonsPanel);

        this.quitButton = new JButton("QUIT");
        this.quitButton.setFont(new Font("San Serif", Font.BOLD, 40));
        this.quitButton.setForeground(Color.white);
        this.quitButton.setBackground(new Color(240, 133, 34));
        this.quitButton.setPreferredSize(new Dimension(200,80));
        this.quitButton.setBorderPainted(false);
        this.quitButton.setContentAreaFilled(false);
        this.quitButton.setOpaque(true);
        this.quitButton.setUI(new StyledButtonUI());
        this.quitButton.addActionListener(
                actionEvent -> {
                    int click = JOptionPane.showConfirmDialog(
                            this,
                            "Are you sure you want to quit the game?",
                            "QUIT GAME",
                            JOptionPane.YES_NO_OPTION);
                    if (click == 0) {
                        System.exit(0);
                    }
                }
        );
        this.buttonsPanel.add(quitButton);

        this.playButton = new JButton("PLAY");
        this.playButton.setFont(new Font("San Serif", Font.BOLD, 40));
        this.playButton.setForeground(Color.white);
        this.playButton.setBackground(new Color(46, 170, 186));
        this.playButton.setUI(new StyledButtonUI());
        this.playButton.setPreferredSize(new Dimension(200,80));

        this.playButton.addActionListener(
                actionEvent -> {
                    this.setVisible(false);
                    GameFrame gameFrame = new GameFrame(this.handlerQuiz, handlerPlayer);
                }
        );
        this.buttonsPanel.add(playButton);
        this.buttonsPanel.add(txtclassifica);
        this.buttonsPanel.add(first);
        this.buttonsPanel.add(second);
        this.buttonsPanel.add(third);
    }

    public void loadBackground() {
        try {
            background = new JLabel(new ImageIcon(ImageIO.read(new File(imagePath))));
            this.add(background);
            this.background.setLayout(new FlowLayout());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
