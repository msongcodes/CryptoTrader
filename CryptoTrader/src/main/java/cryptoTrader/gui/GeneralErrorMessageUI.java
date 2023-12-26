package cryptoTrader.gui;

import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Chun Yang
 * Description: This is error message UI for general purpose
 * */
public class GeneralErrorMessageUI extends JFrame{
	
	/**
	 * This is constructor for GeneralErrorMessageUI
	 * @param message is the error message to be displayed
	 */
	public GeneralErrorMessageUI(String message) {
		// Set window title, size, location
		super("Error");
		this.setSize(200, 150);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(layout);
		
		// set input field and button
		JLabel errMessage = new JLabel(message, SwingConstants.CENTER);
		errMessage.setPreferredSize(new Dimension(200, 30));
		this.add(errMessage);
		
		JButton confirmButton = new JButton("OK");
		confirmButton.setSize(100, 30);
		this.add(confirmButton);
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GeneralErrorMessageUI.this.dispose();
			}
		});
		this.setVisible(true);
	}
}
