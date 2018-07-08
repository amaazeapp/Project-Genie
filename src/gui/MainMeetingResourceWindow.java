package gui;

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
import javax.swing.SpinnerListModel;
import javax.swing.JRadioButton;

public class MainMeetingResourceWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMeetingResourceWindow frame = new MainMeetingResourceWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMeetingResourceWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 475);
		contentPane = new JPanel();
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
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(158, 102, 46, 20);
		contentPane.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBackground(new Color(100, 149, 237));
		spinner_1.setForeground(new Color(253, 245, 230));
		spinner_1.setModel(new SpinnerDateModel(new Date(1530988200000L), null, null, Calendar.DAY_OF_WEEK));
		spinner_1.setBounds(122, 36, 154, 20);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerDateModel(new Date(1530988200000L), new Date(1530988200000L), null, Calendar.DAY_OF_YEAR));
		spinner_2.setForeground(new Color(253, 245, 230));
		spinner_2.setBackground(new Color(100, 149, 237));
		spinner_2.setBounds(122, 66, 154, 20);
		contentPane.add(spinner_2);
		
		JLabel lblLocationPref = new JLabel("Location Pref");
		lblLocationPref.setBounds(233, 108, 76, 14);
		contentPane.add(lblLocationPref);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerListModel(new String[] {"Tower 3", "Tower 5", "Tower 11", "Tower 14", "Tower 15"}));
		spinner_3.setBounds(338, 105, 76, 20);
		contentPane.add(spinner_3);
		
		JLabel lblVcRequired = new JLabel("VC Required");
		lblVcRequired.setBounds(10, 140, 76, 14);
		contentPane.add(lblVcRequired);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setBounds(93, 136, 46, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(146, 136, 46, 23);
		contentPane.add(rdbtnNo);
	}
}
