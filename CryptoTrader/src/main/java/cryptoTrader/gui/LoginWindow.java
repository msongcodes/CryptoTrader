package cryptoTrader.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import cryptoTrader.login.LoginServer;

/**
 * @author Chun Yang
 * Description: This class provides the login window and input field 
 *              for user to login
 * 
 * */
public class LoginWindow extends JFrame {
	private static LoginWindow instance;
	
	/**
	 * A singleton design to return only one instance of the login window
	 * @returns login window instance
	 * */
	public static LoginWindow getInstance() {
		if(instance == null) instance = new LoginWindow();
		return instance;
	}
	
	private LoginWindow() {
		// Set window title, size, location
		super("Login");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setAlwaysOnTop(true);
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(layout);
		
		// set input field and button
		JLabel usernameLabel = new JLabel("USERNAME:");
		this.add(usernameLabel);
		JTextField usernameInput = new JTextField();
		usernameInput.setPreferredSize(new Dimension(250, 30));
		this.add(usernameInput);
		
		JLabel passwordLabel = new JLabel("PASSWORD:");
		this.add(passwordLabel);
		JPasswordField passwordInput = new JPasswordField();
		passwordInput.setPreferredSize(new Dimension(250, 30));
		this.add(passwordInput);
		
		JButton submitButton = new JButton();
		submitButton.setText("SUBMIT");
		submitButton.setSize(100, 30);
		this.add(submitButton);
		this.setVisible(true);
		
		LoginServer server = new LoginServer(usernameInput, passwordInput);
		submitButton.addActionListener(server);
		
	}
	
	
}
