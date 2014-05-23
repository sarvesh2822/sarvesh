package assign2.gui;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class NGramGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2419228817448519511L;
	
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private JTextArea textArea;
	private JButton button;
	
	public NGramGUI(String guiName){
		super(guiName);
		
		setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		button = new JButton("Search");
		
		add(textArea,BorderLayout.CENTER);
		add(button,BorderLayout.SOUTH);
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
