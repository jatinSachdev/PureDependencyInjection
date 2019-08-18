package com.stunningcoders.puredependencyinjection.abstraction;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

/**
 * Created by JS on 8/3/19.
 */
public abstract class BaseViewMvc<ListenerType>
    extends BaseObservable<ListenerType>  implements ObservableViewMvc<ListenerType> {


  private View mRootView;

  @Override
  public View getRootView() {
    return mRootView;
  }

  @SuppressWarnings("unchecked")
  public <T extends View> T findViewById(@IdRes int id){
    return (T)mRootView.findViewById(id);
  }

  public void setRootView(View mRootView) {
    this.mRootView = mRootView;
  }

  public Context getContext(){
    return mRootView.getContext();
  }

  public String getString(@StringRes  int id){
    return getContext().getString(id);
  }
}
