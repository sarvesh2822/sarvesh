package assign2.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NGramGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2419228817448519511L;
	
	//public static final int WIDTH = 600;
	//public static final int HEIGHT = 600;
	private JTextArea textArea;
	private JButton searchButton;
	private JButton button;
	private JTextField textPhrase;
	private JTextField textNumEntry;
	
	private JPanel topPanel;
	private JPanel textPanel;
	private JPanel buttomPanel;
	
	
	public NGramGUI(String guiName){
		super(guiName);
		
		setLayout(new BorderLayout());
		
		topPanel = new JPanel();
		topPanel.setBackground(Color.LIGHT_GRAY);
		
		//GridLayout gl = new GridLayout(0,2);
		//topPanel.setLayout(gl);
		
		JLabel lblEnterPhrase = new JLabel("Enter Phrase:");
		topPanel.add(lblEnterPhrase);
		textPhrase = new JTextField();
		topPanel.add(textPhrase);
		
		JLabel lblNumEntry = new JLabel("Enter Number of output:");
		topPanel.add(lblNumEntry);
		textNumEntry = new JTextField();
		topPanel.add(textNumEntry);
		
		searchButton = new JButton("Search");
		topPanel.add(searchButton);
		
		
		getContentPane().add(topPanel,BorderLayout.NORTH);
		
		
		
		
		
		
		
		//textArea = new JTextArea();
		button = new JButton("Search");
		
		//add(textArea,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
		
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
