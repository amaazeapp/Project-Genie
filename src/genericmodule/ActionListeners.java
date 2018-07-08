package genericmodule;

import gui.LoginWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListeners implements ActionListener {
	
	private LoginWindow loginwindow ; 
	
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
		
		
	}

}
