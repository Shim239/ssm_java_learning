package Lesson12;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("id")
	private String id;

	@JsonProperty("avatar")
	private String avatar;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("email")
	private String email;

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
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
			"DataItem{" +
					",id = '" + id + '\'' +
					",first_name = '" + firstName + '\'' +
					",last_name = '" + lastName + '\'' +
					",email = '" + email + '\'' +
					",avatar = '" + avatar + '\'' +
			"}";
		}
}