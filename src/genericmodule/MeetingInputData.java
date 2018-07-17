package genericmodule;


import java.util.Date;

public class MeetingInputData {
	
	private Date from_date;
	private Date to_date ; 
	private int num_of_attendees ; 
	private String location ; 
	private String  is_vc_required ; 
	private String selection_pref;
	
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public int getNum_of_attendees() {
		return num_of_attendees;
	}
	public void setNum_of_attendees(int num_of_attendees) {
		this.num_of_attendees = num_of_attendees;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String isIs_vc_required() {
		return is_vc_required;
	}
	public void setIs_vc_required(String is_vc_required) {
		this.is_vc_required = is_vc_required;
	}
	public String getSelection_pref() {
		return selection_pref;
	}
	public void setSelection_pref(String selection_pref) {
		this.selection_pref = selection_pref;
	}
	

}
