package com.faveoffate.databasehelper;

/**
 * Created by egerbin on 9/15/2015.
 */

public class Contact {

    //private variables
    int _id;
    String fname;
    String lname;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String fname, String lname){
        this._id = id;
        this.fname = fname;
        this.lname = lname;
    }

    // constructor
    public Contact(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getFirstName(){
        return this.fname;
    }

    // setting name
    public void setFirstName(String fname){
        this.fname = fname;
    }

    // getting phone number
    public String getLastName(){
        return this.lname;
    }

    // setting phone number
    public void setLastName(String lname){
        this.lname = lname;
    }
}
