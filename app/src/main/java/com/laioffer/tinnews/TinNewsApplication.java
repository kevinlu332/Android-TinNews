package com.laioffer.tinnews;

import android.app.Application;

import androidx.room.Room;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;
import com.laioffer.tinnews.database.TinNewsDatabase;

public class TinNewsApplication extends Application {
    private TinNewsDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        // add new code:
        //add gander
        Gander.setGanderStorage(GanderIMDB.getInstance());
        //add Stetho: a debugging tool
        Stetho.initializeWithDefaults(this);
        //create db
        database=Room.databaseBuilder(this,
                TinNewsDatabase.class, "tinnews_db").build();
    }
    //add database accessor
    public TinNewsDatabase getDatabase(){
        return database;
    }
}
