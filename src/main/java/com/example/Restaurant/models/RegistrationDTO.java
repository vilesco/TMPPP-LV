//Data transfer object for registering new users and sending user account info to client side
package com.example.Restaurant.models;

public class RegistrationDTO {
	private String username;
    private String password;
    private String email;
    private String accountType;

    public RegistrationDTO(){
        super();
    }

    public RegistrationDTO(String username, String email, String password, String accountType){
        super();
        this.username = username;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
    
    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
    	this.email = email;
    }
    
    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String toString(){
        return "Registration info: username: " + this.username + "email: " + this.email + " password: " + this.password;
    }

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
