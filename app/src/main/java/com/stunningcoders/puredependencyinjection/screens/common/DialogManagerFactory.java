package com.stunningcoders.puredependencyinjection.screens.common;

import android.support.v4.app.FragmentManager;

/**
 * Created by Jatin on 8/18/19.
 */
public class DialogManagerFactory {

  public DialogManager newInstance(FragmentManager fragmentManager) {
    return new DialogManager(fragmentManager);
  }
}
