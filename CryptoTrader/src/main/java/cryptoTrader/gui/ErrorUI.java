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
 * @author Chun Yang 250653628
 * Description: This is UI for error message
 * */
public class ErrorUI extends JFrame {
	
	/**
	 * This is constructor for ErrorUI
	 * @param message is the error message to be displayed
	 */
	public ErrorUI(String message) {
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
				ErrorUI.this.dispose();
				LoginWindow.getInstance().dispose();
			}
		});
		this.setVisible(true);
	}
}
