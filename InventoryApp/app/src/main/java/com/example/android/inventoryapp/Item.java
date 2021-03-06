package com.example.android.inventoryapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alexa on 8/10/2016.
 */
public class Item implements Parcelable{

    private String name;
    private int quantity;
    private double price;
    private int id;
    private String imagePath;

    public Item(String name, int quantity, double price, String imagePath){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imagePath = imagePath;
        id = -1;
    }

    public Item (Parcel in){
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
        imagePath = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flag){
        out.writeString(name);
        out.writeInt(quantity);
        out.writeDouble(price);
        out.writeString(imagePath);
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {return imagePath;}

    public void setImagePath(String imagePath) {this.imagePath = imagePath;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
