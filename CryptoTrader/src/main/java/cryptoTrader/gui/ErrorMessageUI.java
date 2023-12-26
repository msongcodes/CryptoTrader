
package cryptoTrader.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * @author Daiying Erica Zhu, Chun Yang
 * Description: error message for failed trade
 *
 */
public class ErrorMessageUI extends JFrame {
	
	/**
	 * Constructor. Display Error message for failed trade
	 * @param error list of all broker name whose trade failed
	 */
		public ErrorMessageUI(List<String> error) {
			
			// Set window title, size, location
			super("Error");
			
			StringBuilder message = new StringBuilder();
		
			if (error.size() > 0) {
				for(String err : error) {
					message.append(err);
					message.append(" ");
				}
				message.append("'s trades have failed.");
			}
			
			
			this.setSize(200, 150);
			this.setDefaultCloseOperation(3);
			this.setLocationRelativeTo(null);
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
			this.setLayout(layout);
			
			// set input field and button
			JLabel errMessage = new JLabel(message.toString(), SwingConstants.CENTER);
			errMessage.setPreferredSize(new Dimension(200, 30));
			this.add(errMessage);
			
			JButton confirmButton = new JButton("OK");
			confirmButton.setSize(100, 30);
			this.add(confirmButton);
			
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ErrorMessageUI.this.dispose();
				}
			});
			this.setVisible(true);
		}
	}
