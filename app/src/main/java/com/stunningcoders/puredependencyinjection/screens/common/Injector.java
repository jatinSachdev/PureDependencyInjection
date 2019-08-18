package com.stunningcoders.puredependencyinjection.screens.common;

/**
 * Created by JS on 8/18/19.
 */

import com.stunningcoders.puredependencyinjection.BaseActivity;
import com.stunningcoders.puredependencyinjection.screens.questiondetails.QuestionDetailsActivity;
import com.stunningcoders.puredependencyinjection.screens.questionslist.QuestionsListActivity;

/**
 * Wrapper around @{@link PresentationComponent}
 */
public class Injector {

  private PresentationComponent presentationComponent;

  public Injector(PresentationComponent presentationComponent) {
    this.presentationComponent = presentationComponent;
  }


  public <T extends  BaseActivity> void inject(T client){
    if(client instanceof QuestionsListActivity){
      injectQuestionListActivity((QuestionsListActivity)client);
    }else if(client instanceof QuestionDetailsActivity){
      injectQuestionDetailActivity((QuestionDetailsActivity)client);
    }
  }

  private void injectQuestionDetailActivity(QuestionDetailsActivity client) {
    client.viewMvcFactory = presentationComponent.getViewMvcFactory();
    client.dialogManager = presentationComponent.getDialogManager();
    client.fetchQuestionDetailHelper = presentationComponent.getFetchQuestionDetailHelper();
  }

  private void injectQuestionListActivity(QuestionsListActivity client) {
    client.viewMvcFactory = presentationComponent.getViewMvcFactory();
    client.dialogManager = presentationComponent.getDialogManager();
    client.fetchQuestionListNetworkHelper = presentationComponent.getFetchQuestionListHelper();
  }
}
