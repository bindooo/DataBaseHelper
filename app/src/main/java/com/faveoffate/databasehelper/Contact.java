package com.faveoffate.databasehelper;

/**
 * Created by egerbin on 9/15/2015.
 */

public class Contact {

    //private variables
    int _id;
    String barcode;
    String product;

    // Empty constructor
    public Contact(){

    }
    // constructor
    public Contact(int id, String barcode, String product){
        this._id = id;
        this.barcode = barcode;
        this.product = product;
    }

    // constructor
    public Contact(String barcode, String product){
        this.barcode = barcode;
        this.product = product;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getBarcode(){
        return this.barcode;
    }

    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    public String getProduct(){
        return this.product;
    }

    public void setProduct(String product){
        this.product = product;
    }
}
