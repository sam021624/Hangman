package questionpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Main;
import main.Methods;

public class Question1 extends JPanel {
	Methods methods = new Methods();
	
    private String WORD = "DESIGN"; 
    private StringBuilder guessedWord = new StringBuilder("_".repeat(WORD.length()));
    private JLabel wordLabel;
    private JLabel feedbackLabel; 
    
    ImageIcon icon = new ImageIcon((getClass().getResource("/bg.png")));
    
    Main frame;

    public Question1(Main frame) {
    	this.frame = frame;
    	
    	JLabel lblTitle = new JLabel("Question #1");
        lblTitle.setFont(new Font("Consolas", Font.BOLD, 35));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(10, 11, 464, 109);
        add(lblTitle);

        JLabel lblQuestion = new JLabel("<html>What term refers to the visual layout of an interface?</html>");
        lblQuestion.setFont(new Font("Segoe UI", Font.ITALIC, 24));
        lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
        lblQuestion.setBounds(46, 146, 401, 60);
        add(lblQuestion);

        wordLabel = new JLabel(guessedWord.toString(), SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 28));
        wordLabel.setBounds(10, 247, 464, 50);
        add(wordLabel);

        feedbackLabel = new JLabel("Start guessing by typing letters!", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        feedbackLabel.setForeground(Color.BLUE);
        feedbackLabel.setBounds(46, 307, 401, 30);
        add(feedbackLabel);

		Image originalImage = icon.getImage();
		Image scaledImage = originalImage.getScaledInstance(484, 461, Image.SCALE_SMOOTH); 
		ImageIcon scaledIcon = new ImageIcon(scaledImage); 
        
        JLabel lblNewLabel = new JLabel(scaledIcon);
        lblNewLabel.setBounds(0, 0, 484, 461);
        add(lblNewLabel);
        
        this.setSize(484, 461);
        
        this.setLayout(null);
        setFocusable(true);
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                char guessedChar = Character.toUpperCase(e.getKeyChar());
                if (Character.isLetter(guessedChar)) {
                    processGuess(guessedChar);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void processGuess(char guessedChar) {
        if (guessedWord.indexOf(String.valueOf(guessedChar)) >= 0) {
            feedbackLabel.setText("Already guessed: " + guessedChar);
            return;
        }

        boolean found = false;
        for (int i = 0; i < WORD.length(); i++) {
            if (WORD.charAt(i) == guessedChar) {
                guessedWord.setCharAt(i, guessedChar);
                found = true;
            }
        }

        if (found) {
        	feedbackLabel.setForeground(Color.yellow);
            feedbackLabel.setText("Good job! Found: " + guessedChar);
        } else {
        	feedbackLabel.setForeground(Color.red);
            feedbackLabel.setText("Wrong guess! " + guessedChar + " is not in the answer");
        }

        wordLabel.setText(guessedWord.toString());
        checkGameOver();
    }

    private void checkGameOver() {
        if (guessedWord.toString().equals(WORD)) {
            feedbackLabel.setText("Good Job! The answer is: " + WORD);
            disableInput();
            
            int choice = JOptionPane.showConfirmDialog(null, "Proceed to Question 2?", "Notice", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) 
            	methods.switchPanels(frame, this, frame.question2Panel);
        }
    }

    private void disableInput() {
        setFocusable(false); 
    }
}
