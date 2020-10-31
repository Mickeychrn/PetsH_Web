package usyd.elec5619.petsh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDate {
	
	private Date date;
	


	public ChangeDate(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		SimpleDateFormat myFmt=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return myFmt.format(getDate());
	}
	
	
	
	

}
