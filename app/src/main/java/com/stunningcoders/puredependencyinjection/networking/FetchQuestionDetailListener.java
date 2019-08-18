package com.stunningcoders.puredependencyinjection.networking;

import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

/**
 * Created by JS on 8/17/19.
 */
public interface FetchQuestionDetailListener {

  void onSuccess(QuestionWithBody question);

  void onFailure();

}
