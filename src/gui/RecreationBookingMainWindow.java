package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

public class RecreationBookingMainWindow extends JFrame {

	private JPanel contentPane;
	private JTable table ; 
	private LoginWindow refLoginWindow ; 
	
	/**
	 * Create the frame.
	 */
	public RecreationBookingMainWindow(LoginWindow inp ) {
		refLoginWindow = inp ; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recreation Booking");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 131, 21);
		contentPane.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Chess Board", "FoosBall", "Snooker", "CaromBoard", "Table Tenis"}));
		spinner.setBounds(10, 57, 120, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Show Availability");
		btnNewButton.setBounds(10, 88, 143, 23);
		contentPane.add(btnNewButton);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1531765800000L), null, null, Calendar.DAY_OF_MONTH));
		spinner_1.setBounds(145, 57, 120, 20);
		contentPane.add(spinner_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 122, 404, 215);
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
				"From Date-Time", "To Date-Time"
			}
		));
		table.setBounds(43, 277, 329, 40);
		scrollPane.setViewportView(table);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(10, 348, 143, 23);
		contentPane.add(btnBook);
	}
}
