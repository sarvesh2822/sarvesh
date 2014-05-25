package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import assign2.ngram.NGramException;
import assign2.ngram.NGramStore;

public class NGramGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7031008862559936404L;
	private static final String REGEX = "[ 0-9~`!@#$%^&*(){}|;:<>?/_@./#&+-]+";
	//private static final int MAX_RESULTS = 5;
	private JPanel topPanel;

	private JTextField txtPhrases;
	private JTextField txtNumEntries;
	private JButton btnSearch;

	private JPanel textPanel;
	private JPanel chartPanel;
	private JPanel btmPanel;

	// private JTextArea textDisplay;

	public NGramGUI(String guiName) {
		super(guiName);

		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		topPanel = new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);

		GridLayout gl = new GridLayout(3, 2);
		topPanel.setLayout(gl);

		JLabel lblEnterPhrase = new JLabel("Enter Phrase :");
		topPanel.add(lblEnterPhrase);

		txtPhrases = new JTextField();
		topPanel.add(txtPhrases);

		JLabel lblEnterNumEntries = new JLabel("No of Entries :");
		topPanel.add(lblEnterNumEntries);

		txtNumEntries = new JTextField();
		topPanel.add(txtNumEntries);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		topPanel.add(btnSearch);

		this.getContentPane().add(topPanel, BorderLayout.NORTH);

		// From Result Class--------------------------------------//
		textPanel = new ResultPanel();
		this.getContentPane().add(textPanel, BorderLayout.CENTER);
		// --------------------------------------------------------//

		btmPanel = new JPanel();
		btmPanel.setBackground(Color.LIGHT_GRAY);
		btmPanel.setLayout(new FlowLayout());

		JButton blueButton = new JButton("Text O/p");
		blueButton.setBackground(Color.WHITE);
		blueButton.addActionListener(this);
		btmPanel.add(blueButton);

		JButton blackButton = new JButton("Chart O/p");
		blackButton.setBackground(Color.WHITE);
		blackButton.addActionListener(this);
		btmPanel.add(blackButton);

		this.getContentPane().add(btmPanel, BorderLayout.SOUTH);
	}

	/**
	 * @param args
	 * String chk = "My name is this and that";
		if(Pattern.matches(REGEX, chk)){
			System.out.println("Matched");
		}else{
			System.out.println("Not");
		}
	 */
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Text O/p")) {
			textPanel.setVisible(true);
			//chartPanel.setVisible(false);
		} else if (buttonString.equals("Chart O/p")) {
			//chartPanel.setVisible(true);
			textPanel.setVisible(false);
		} else if (buttonString.equals("Search")) {
			String resultString = "";
            if(txtPhrases.getText() == null || txtPhrases.getText().equals("") || Pattern.matches(REGEX, txtPhrases.getText())  ) {
                resultString += "Enter some phrease or words for prediction and a valid one";
            } else if(txtNumEntries.getText() == null || txtNumEntries.getText().equals("")) {
                resultString += "Enter some number for number of query output";
            } else {

                String[] phrases = txtPhrases.getText().split(",");
                int numEntries = Integer.valueOf(txtNumEntries.getText());
                if (phrases.length > 5  ) {
                  resultString += "Bad";
                } else if (numEntries > 5) {
                  resultString += "Too many queries";
                } else {
                    NGramStore nGramStore = new NGramStore();
                    for (String context : phrases) {
                        resultString += "NGram Results for Query: " + context + "\n";
                        try {
                            if (nGramStore.getNGramsFromService(context, numEntries)) {
                                resultString += nGramStore.getNGram(context).toString();
                            } else {
                                resultString += "No results were returned for this phrase.";
                            }
                        } catch (NGramException nex) {
                            resultString += "No results were returned for this phrase.";
                        }
                    }
                }
            }

			((ResultPanel) textPanel).updateText(resultString);

		}
	}

}
