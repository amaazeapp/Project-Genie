package gui;

import java.awt.EventQueue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainLandingWindow extends JFrame {

	
	public MainLandingWindow() {
		getContentPane().setBackground(new Color(250, 235, 215));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Meeting");
		btnNewButton.setBounds(45, 90, 123, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cafeteria");
		btnNewButton_1.setBounds(178, 90, 119, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Library");
		btnNewButton_2.setBounds(45, 145, 123, 23);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Recreation");
		btnNewButton_3.setBounds(178, 145, 119, 23);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Select the Resource to book");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 11, 252, 41);
		getContentPane().add(lblNewLabel);
		setBounds(100, 100, 450, 300);

	}

}
