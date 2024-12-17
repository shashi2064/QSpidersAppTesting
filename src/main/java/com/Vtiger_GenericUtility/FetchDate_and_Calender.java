package com.Vtiger_GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FetchDate_and_Calender {
	
	SimpleDateFormat simpleformat=null;

	public String getDate() {

		Date dobj = new Date();

		simpleformat= new SimpleDateFormat("yyyy-MM-dd");

		String startdate = simpleformat.format(dobj);

		System.out.println(startdate);
		
		return startdate;
		
		}
	
	public String getcalender()
	{
		Calendar cal = simpleformat.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, 45);
		
		String end_date = simpleformat.format(cal.getTime());
		
		System.out.println(end_date);
		
		return end_date;
	}

}
