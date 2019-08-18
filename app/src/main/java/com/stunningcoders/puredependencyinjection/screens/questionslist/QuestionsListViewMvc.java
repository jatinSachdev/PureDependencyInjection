package com.stunningcoders.puredependencyinjection.screens.questionslist;

import com.stunningcoders.puredependencyinjection.abstraction.ObservableViewMvc;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.List;

/**
 * Created by Jatin on 8/3/19.
 */
public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener>{

  interface Listener {
    void onQuestionClicked(QuestionWithBody question);
  }

  void bindQuestions(List<QuestionWithBody> questions);
}
