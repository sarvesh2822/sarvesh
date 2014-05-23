package assign2.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Suggestions{

	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new NGramGUI("NGram Predictor");
				
			}
		});

	}

	
	

}
