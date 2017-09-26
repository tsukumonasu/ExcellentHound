package net.tnaiki.exellenthound.json.monitor;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Creator{

	@SerializedName("name")
	private String name;

	@SerializedName("handle")
	private String handle;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setHandle(String handle){
		this.handle = handle;
	}

	public String getHandle(){
		return handle;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"Creator{" + 
			"name = '" + name + '\'' + 
			",handle = '" + handle + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}