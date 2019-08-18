package com.stunningcoders.puredependencyinjection.abstraction;

import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

/**
 * Created by JS on 8/4/19.
 */
public interface OnQuestionClickListener {
  void onQuestionClicked(QuestionWithBody question);
}
