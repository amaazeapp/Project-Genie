package gui;

import genericmodule.ActionListeners;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;

import java.util.Date;
import java.util.Calendar;

import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMeetingResourceWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private LoginWindow refloginwindow ; 
	private ActionListeners reflisteners ; 
	public  JSpinner from_date , to_date , location , num_of_attendees , selectionpref ;
	public  JRadioButton vc_yes , vc_no ; 

	/**
	 * Create the frame.
	 */
	public MainMeetingResourceWindow(LoginWindow inp) {
		refloginwindow = inp ; 
		reflisteners = refloginwindow.getActionListener();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 475);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meeting Room Booking");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(new Color(135, 206, 235));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 194, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From Date");
		lblNewLabel_1.setBounds(10, 36, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblToDate = new JLabel("To Date");
		lblToDate.setBounds(10, 69, 76, 14);
		contentPane.add(lblToDate);
		
		JLabel lblNumberOfAttendees = new JLabel("Number of Attendees");
		lblNumberOfAttendees.setBounds(10, 105, 138, 14);
		contentPane.add(lblNumberOfAttendees);
		
		num_of_attendees = new JSpinner();
		num_of_attendees.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		num_of_attendees.setBounds(158, 102, 46, 20);
		contentPane.add(num_of_attendees);
		
		from_date = new JSpinner();
		from_date.setBackground(new Color(100, 149, 237));
		from_date.setForeground(new Color(253, 245, 230));
		from_date.setModel(new SpinnerDateModel(new Date(1528396200000L), null, null, Calendar.DAY_OF_WEEK_IN_MONTH));
		from_date.setBounds(122, 36, 154, 20);
		contentPane.add(from_date);
		
		to_date = new JSpinner();
		to_date.setModel(new SpinnerDateModel(new Date(1530988200000L), new Date(1530988200000L), null, Calendar.DAY_OF_YEAR));
		to_date.setForeground(new Color(253, 245, 230));
		to_date.setBackground(new Color(100, 149, 237));
		to_date.setBounds(122, 66, 154, 20);
		contentPane.add(to_date);
		
		JLabel lblLocationPref = new JLabel("Location");
		lblLocationPref.setBounds(233, 108, 76, 14);
		contentPane.add(lblLocationPref);
		
		location = new JSpinner();
		location.setModel(new SpinnerListModel(new String[] {"Tower3", "Tower5", "Tower11", "Tower14", "Tower15"}));
		location.setBounds(319, 102, 76, 20);
		contentPane.add(location);
		
		JLabel lblVcRequired = new JLabel("VC Required");
		lblVcRequired.setBounds(10, 140, 76, 14);
		contentPane.add(lblVcRequired);
		
		vc_yes = new JRadioButton("Yes");
		vc_yes.setBounds(93, 136, 46, 23);
		contentPane.add(vc_yes);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(reflisteners);
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 182, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExplore = new JButton("Explore");
		btnExplore.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExplore.setBounds(156, 182, 89, 23);
		contentPane.add(btnExplore);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 220, 404, 215);
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
				"Date-Time", "Resources-Available"
			}
		));
		table.setBounds(43, 277, 329, 40);
		scrollPane.setViewportView(table);
		
		JLabel lblSelectionPref = new JLabel("Preference");
		lblSelectionPref.setBounds(233, 140, 76, 14);
		contentPane.add(lblSelectionPref);
		
		selectionpref = new JSpinner();
		selectionpref.setModel(new SpinnerListModel(new String[] {"NA", "Location", "Attendees Count", "VC required", "No Preference"}));
		selectionpref.setBounds(319, 137, 112, 20);
		contentPane.add(selectionpref);
		scrollPane.setVisible(true);
		
	}
}
