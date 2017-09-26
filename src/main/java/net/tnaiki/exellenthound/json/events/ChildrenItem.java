package net.tnaiki.exellenthound.json.events;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ChildrenItem{

	@SerializedName("id")
	private String id;

	@SerializedName("alert_type")
	private String alertType;

	@SerializedName("date_happened")
	private int dateHappened;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAlertType(String alertType){
		this.alertType = alertType;
	}

	public String getAlertType(){
		return alertType;
	}

	public void setDateHappened(int dateHappened){
		this.dateHappened = dateHappened;
	}

	public int getDateHappened(){
		return dateHappened;
	}

	@Override
 	public String toString(){
		return 
			"ChildrenItem{" + 
			"id = '" + id + '\'' + 
			",alert_type = '" + alertType + '\'' + 
			",date_happened = '" + dateHappened + '\'' + 
			"}";
		}
}