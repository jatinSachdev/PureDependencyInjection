package com.stunningcoders.puredependencyinjection;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stunningcoders.puredependencyinjection.abstraction.ViewMvc;
import com.stunningcoders.puredependencyinjection.screens.questiondetails.QuestionDetailViewMvcImplementation;
import com.stunningcoders.puredependencyinjection.screens.questionslist.QuestionListViewMvcImplementation;

/**
 * Created by JS on 8/18/19.
 */

public class ViewMvcFactory {

  private LayoutInflater layoutInflater;

  public ViewMvcFactory(LayoutInflater layoutInflater) {
    this.layoutInflater = layoutInflater;
  }

 @SuppressWarnings("unchecked")
  public <T extends ViewMvc> T newInstance(Class<T> mvcViewClass, ViewGroup viewGroup){
    ViewMvc viewMvc;

    if(mvcViewClass == QuestionListViewMvcImplementation.class){
      viewMvc = new QuestionListViewMvcImplementation(layoutInflater, viewGroup);
    }else if (mvcViewClass == QuestionDetailViewMvcImplementation.class){
      viewMvc = new QuestionDetailViewMvcImplementation(layoutInflater, viewGroup);
    }else {
      throw new IllegalArgumentException("UnSupported viewMvc Class " + mvcViewClass);
    }
    return (T)viewMvc;
  }
}
