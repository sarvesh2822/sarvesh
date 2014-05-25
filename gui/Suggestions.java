package assign2.gui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Suggestions {

	public static final int WIDTH = 600;
	public static final int HEIGHT = 500;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				NGramGUI nGramGui = new NGramGUI("NGram Predictor");
				nGramGui.setMaximumSize(new Dimension(WIDTH, HEIGHT));
				nGramGui.setMinimumSize(new Dimension(WIDTH, HEIGHT));
				nGramGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nGramGui.pack();
				nGramGui.setVisible(true);
			}
		});

	}

}
