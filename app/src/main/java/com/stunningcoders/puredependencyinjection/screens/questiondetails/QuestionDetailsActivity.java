package com.stunningcoders.puredependencyinjection.screens.questiondetails;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stunningcoders.puredependencyinjection.BaseActivity;
import com.stunningcoders.puredependencyinjection.ViewMvcFactory;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionDetailHelper;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionDetailListener;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;
import com.stunningcoders.puredependencyinjection.screens.common.DialogManager;
import com.stunningcoders.puredependencyinjection.screens.common.ServerErrorDialogFragment;

public class QuestionDetailsActivity extends BaseActivity implements FetchQuestionDetailListener {

  public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

  public static void start(Context context, String questionId) {
    Intent intent = new Intent(context, QuestionDetailsActivity.class);
    intent.putExtra(EXTRA_QUESTION_ID, questionId);
    context.startActivity(intent);
  }

  private QuestionDetailViewMvc questionDetailViewMvc;

  public FetchQuestionDetailHelper fetchQuestionDetailHelper;

  private String mQuestionId;

  public DialogManager dialogManager;

  public ViewMvcFactory viewMvcFactory;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getInjector().inject(this);
    questionDetailViewMvc = viewMvcFactory.newInstance(QuestionDetailViewMvcImplementation.class, null);
    setContentView(questionDetailViewMvc.getRootView());
    Bundle bundle = getIntent().getExtras();
    if (bundle != null)
      mQuestionId = bundle.getString(EXTRA_QUESTION_ID, "0");


  }

  @Override
  protected void onStart() {
    super.onStart();
    fetchQuestionDetailHelper.registerListener(this);
    fetchQuestionDetailHelper.fetchQuestionDetailAndNotify(mQuestionId);
  }

  @Override
  protected void onStop() {
    super.onStop();
    fetchQuestionDetailHelper.unRegisterListener(this);
  }


  @Override
  public void onSuccess(QuestionWithBody question) {
    questionDetailViewMvc.bindQuestion(question);
  }

  @Override
  public void onFailure() {
    dialogManager.showDialog(ServerErrorDialogFragment.newInstance(), DialogManager.TAG_ALERT_SERVER_ERROR);
  }
}
