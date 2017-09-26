package net.tnaiki.exellenthound.json.monitor;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Options{

	@SerializedName("silenced")
	private Silenced silenced;

	@SerializedName("no_data_timeframe")
	private int noDataTimeframe;

	@SerializedName("thresholds")
	private Thresholds thresholds;

	@SerializedName("new_host_delay")
	private int newHostDelay;

	@SerializedName("renotify_interval")
	private int renotifyInterval;

	@SerializedName("notify_no_data")
	private boolean notifyNoData;

	@SerializedName("include_tags")
	private boolean includeTags;

	@SerializedName("timeout_h")
	private int timeoutH;

	@SerializedName("escalation_message")
	private String escalationMessage;

	@SerializedName("locked")
	private boolean locked;

	@SerializedName("notify_audit")
	private boolean notifyAudit;

	public void setSilenced(Silenced silenced){
		this.silenced = silenced;
	}

	public Silenced getSilenced(){
		return silenced;
	}

	public void setNoDataTimeframe(int noDataTimeframe){
		this.noDataTimeframe = noDataTimeframe;
	}

	public int getNoDataTimeframe(){
		return noDataTimeframe;
	}

	public void setThresholds(Thresholds thresholds){
		this.thresholds = thresholds;
	}

	public Thresholds getThresholds(){
		return thresholds;
	}

	public void setNewHostDelay(int newHostDelay){
		this.newHostDelay = newHostDelay;
	}

	public int getNewHostDelay(){
		return newHostDelay;
	}

	public void setRenotifyInterval(int renotifyInterval){
		this.renotifyInterval = renotifyInterval;
	}

	public int getRenotifyInterval(){
		return renotifyInterval;
	}

	public void setNotifyNoData(boolean notifyNoData){
		this.notifyNoData = notifyNoData;
	}

	public boolean isNotifyNoData(){
		return notifyNoData;
	}

	public void setIncludeTags(boolean includeTags){
		this.includeTags = includeTags;
	}

	public boolean isIncludeTags(){
		return includeTags;
	}

	public void setTimeoutH(int timeoutH){
		this.timeoutH = timeoutH;
	}

	public int getTimeoutH(){
		return timeoutH;
	}

	public void setEscalationMessage(String escalationMessage){
		this.escalationMessage = escalationMessage;
	}

	public String getEscalationMessage(){
		return escalationMessage;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}

	public boolean isLocked(){
		return locked;
	}

	public void setNotifyAudit(boolean notifyAudit){
		this.notifyAudit = notifyAudit;
	}

	public boolean isNotifyAudit(){
		return notifyAudit;
	}

	@Override
 	public String toString(){
		return 
			"Options{" + 
			"silenced = '" + silenced + '\'' + 
			",no_data_timeframe = '" + noDataTimeframe + '\'' + 
			",thresholds = '" + thresholds + '\'' + 
			",new_host_delay = '" + newHostDelay + '\'' + 
			",renotify_interval = '" + renotifyInterval + '\'' + 
			",notify_no_data = '" + notifyNoData + '\'' + 
			",include_tags = '" + includeTags + '\'' + 
			",timeout_h = '" + timeoutH + '\'' + 
			",escalation_message = '" + escalationMessage + '\'' + 
			",locked = '" + locked + '\'' + 
			",notify_audit = '" + notifyAudit + '\'' + 
			"}";
		}
}