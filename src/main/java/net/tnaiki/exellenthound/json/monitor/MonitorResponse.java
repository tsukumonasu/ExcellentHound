package net.tnaiki.exellenthound.json.monitor;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class MonitorResponse {

	@SerializedName("creator")
	private Creator creator;

	@SerializedName("created")
	private String created;

	@SerializedName("query")
	private String query;

	@SerializedName("matching_downtimes")
	private List<Object> matchingDowntimes;

	@SerializedName("created_at")
	private long createdAt;

	@SerializedName("overall_state")
	private String overallState;

	@SerializedName("message")
	private String message;

	@SerializedName("type")
	private String type;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("multi")
	private boolean multi;

	@SerializedName("deleted")
	private Object deleted;

	@SerializedName("overall_state_modified")
	private String overallStateModified;

	@SerializedName("org_id")
	private int orgId;

	@SerializedName("name")
	private String name;

	@SerializedName("options")
	private Options options;

	@SerializedName("modified")
	private String modified;

	@SerializedName("id")
	private int id;

	public void setCreator(Creator creator){
		this.creator = creator;
	}

	public Creator getCreator(){
		return creator;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setMatchingDowntimes(List<Object> matchingDowntimes){
		this.matchingDowntimes = matchingDowntimes;
	}

	public List<Object> getMatchingDowntimes(){
		return matchingDowntimes;
	}

	public void setCreatedAt(long createdAt){
		this.createdAt = createdAt;
	}

	public long getCreatedAt(){
		return createdAt;
	}

	public void setOverallState(String overallState){
		this.overallState = overallState;
	}

	public String getOverallState(){
		return overallState;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setMulti(boolean multi){
		this.multi = multi;
	}

	public boolean isMulti(){
		return multi;
	}

	public void setDeleted(Object deleted){
		this.deleted = deleted;
	}

	public Object getDeleted(){
		return deleted;
	}

	public void setOverallStateModified(String overallStateModified){
		this.overallStateModified = overallStateModified;
	}

	public String getOverallStateModified(){
		return overallStateModified;
	}

	public void setOrgId(int orgId){
		this.orgId = orgId;
	}

	public int getOrgId(){
		return orgId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setOptions(Options options){
		this.options = options;
	}

	public Options getOptions(){
		return options;
	}

	public void setModified(String modified){
		this.modified = modified;
	}

	public String getModified(){
		return modified;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"MonitorResponse{" +
			"creator = '" + creator + '\'' + 
			",created = '" + created + '\'' + 
			",query = '" + query + '\'' + 
			",matching_downtimes = '" + matchingDowntimes + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",overall_state = '" + overallState + '\'' + 
			",message = '" + message + '\'' + 
			",type = '" + type + '\'' + 
			",tags = '" + tags + '\'' + 
			",multi = '" + multi + '\'' + 
			",deleted = '" + deleted + '\'' + 
			",overall_state_modified = '" + overallStateModified + '\'' + 
			",org_id = '" + orgId + '\'' + 
			",name = '" + name + '\'' + 
			",options = '" + options + '\'' + 
			",modified = '" + modified + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}