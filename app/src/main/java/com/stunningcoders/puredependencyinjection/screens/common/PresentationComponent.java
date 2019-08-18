package com.stunningcoders.puredependencyinjection.screens.common;

import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.stunningcoders.puredependencyinjection.ApplicationComponent;
import com.stunningcoders.puredependencyinjection.ViewMvcFactory;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionDetailHelper;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionListNetworkHelper;

/**
 * Created by JS on 8/18/19.
 */
public class PresentationComponent {

  private final ApplicationComponent applicationComponent;
  private final FragmentManager fragmentManager;
  private final LayoutInflater layoutInflater;

  public PresentationComponent(ApplicationComponent applicationComponent, FragmentManager fragmentManager, LayoutInflater layoutInflater) {
    this.applicationComponent = applicationComponent;
    this.fragmentManager = fragmentManager;
    this.layoutInflater = layoutInflater;
  }

  public DialogManager getDialogManager(){
    return new DialogManager(fragmentManager);
  }

  public FetchQuestionDetailHelper getFetchQuestionDetailHelper(){
    return applicationComponent.getFetchQuestionDetailNetworkHelper();
  }

  public FetchQuestionListNetworkHelper getFetchQuestionListHelper(){
    return applicationComponent.getFetchQuestionListNetworkHelper();
  }

  public ViewMvcFactory getViewMvcFactory(){
    return new ViewMvcFactory(layoutInflater);
  }
}
