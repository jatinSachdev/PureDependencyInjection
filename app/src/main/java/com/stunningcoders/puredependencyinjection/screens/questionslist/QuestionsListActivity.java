package com.stunningcoders.puredependencyinjection.screens.questionslist;

import android.os.Bundle;

import com.stunningcoders.puredependencyinjection.BaseActivity;
import com.stunningcoders.puredependencyinjection.ViewMvcFactory;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionListListener;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionListNetworkHelper;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;
import com.stunningcoders.puredependencyinjection.screens.common.DialogManager;
import com.stunningcoders.puredependencyinjection.screens.common.ServerErrorDialogFragment;
import com.stunningcoders.puredependencyinjection.screens.questiondetails.QuestionDetailsActivity;

import java.util.List;

public class QuestionsListActivity extends BaseActivity implements QuestionsListViewMvc.Listener, FetchQuestionListListener {


  public QuestionsListViewMvc mvcImplementation;
  public FetchQuestionListNetworkHelper fetchQuestionListNetworkHelper;
  public DialogManager dialogManager;
  public ViewMvcFactory viewMvcFactory;

  @Override
  public void onQuestionClicked(QuestionWithBody question) {
    QuestionDetailsActivity.start(this, question.getId());
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getInjector().inject(this);
    mvcImplementation = viewMvcFactory.newInstance(QuestionListViewMvcImplementation.class, null);
    setContentView(mvcImplementation.getRootView());
  }

  @Override
  protected void onStart() {
    super.onStart();
    mvcImplementation.registerListener(this);
    fetchQuestionListNetworkHelper.registerListener(this);
    fetchQuestionListNetworkHelper.fetchLastActiveQuestionsAndNotify(20);
  }

  @Override
  protected void onStop() {
    super.onStop();
    mvcImplementation.unRegisterListener(this);
  }

  @Override
  public void onSuccess(List<QuestionWithBody> questions) {
    mvcImplementation.bindQuestions(questions);
  }

  @Override
  public void onFailure() {
    dialogManager.showDialog(ServerErrorDialogFragment.newInstance(), DialogManager.TAG_ALERT_SERVER_ERROR);
  }
}
