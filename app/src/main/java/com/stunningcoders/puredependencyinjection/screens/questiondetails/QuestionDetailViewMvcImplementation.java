package com.stunningcoders.puredependencyinjection.screens.questiondetails;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stunningcoders.puredependencyinjection.R;
import com.stunningcoders.puredependencyinjection.abstraction.BaseViewMvc;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

/**
 * Created by Jatin on 8/4/19.
 */
public class QuestionDetailViewMvcImplementation extends BaseViewMvc implements QuestionDetailViewMvc {

private TextView questionBody;

  public QuestionDetailViewMvcImplementation(LayoutInflater layoutInflater, ViewGroup container){
    setRootView(layoutInflater.inflate(R.layout.layout_question_details, container));
    questionBody = (TextView) findViewById(R.id.txt_question_body);
  }


  @Override
  public void bindQuestion(QuestionWithBody questionWithBody) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
      questionBody.setText(Html.fromHtml(questionWithBody.getBody(), Html.FROM_HTML_MODE_LEGACY));
    } else {
      questionBody.setText(Html.fromHtml(questionWithBody.getBody()));
    }
  }
}
