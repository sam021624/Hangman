package main;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import questionpanels.Question1;
import questionpanels.Question10;
import questionpanels.Question2;
import questionpanels.Question3;
import questionpanels.Question4;
import questionpanels.Question5;
import questionpanels.Question6;
import questionpanels.Question7;
import questionpanels.Question8;
import questionpanels.Question9;
import javax.swing.JButton;

public class Main extends JFrame {

	public Start startPanel = new Start(this);
	public Question1 question1Panel = new Question1(this);
	public Question2 question2Panel = new Question2(this);
	public Question3 question3Panel = new Question3(this);
	public Question4 question4Panel = new Question4(this);
	public Question5 question5Panel = new Question5(this);
	public Question6 question6Panel = new Question6(this);
	public Question7 question7Panel = new Question7(this);
	public Question8 question8Panel = new Question8(this);
	public Question9 question9Panel = new Question9(this);
	public Question10 question10Panel = new Question10(this);

	Methods methods = new Methods();
	
	Main() {
		getContentPane().setLayout(null);
		startPanel.setBounds(0, 0, 986, 699);
		getContentPane().add(startPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Guess the Word!");
		this.setSize(1000, 736);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
