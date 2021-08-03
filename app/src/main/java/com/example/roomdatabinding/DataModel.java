package com.example.roomdatabinding;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "All Student")
public class DataModel {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "Name")
    private String name;

    @ColumnInfo(name = "Age")
    private int age;

    @SerializedName("class")
    @ColumnInfo(name = "Class")
    private int class_name;

    @ColumnInfo(name = "Address")
    private String address;


    public DataModel(String name, int age, int class_name, String address) {
        this.name = name;
        this.age = age;
        this.class_name = class_name;
        this.address = address;
    }

    public DataModel() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClass_name() {
        return class_name;
    }

    public void setClass_name(int class_name) {
        this.class_name = class_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", class_name=" + class_name +
                ", address='" + address + '\'' +
                '}';
    }
}
