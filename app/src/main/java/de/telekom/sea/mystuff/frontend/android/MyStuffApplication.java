package de.telekom.sea.mystuff.frontend.android;

import android.app.Application;

import lombok.Getter;
import timber.log.Timber;

public class MyStuffApplication extends Application {

    @Getter
    private static MyStuffApplication instance;
    @Getter
    private MyStuffContext myStuffContext;

    public static MyStuffApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myStuffContext = new MyStuffContext();
        myStuffContext.initWithApplication(this);

        initTimber();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
