package com.cromiumapps.uwhub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.util.Log;

public class EventsData {

	//private
	Context context;
	
	String id = null;
	String date = null;
	String name = null;
	String links = null;
	String description = null;
	String where = null;
	
	SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
	
	public EventsData (String inputID, String inputDate, String inputName, String inputLinks, String inputDescription, String inputWhere) {
	    id = inputID;
	    date = inputDate;
	    name = inputName;
	    links = inputLinks;
	    description = inputDescription;
	    where = inputWhere;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getLocation()
	{
		return this.where;
	}
	
	public long getDateTimeInMilis()
	{
        SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = day.getCalendar();
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)+1);
        cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+80);
        Log.d("CalendarQuery","returning calendar of day"+cal.get(Calendar.DATE)+","+cal.get(Calendar.MONTH)+","+cal.get(Calendar.YEAR));
        return cal.getTimeInMillis();
	}
	
	public String getName() {
		return StringCleaner.replaceHTML(name);
	}
	
	public String getLinks() {
		return StringCleaner.getLink(links);
	}
	
	public String getDescription() {
		return StringCleaner.cleanContent(description);
	}
}
