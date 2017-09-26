package net.tnaiki.exellenthound.json.events;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EventsItem{

	@SerializedName("is_aggregate")
	private boolean isAggregate;

	@SerializedName("comments")
	private List<Object> comments;

	@SerializedName("resource")
	private String resource;

	@SerializedName("source")
	private String source;

	@SerializedName("title")
	private String title;

	@SerializedName("priority")
	private String priority;

	@SerializedName("alert_type")
	private String alertType;

	@SerializedName("url")
	private String url;

	@SerializedName("tags")
	private List<String> tags;

	@SerializedName("device_name")
	private Object deviceName;

	@SerializedName("children")
	private List<ChildrenItem> children;

	@SerializedName("host")
	private Object host;

	@SerializedName("text")
	private String text;

	@SerializedName("id")
	private long id;

	@SerializedName("date_happened")
	private long dateHappened;

	public void setIsAggregate(boolean isAggregate){
		this.isAggregate = isAggregate;
	}

	public boolean isIsAggregate(){
		return isAggregate;
	}

	public void setComments(List<Object> comments){
		this.comments = comments;
	}

	public List<Object> getComments(){
		return comments;
	}

	public void setResource(String resource){
		this.resource = resource;
	}

	public String getResource(){
		return resource;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return priority;
	}

	public void setAlertType(String alertType){
		this.alertType = alertType;
	}

	public String getAlertType(){
		return alertType;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setDeviceName(Object deviceName){
		this.deviceName = deviceName;
	}

	public Object getDeviceName(){
		return deviceName;
	}

	public void setChildren(List<ChildrenItem> children){
		this.children = children;
	}

	public List<ChildrenItem> getChildren(){
		return children;
	}

	public void setHost(Object host){
		this.host = host;
	}

	public Object getHost(){
		return host;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setId(long id){
		this.id = id;
	}

	public long getId(){
		return id;
	}

	public void setDateHappened(long dateHappened){
		this.dateHappened = dateHappened;
	}

	public long getDateHappened(){
		return dateHappened;
	}

	@Override
 	public String toString(){
		return 
			"EventsItem{" + 
			"is_aggregate = '" + isAggregate + '\'' + 
			",comments = '" + comments + '\'' + 
			",resource = '" + resource + '\'' + 
			",source = '" + source + '\'' + 
			",title = '" + title + '\'' + 
			",priority = '" + priority + '\'' + 
			",alert_type = '" + alertType + '\'' + 
			",url = '" + url + '\'' + 
			",tags = '" + tags + '\'' + 
			",device_name = '" + deviceName + '\'' + 
			",children = '" + children + '\'' + 
			",host = '" + host + '\'' + 
			",text = '" + text + '\'' + 
			",id = '" + id + '\'' + 
			",date_happened = '" + dateHappened + '\'' + 
			"}";
		}
}