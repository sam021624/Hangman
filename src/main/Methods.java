package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Methods {

	public void switchPanels(JFrame frame, JPanel removePanel, JPanel addPanel) {
		frame.add(addPanel);
		frame.remove(removePanel);
		frame.revalidate();
		frame.repaint();
	}
}
