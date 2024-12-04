package main;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JPanel{

	ImageIcon icon = new ImageIcon(getClass().getResource("/start.jpg"));
	
	Methods methods = new Methods();
	
	Start(Main frame){
		Image originalImage = icon.getImage();
		Image scaledImage = originalImage.getScaledInstance(984, 697, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		JLabel lblStart = new JLabel(scaledIcon);
		lblStart.setBounds(0, 0, 984, 697);
		add(lblStart);
		setFocusable(true);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				char guessedChar = Character.toUpperCase(e.getKeyChar());
				if (guessedChar == 'S') {
					methods.switchPanels(frame, frame.startPanel, frame.question1Panel);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		this.setLayout(null);
		this.setBounds(0,0,986, 699);
	}
}
