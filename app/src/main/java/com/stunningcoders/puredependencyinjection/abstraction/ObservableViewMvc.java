package com.stunningcoders.puredependencyinjection.abstraction;

/**
 * Created by JS on 8/3/19.
 */
public interface ObservableViewMvc<ListenerType> extends ViewMvc {


  void registerListener(ListenerType listener);

  void unRegisterListener(ListenerType listener);

}
