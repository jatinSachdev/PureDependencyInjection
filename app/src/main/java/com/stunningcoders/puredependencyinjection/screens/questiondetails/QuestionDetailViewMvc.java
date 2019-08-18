package com.stunningcoders.puredependencyinjection.screens.questiondetails;

import com.stunningcoders.puredependencyinjection.abstraction.ObservableViewMvc;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

/**
 * Created by Jatin on 8/4/19.
 */
public interface QuestionDetailViewMvc extends ObservableViewMvc {

  void bindQuestion(QuestionWithBody questionWithBody);
}
