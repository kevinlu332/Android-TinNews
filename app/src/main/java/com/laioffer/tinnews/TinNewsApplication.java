package com.laioffer.tinnews;

import android.app.Application;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;
import com.facebook.stetho.Stetho;

public class TinNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // add new code:
        //add gander
        Gander.setGanderStorage(GanderIMDB.getInstance());
        //add Stetho: a debugging tool
        Stetho.initializeWithDefaults(this);
    }

}
