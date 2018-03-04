package com.qnally.shappapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qnally.shappapp.Finance;
import com.qnally.shappapp.Shipping;


/*
 * Hakeem Kiser and Brandon Lu
 * This is a constructor class for the object Account
 */
public class Account extends AppCompatActivity {


	public static DBHandler db= new DBHandler();
//This method creates a saved state to view
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		}





	String email,firstName,lastName,preferredName,password,phoneNumber;
	
	Shipping shipping = new Shipping();
	Finance finance = new Finance();
	
	/**
	 * Empty constructor for Object Account
	 * Holds account information
	 */
	public Account()
	{
		
	}
	public Account(String email, String firstName, String lastName, String phoneNumber){
		this.email=email;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	/**
	 * Constructor for Object Account with parameters
	 * Holds account information
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param preferredName
	 * @param shipping
	 * @param phoneNumber
	 */
	public Account(String email, String firstName,String lastName, String preferredName, String password, Shipping shipping, Finance finance, String phoneNumber)
	{
		this.email = email;

		this.firstName = firstName;

		this.lastName = lastName;

		this.preferredName = preferredName;

		this.password = password;

		this.shipping = shipping;

		this.finance = finance;

		this.phoneNumber=phoneNumber;

	}
	
	/**
	 * This method returns the current email of the Account object
	 */
	public String getEmail()
	{
		return this.email;
	}
	
	/**
	 * These methods return the current name of the Account object
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	
	/**
	 * This method returns the current preferred name of the Account object
	 */
	public String getPref()
	{
		return preferredName;
	}
	
	/**
	 * This method returns the current password of the Account object
	 */
	public String getPass()
	{
		return password;
	}
	
	/**
	 * This method returns the current shipping information of the Account object
	 */
	public Shipping getShipping()
	{
		return shipping;
	}
	
	/**
	 * This method returns the current financial information of the Acount object
	 */
	public Finance getFinance()
	{
		return finance;
	}
	/**
	 * This method returns the current phone number of the Account object
	 */
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	
	/**
	 * This method changes the current email of the Account object to the user input
	 */
	public void setEmail(String email)
	{
		this.email = email;

	}
	
	/**
	 * This method changes the current name of the Account object to the user input
	 */
	public void setName(String firstName)
	{
		this.firstName = firstName;
	}
	
	/**
	 * This method changes the current preferred name of the Account object to the user input
	 */
	public void setPref(String preferredName)
	{
		this.preferredName = preferredName;
	}
	
	/**
	 * This method changes the current password of the Account object to the user input
	 */
	public void setPass(String password)
	{
		this.password = password;
	}

	/**
	 * This method sets the current shipping information of the Account object
	 */
	public void setShipping(String address, String city, String state, String zipCode)
	{
		this.shipping= new Shipping(address,city,state,zipCode);
	}
	/**
	 * This method sets the current financial information of the Account object
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber= phoneNumber;
	}

	/**
	 * This method sets the current financial information of the Account object
	 */
	public void setFinance(Credit credit, Billing billing)
	{
		 this.finance= new Finance(credit,billing);
	}
	/**
	 * This method prints all parameters of Object Account
	 */
	public String toString()
	{
		return String.format("Email: " + getEmail() + "\n" + "First Name: " + getFirstName() + "Last Name: " + getLastName() + "\n" + "Preferred Name: " + getPref() + "\n" + "Password: " + getPass() + "\n\n" + "Shipping Information:\n" + getShipping() + "\n\n" + "Financial Information: \n" + getFinance());
//		String.format("Name: " + getName());
//		String.format("Preferred Name: " + getPref());
//		String.format("Shipping Information: " + getShipping());
		
	}
}

