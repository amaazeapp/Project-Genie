package genericmodule;

import gui.LoginWindow;
import gui.MainMeetingResourceWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import meetingroombookmodule.MeetingRoomMainHandler;


public class ActionListeners implements ActionListener {
	
	private LoginWindow loginwindow ; 
	private MeetingRoomMainHandler meetingHandler ; 
	
	public ActionListeners(LoginWindow input)
	{
		loginwindow = input ; 
	}

	public void actionPerformed(ActionEvent arg0) {
		String commandbutton  = arg0.getActionCommand() ; 
		
		if (commandbutton.equalsIgnoreCase("login"))
		{
			loginwindow.handlevisibility("LoginWindow", false);
			loginwindow.handlevisibility("MainLandingWindow", true);
		}
		
		if (commandbutton.equalsIgnoreCase("meeting"))
		{
			loginwindow.handlevisibility("MainLandingWindow", false);
			loginwindow.handlevisibility("MainMeetingResourceWindow", true);
		}
		
		if (commandbutton.equalsIgnoreCase("cafeteria"))
		{
			loginwindow.handlevisibility("MainLandingWindow", false);
			loginwindow.handlevisibility("CafeteriaBookingMainWindow", true);
		}
		
		if(commandbutton.equalsIgnoreCase("recreation"))
		{
			loginwindow.handlevisibility("MainLandingWindow", false);
			loginwindow.handlevisibility("RecreationBookingMainWindow", true);
		}
		
		//Handle the book event from the MainMeetingResourceWindow
		if (commandbutton.equalsIgnoreCase("book"))
		{
			MainMeetingResourceWindow meetingWindow ; 
			meetingWindow = loginwindow.getMainMeetingResourceWindow() ; 
			meetingHandler = new MeetingRoomMainHandler(meetingWindow);
			try {
				meetingHandler.processData();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}

}
