package com.stunningcoders.puredependencyinjection.networking;

import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.List;

/**
 * Created by JS on 8/17/19.
 */
public interface FetchQuestionListListener {

  void onSuccess(List<QuestionWithBody> questions);

  void onFailure();

}
