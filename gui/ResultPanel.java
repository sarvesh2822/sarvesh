package assign2.gui;

import javax.swing.*;

import java.awt.*;

public class ResultPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7027494397725323564L;
	private JTextArea textDisplay;

	public void updateText(String text) {
		if (textDisplay != null) {
			textDisplay.setText(text);
		}
	}

	public ResultPanel() {
		textDisplay = new JTextArea("Please try some phrase");
		textDisplay.setEditable(true);
		// add(new JScrollPane(view))

		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		add(new JScrollPane(textDisplay), BorderLayout.CENTER);
	}
}
