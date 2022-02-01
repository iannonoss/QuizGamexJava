package it.unimol.quiztime.gui;

import it.unimol.quiztime.entities.Player;
import it.unimol.quiztime.gui.design.RoundJTextField;
import it.unimol.quiztime.gui.design.StyledButtonUI;
import it.unimol.quiztime.handler.HandlerPlayer;
import it.unimol.quiztime.handler.HandlerQuiz;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameBoard extends JPanel implements ActionListener {

    private HandlerQuiz handlerQuiz;
    private GameFrame gameFrame;


    private int correct_guesses = 0;
    private int result;
    private int seconds = 15;
    private String question;
    private String answer;
    private int counter;
    private char charCheck = ' ';
    private int i=0;

    List<Player> playerList;

    private JTextField textfield = new JTextField();
    private JTextArea textarea = new JTextArea();
    private JButton buttonA = new JButton();
    private JButton buttonB = new JButton();
    private JButton buttonC = new JButton();
    private JButton buttonD = new JButton();
    private JButton saveResult = new JButton();
    private JButton playAgain = new JButton();
    private JLabel answer_labelA = new JLabel();
    private JLabel answer_labelB = new JLabel();
    private JLabel answer_labelC = new JLabel();
    private JLabel answer_labelD = new JLabel();
    private JLabel time_label = new JLabel();
    private JLabel seconds_left = new JLabel();
    private JTextField number_right = new JTextField();
    private JTextField percentage = new JTextField();

    private final ImageIcon imageIcon = new ImageIcon("out/timer.png");
    JLabel imagelabel = new JLabel(imageIcon);

    private final ImageIcon image = new ImageIcon("out/java.png");
    JLabel imageLabel2 = new JLabel(image);


    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });

    public GameBoard(GameFrame gameFrame, HandlerQuiz handlerQuiz, HandlerPlayer handlerPlayer) {
        this.handlerQuiz = handlerQuiz;
        this.gameFrame = gameFrame;



        textfield = new RoundJTextField(20);
        textfield.setBounds(500, 5, 500, 80);
        textfield.setBackground(new Color(20,20,16));
        textfield.setForeground(new Color(240, 133, 34));
        textfield.setFont(new Font("SansSerif", Font.BOLD, 40));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        //Border roundedBorder = new LineBorder(Color.orange, 1, true);
        textarea.setBounds(0, 100, 1530, 80);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(20,20,16));
        textarea.setForeground(new Color(255, 255, 255));
        textarea.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));
        //textarea.setBorder(roundedBorder);
        textarea.setEditable(false);


        buttonA.setBounds(20, 200, 100, 100);
        buttonA.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setBackground(new Color(46, 170, 186));
        buttonA.setForeground(Color.white);
        buttonA.setUI(new StyledButtonUI());
        buttonA.setText("A");

        buttonB.setBounds(20, 320, 100, 100);
        buttonB.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setBackground(new Color(46, 170, 186));
        buttonB.setForeground(Color.white);
        buttonB.setUI(new StyledButtonUI());
        buttonB.setText("B");

        buttonC.setBounds(20, 440, 100, 100);
        buttonC.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setBackground(new Color(46, 170, 186));
        buttonC.setForeground(Color.white);
        buttonC.setUI(new StyledButtonUI());
        buttonC.setText("C");

        buttonD.setBounds(20, 560, 100, 100);
        buttonD.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setBackground(new Color(46, 170, 186));
        buttonD.setForeground(Color.white);
        buttonD.setUI(new StyledButtonUI());
        buttonD.setText("D");

        answer_labelA.setBounds(145, 200, 1200, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(255, 255, 255));
        answer_labelA.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));


        answer_labelB.setBounds(145, 320, 1200, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(255, 255, 255));
        answer_labelB.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));


        answer_labelC.setBounds(145, 440, 1200, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(255, 255, 255));
        answer_labelC.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));


        answer_labelD.setBounds(145, 560, 1200, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(255, 255, 255));
        answer_labelD.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 25));


        seconds_left.setBounds(1330, 640, 150, 150);
        seconds_left.setBackground(new Color(20,20,16));
        seconds_left.setForeground(new Color(240, 133, 34));
        seconds_left.setFont(new Font("SansSerif",Font.BOLD,60));
        seconds_left.setOpaque(false);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        imagelabel.setBounds(1300, 580, 220,240);
        imageLabel2.setBounds(20, 700, 200,131);



        number_right.setBounds(665, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(665, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(2, 255, 0));
        percentage.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        saveResult.setBounds(500, 450, 250, 150);
        saveResult.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        saveResult.addActionListener(this);
        saveResult.setBackground(new Color(240, 133, 34));
        saveResult.setForeground(Color.white);
        saveResult.setUI(new StyledButtonUI());
        saveResult.setText("Save Result?");


        playAgain.setBounds(800, 450, 250, 150);
        playAgain.setFont(new Font("SansSerif", Font.CENTER_BASELINE, 35));
        playAgain.addActionListener(this);
        playAgain.setBackground(new Color(46, 170, 186));
        playAgain.setForeground(Color.white);
        playAgain.setUI(new StyledButtonUI());
        playAgain.setText("Play Again?");

        gameFrame.add(time_label);
        gameFrame.add(buttonA);
        gameFrame.add(buttonB);
        gameFrame.add(buttonC);
        gameFrame.add(buttonD);

        gameFrame.add(seconds_left);
        gameFrame.add(imagelabel);
        gameFrame.add(imageLabel2);

        gameFrame.add(answer_labelA);
        gameFrame.add(answer_labelB);
        gameFrame.add(answer_labelC);
        gameFrame.add(answer_labelD);


        gameFrame.add(textarea);
        gameFrame.add(textfield);
        gameFrame.setVisible(true);

        game();
    }



    public void game() {
        if(i >=10) {
            results();
        }
        else {
            counter = i;
            question = handlerQuiz.returnQuestion(i);
            textfield.setText("Question " + (i + 1));
            textarea.setText("   •"+handlerQuiz.returnQuestion(i));
            timer.start();

            for (int j = 0; j < 4; j++) {
                this.answer = handlerQuiz.returnAnswer(i, j);
                switch (j) {
                    case 0:
                        answer_labelA.setText(answer);
                        break;
                    case 1:
                        answer_labelB.setText(answer);
                        break;
                    case 2:
                        answer_labelC.setText(answer);
                        break;

                    case 3:
                        answer_labelD.setText(answer);
                        break;

                    default:
                }
            }

        }
    }

    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            if (handlerQuiz.check(counter, 0) == true) {
                charCheck = 'A';
                correct_guesses++;
                answer_labelA.setForeground(new Color(25, 255, 0));
            } else {
                if (handlerQuiz.check(counter, 1) == true) {
                    charCheck = 'B';
                    answer_labelB.setForeground(new Color(25, 255, 0));
                } else {
                    if (handlerQuiz.check(counter, 2) == true) {
                        charCheck = 'C';
                        answer_labelC.setForeground(new Color(25, 255, 0));
                    } else {
                        if (handlerQuiz.check(counter, 3) == true) {
                            charCheck = 'D';
                            answer_labelD.setForeground(new Color(25, 255, 0));
                        }
                    }
                }
            }
        }
        if (e.getSource() == buttonB) {
            if (handlerQuiz.check(counter, 1) == true) {
                charCheck = 'B';
                correct_guesses++;
                answer_labelB.setForeground(new Color(25, 255, 0));
            } else {
                if (handlerQuiz.check(counter, 0) == true) {
                    charCheck = 'A';
                    answer_labelA.setForeground(new Color(25, 255, 0));
                } else {
                    if (handlerQuiz.check(counter, 2) == true) {
                        charCheck = 'C';
                        answer_labelC.setForeground(new Color(25, 255, 0));
                    } else {
                        if (handlerQuiz.check(counter, 3) == true) {
                            charCheck = 'D';
                            answer_labelD.setForeground(new Color(25, 255, 0));
                        }
                    }
                }
            }
        }
        if (e.getSource() == buttonC) {
            if (handlerQuiz.check(counter, 2) == true) {
                charCheck = 'C';
                correct_guesses++;
                answer_labelC.setForeground(new Color(25, 255, 0));
            } else {
                if (handlerQuiz.check(counter, 0) == true) {
                    charCheck = 'A';
                    answer_labelA.setForeground(new Color(25, 255, 0));
                } else {
                    if (handlerQuiz.check(counter, 1) == true) {
                        charCheck = 'B';
                        answer_labelB.setForeground(new Color(25, 255, 0));
                    } else {
                        if (handlerQuiz.check(counter, 3) == true) {
                            charCheck = 'D';
                            answer_labelD.setForeground(new Color(25, 255, 0));
                        }
                    }
                }
            }
        }
        if (e.getSource() == buttonD) {
            if (handlerQuiz.check(counter, 3) == true) {
                charCheck = 'D';
                correct_guesses++;
                answer_labelD.setForeground(new Color(25, 255, 0));
            } else {
                if (handlerQuiz.check(counter, 0) == true) {
                    charCheck = 'A';
                    answer_labelA.setForeground(new Color(25, 255, 0));
                } else {
                    if (handlerQuiz.check(counter, 1) == true) {
                        charCheck = 'B';
                        answer_labelB.setForeground(new Color(25, 255, 0));
                    } else {
                        if (handlerQuiz.check(counter, 2) == true) {
                            charCheck = 'C';
                            answer_labelC.setForeground(new Color(25, 255, 0));
                        }
                    }
                }
            }

        }
        displayAnswer();
    }

    public void displayAnswer(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(charCheck == ' '){
            if (handlerQuiz.check(counter, 0) == true) {
                charCheck = 'A';
                answer_labelA.setForeground(new Color(25, 255, 0));
            } else {
                if (handlerQuiz.check(counter, 1) == true) {
                    charCheck = 'B';
                    answer_labelB.setForeground(new Color(25, 255, 0));
                } else {
                    if (handlerQuiz.check(counter, 2) == true) {
                        charCheck = 'C';
                        answer_labelC.setForeground(new Color(25, 255, 0));
                    } else {
                        if (handlerQuiz.check(counter, 3) == true) {
                            charCheck = 'D';
                            answer_labelD.setForeground(new Color(25, 255, 0));
                        }
                    }
                }
            }
        }

        if(charCheck != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(charCheck != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(charCheck != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(charCheck != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        timer.stop();
        Timer pause = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(255, 255, 255));
                answer_labelB.setForeground(new Color(255, 255, 255));
                answer_labelC.setForeground(new Color(255, 255, 255));
                answer_labelD.setForeground(new Color(255, 255, 255));
                charCheck= ' ';
                seconds = 15;
                i++;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                game();


            }
        });
        pause.setRepeats(false);
        pause.start();
        timer.start();
    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_guesses/(double)10)*100);
        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        number_right.setText("("+correct_guesses+"/"+10+")");
        percentage.setText(result+"%");
        buttonA.setVisible(false);
        gameFrame.remove(buttonA);
        gameFrame.remove(buttonB);
        gameFrame.remove(buttonC);
        gameFrame.remove(buttonD);
        gameFrame.add(percentage);
        gameFrame.add(number_right);
        gameFrame.add(saveResult);
        gameFrame.add(playAgain);
        timer.stop();
        this.saveResult.addActionListener(
                ActionEvent -> {
                    String name = JOptionPane.showInputDialog("Enter your name");
                    if (name.length() == 0){
                        JOptionPane.showMessageDialog(null, "Name not usable, put it back");
                    }
                    else {
                        JOptionPane.showConfirmDialog(null, name + " are you sure to save your result?  ");

                        try {
                            Player player = new Player(name, result);
                            HandlerPlayer handlerPlayer = new HandlerPlayer();
                            handlerPlayer.aggiungiPlayer(player);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        this.playAgain.addActionListener(
                ActionEvent -> {
                    int click = JOptionPane.showConfirmDialog(null,
                            "Do you want to play again?",
                            "JavaQuiz!",
                            JOptionPane.YES_OPTION, JOptionPane.NO_OPTION);
                    if (click == 0) {
                        this.gameFrame.setLocation(700, 400);
                        HomeFrame newHomeFrame = new HomeFrame();
                        newHomeFrame.setVisible(true);
                        this.gameFrame.dispose();
                    } else {
                        System.exit(0);
                    }
                }
        );

    }


}
