package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;

public class CafeteriaBookingMainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LoginWindow refloginwindow ; 
	
	public CafeteriaBookingMainWindow(LoginWindow inp) {
		refloginwindow = inp ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 454);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Cafeteria Meal Booking");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 206, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vendor List");
		lblNewLabel_1.setForeground(new Color(0, 100, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 54, 65, 19);
		contentPane.add(lblNewLabel_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Mega Meals", "Food Ultimate", "Food Delight"}));
		spinner.setBounds(111, 54, 138, 20);
		contentPane.add(spinner);
		
		JLabel lblTimeSlotTo = new JLabel("Time Slot to Book");
		lblTimeSlotTo.setForeground(new Color(0, 100, 0));
		lblTimeSlotTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimeSlotTo.setBounds(10, 84, 124, 19);
		contentPane.add(lblTimeSlotTo);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1531679400000L), null, null, Calendar.AM_PM));
		spinner_1.setBounds(125, 84, 124, 20);
		contentPane.add(spinner_1);
		
		JButton btnNewButton = new JButton("Menu");
		btnNewButton.setBounds(10, 114, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 148, 404, 215);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Dish Name", "Price"
			}
		));
		table.setBounds(43, 277, 329, 40);
		scrollPane.setViewportView(table);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(10, 374, 89, 23);
		contentPane.add(btnBook);
	}
}
