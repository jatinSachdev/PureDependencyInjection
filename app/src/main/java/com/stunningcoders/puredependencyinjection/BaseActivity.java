package com.stunningcoders.puredependencyinjection;

import android.support.v7.app.AppCompatActivity;

import com.stunningcoders.puredependencyinjection.screens.common.Injector;
import com.stunningcoders.puredependencyinjection.screens.common.PresentationComponent;


/**
 * Created by JS on 8/16/19.
 */

public class BaseActivity extends AppCompatActivity {


  private Injector injector;

  protected Injector getInjector() {
    if (injector == null) {
      injector = new Injector(getPresentationComponent());
    }
    return injector;
  }


  private PresentationComponent getPresentationComponent() {
    return new PresentationComponent(getApplicationComponent(), getSupportFragmentManager(), getLayoutInflater());
  }

  private ApplicationComponent getApplicationComponent() {
    return ((CustomApplication) getApplication()).getApplicationComponent();
  }
}
