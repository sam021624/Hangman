package questionpanels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import main.Main;
import main.Methods;

public class Question8 extends JPanel {
	Methods methods = new Methods();
	
    private String WORD = "EVALUATION"; 
    private StringBuilder guessedWord = new StringBuilder("_".repeat(WORD.length()));
    private JLabel wordLabel; 
    private JLabel feedbackLabel; 
    
    ImageIcon icon = new ImageIcon((getClass().getResource("/board.png")));
    
    Main frame;

    public Question8(Main frame) {
    	this.frame = frame;
    	
    	JLabel lblTitle = new JLabel("Question #8");
    	lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Consolas", Font.BOLD, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 967, 109);
        add(lblTitle);

        JLabel lblQuestion = new JLabel("<html>What is the assessment of a product’s ease of use and efficiency?</html>");
		lblQuestion.setFont(new Font("Segoe UI", Font.ITALIC, 35));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(80, 146, 879, 120);
        add(lblQuestion);

        wordLabel = new JLabel(guessedWord.toString(), SwingConstants.CENTER);
		wordLabel.setForeground(Color.WHITE);
		wordLabel.setFont(new Font("Arial", Font.BOLD, 40));
		wordLabel.setBounds(0, 353, 977, 94);
        add(wordLabel);

        feedbackLabel = new JLabel("Start guessing by typing letters!", SwingConstants.CENTER);
		feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 40));
		feedbackLabel.setForeground(Color.ORANGE);
		feedbackLabel.setBounds(10, 434, 967, 129);
        add(feedbackLabel);
        
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 967, 165);
		add(panel);

		Image originalImage = icon.getImage();
		Image scaledImage = originalImage.getScaledInstance(1000, 750, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0, 1000, 707);
		add(lblNewLabel);
		
		this.setSize(986, 699);
		this.setLayout(null);
		setFocusable(true);

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
            
            int choice = JOptionPane.showConfirmDialog(null, "Proceed to Question 9?", "Notice", JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION) {
            	methods.switchPanels(frame, this, frame.question9Panel);
            }
        }
    }

    private void disableInput() {
        setFocusable(false); 
    }
}
