package com.stunningcoders.puredependencyinjection;

import android.app.Application;

/**
 * Created by JS on 8/17/19.
 */

public class CustomApplication extends Application {

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    applicationComponent = new ApplicationComponent();
  }



}
