package com.stunningcoders.puredependencyinjection.screens.common;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by Jatin on 8/17/19.
 */
public class DialogManager {
  private FragmentManager fragmentManager;
  public static final String TAG_ALERT_SERVER_ERROR = "TAG_ALERT_SERVER_ERROR";

  public DialogManager(FragmentManager fragmentManager) {
    this.fragmentManager = fragmentManager;
  }

  public void showDialog(Fragment fragment, String tag){
    if(fragmentManager != null && isCurrentDialogAlreadyExists(tag)) {
      fragmentManager.beginTransaction().add(fragment, tag).commit();
    }
  }

  private boolean isCurrentDialogAlreadyExists(String tag) {
     Fragment fragment = fragmentManager.findFragmentByTag(tag);
     return fragment == null;
  }
}
