package com.laioffer.tinnews;

import android.app.Application;

import com.ashokvarma.gander.Gander;
import com.ashokvarma.gander.imdb.GanderIMDB;

public class TinNewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // add new code:
        Gander.setGanderStorage(GanderIMDB.getInstance());

    }

}
