package net.tnaiki.exellenthound.json.events;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EventsResponse {

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"EventsResponse{" +
			"events = '" + events + '\'' + 
			"}";
		}
}