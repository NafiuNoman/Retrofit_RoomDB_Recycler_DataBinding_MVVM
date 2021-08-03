package com.example.roomdatabinding;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

@Database(entities = {DataModel.class},version =1)
public abstract class StudentDatabase extends androidx.room.RoomDatabase {

    public  abstract MyDao getDao();
    public static StudentDatabase INSTANCE;

    public static StudentDatabase getRoomInstance(Context context)
    {
        if (INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context,StudentDatabase.class,"SCHOOL DB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }


}
