package com.stunningcoders.puredependencyinjection.abstraction;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by JS on 8/3/19.
 */
public abstract class BaseObservable<ListenerType> {

  private Set<ListenerType> mListeners = Collections.newSetFromMap(
      new ConcurrentHashMap<ListenerType, Boolean>(1));


  protected final Set<ListenerType> getListeners() {
    return Collections.unmodifiableSet(mListeners);
  }


  public final void registerListener(ListenerType listener) {
    mListeners.add(listener);
  }

  public final void unRegisterListener(ListenerType listener) {
    mListeners.remove(listener);
  }
}
