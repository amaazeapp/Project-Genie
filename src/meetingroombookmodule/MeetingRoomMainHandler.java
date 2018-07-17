package meetingroombookmodule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import genericmodule.MeetingInputData;
import gui.MainMeetingResourceWindow;

public class MeetingRoomMainHandler {
	
	private MainMeetingResourceWindow refMeetingResourceWindow ; 
	private MeetingInputData inputdata ; 
	private HashMap<Double,String> slotmap;
	private int interval = 2 ;
	
	public MeetingRoomMainHandler(MainMeetingResourceWindow inp)
	{
		refMeetingResourceWindow = inp ; 
	}
	
	public void processData() throws ParseException
	{
		ArrayList<MeetingRoomSubData> filteredRoomList = new ArrayList<MeetingRoomSubData>();
		slotmap = new HashMap<Double,String>() ; 
		Date from_date,to_date ;
		String from_time , to_time  ;
		String[] from_time_array , to_time_array;
		int start_time_range , end_time_range ;
		double counter = 0 ;
		
		//Step1 - Fetch the data 
		getInputData();
		
		//Step2 - Based on the Criterion Filter the Ref Table 
		filteredRoomList = filterData();
		
		//Step 3 - Based on the input Time prepare a HashMap with +/- 2 hours of difference 
		from_date = inputdata.getFrom_date();
		to_date = inputdata.getTo_date();
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		from_time = localDateFormat.format(from_date);
		to_time = localDateFormat.format(to_date);
		from_time_array = from_time.split(":");
		to_time_array = to_time.split(":");
		
		start_time_range = (Integer.parseInt(from_time_array[0]) - interval ) + (Integer.parseInt(from_time_array[1]));
		end_time_range = (Integer.parseInt(to_time_array[0]) + interval) + (Integer.parseInt(to_time_array[1])) ;
		
		counter = start_time_range ; 
		while (counter <= end_time_range)
		{
			slotmap.put(counter, "X");
			counter = counter + 0.5 ; 
		}
		
		//Step4 - Call the short-listed rooms to fetch the availability 
		
		
	
	
	}
	
	public void getInputData() throws ParseException
	{
		String data;
		Date inpdate ; 
		int  inp;
		boolean lb_vc;
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh/MM/ss");
		inputdata = new MeetingInputData();
		
		inpdate = (Date) refMeetingResourceWindow.from_date.getValue();
		inputdata.setFrom_date(inpdate);
		
		inpdate = (Date) refMeetingResourceWindow.to_date.getValue();
		inputdata.setTo_date(inpdate);
		
		data = refMeetingResourceWindow.num_of_attendees.getValue().toString();
		inp = Integer.parseInt(data);
		inputdata.setNum_of_attendees(inp);
		
		data = refMeetingResourceWindow.location.getValue().toString();
		inputdata.setLocation(data) ; 
		
		data = refMeetingResourceWindow.vc_yes.getText().toString();
		inputdata.setIs_vc_required(data);
		
		data = refMeetingResourceWindow.selectionpref.getValue().toString();
		inputdata.setSelection_pref(data);
		
	}
	
	public ArrayList<MeetingRoomSubData> filterData()
	{
		int rowcount = 0 ,cnt = 0 ,rowindex; 
		MeetingRoomSubData filteredRoomData ; 
		ArrayList<MeetingRoomSubData> filteredroomlist = new ArrayList<MeetingRoomSubData>();
		
		//Initial Filter based on - Location / Number  of Resources / VC required 
		Integer num_participants; 
		String location , vc_req,data ;
		int filteredData ; 
		
		//Fetch the data 
		num_participants = inputdata.getNum_of_attendees();
		location = inputdata.getLocation();
		vc_req = inputdata.isIs_vc_required();
		
		MeetingRoomReferenceData meetingrefData = new MeetingRoomReferenceData();
		JTable reftable =  meetingrefData.getRefTable();
		TableModel model = reftable.getModel();
		
		//TODO - Fix the filter 
		reftable.setRowSorter(new TableRowSorter<TableModel>(model));
		TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) reftable.getRowSorter();
		num_participants = num_participants - 1 ; 
		sorter.setRowFilter(RowFilter.numberFilter(ComparisonType.AFTER, num_participants , 4));
		rowcount = sorter.getViewRowCount();
		sorter.setRowFilter(RowFilter.regexFilter(location, 3));
		rowcount = sorter.getViewRowCount();
		
		if (vc_req.equalsIgnoreCase("Yes"))
		{
			sorter.setRowFilter(RowFilter.regexFilter(vc_req,5));
			rowcount = sorter.getViewRowCount();
		}
		
		while (cnt < rowcount )
		{
			filteredRoomData = new MeetingRoomSubData();
			rowindex = sorter.convertRowIndexToModel(cnt);
			
			//Room Name 
			data = (String) model.getValueAt(rowindex, 1);
			filteredRoomData.setRoomName(data);
			
			//Room Email ID
			data = (String) model.getValueAt(rowindex, 2);
			filteredRoomData.setRoomEmailId(data);
			
			//Location
			data = (String) model.getValueAt(rowindex, 3);
			filteredRoomData.setLocation(data);
			
			filteredroomlist.add(filteredRoomData);
			cnt++ ; 
			
		}
		
		return filteredroomlist ; 
		
	}
}
