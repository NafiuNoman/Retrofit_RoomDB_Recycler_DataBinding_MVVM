package com.example.roomdatabinding;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(DataModel... dataModels);

    @Query("SELECT * FROM `All Student`")
    List<DataModel> getStudent();




}
