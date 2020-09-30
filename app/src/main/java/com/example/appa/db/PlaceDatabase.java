package com.example.appa.db;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.appa.model.Place;

@Database(entities = PlaceEntity.class, version = 1)

public abstract class PlaceDatabase extends RoomDatabase {
    // This class is a singleton
    private static PlaceDatabase instance;

    public abstract PlaceDao placeListDao();

    public static synchronized PlaceDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), PlaceDatabase.class, "place_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
