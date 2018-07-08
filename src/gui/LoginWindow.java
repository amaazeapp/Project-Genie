package gui;

import genericmodule.ActionListeners;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frmGenie;
	private JTextField textField;
	private JPasswordField passwordField;
	private MainLandingWindow mainwindow ; 
	private ActionListeners actionListener ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmGenie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGenie = new JFrame();
		mainwindow = new MainLandingWindow();
		actionListener = new ActionListeners(this);
	
		
		frmGenie.getContentPane().setBackground(new Color(255, 250, 205));
		frmGenie.setTitle("Genie");
		frmGenie.setBounds(100, 100, 450, 300);
		frmGenie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGenie.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("User ID");
		lblLogin.setForeground(new Color(255, 0, 0));
		lblLogin.setBounds(138, 93, 46, 14);
		frmGenie.getContentPane().add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(215, 90, 86, 20);
		frmGenie.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 0, 0));
		lblPassword.setBounds(138, 128, 67, 14);
		frmGenie.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(215, 121, 86, 20);
		frmGenie.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 255, 0));
		btnLogin.addActionListener(actionListener);
		btnLogin.setBackground(new Color(176, 196, 222));
		btnLogin.setBounds(138, 163, 89, 23);
		frmGenie.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("Welcome To Genie - Shared Resource booking System");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 26, 376, 31);
		frmGenie.getContentPane().add(lblNewLabel);
	}
	
	public void handlevisibility(String windowname , boolean visibility )
	{
		if(windowname.equalsIgnoreCase("LoginWindow"))
			frmGenie.setVisible(visibility);
		if(windowname.equalsIgnoreCase("MainLandingWindow"))
			mainwindow.setVisible(visibility) ; 
	}
}
