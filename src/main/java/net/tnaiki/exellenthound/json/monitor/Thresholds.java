package net.tnaiki.exellenthound.json.monitor;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Thresholds{

	@SerializedName("critical")
	private String critical;

	@SerializedName("warning")
	private String warning;

	@SerializedName("ok")
	private int ok;

	public void setCritical(String critical){
		this.critical = critical;
	}

	public String getCritical(){
		return critical;
	}

	public void setWarning(String warning){
		this.warning = warning;
	}

	public String getWarning(){
		return warning;
	}

	public void setOk(int ok){
		this.ok = ok;
	}

	public int getOk(){
		return ok;
	}

	@Override
 	public String toString(){
		return 
			"Thresholds{" + 
			"critical = '" + critical + '\'' + 
			",warning = '" + warning + '\'' + 
			",ok = '" + ok + '\'' + 
			"}";
		}
}