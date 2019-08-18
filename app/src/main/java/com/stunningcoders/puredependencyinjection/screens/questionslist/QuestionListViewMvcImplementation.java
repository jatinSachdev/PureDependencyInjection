package com.stunningcoders.puredependencyinjection.screens.questionslist;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.stunningcoders.puredependencyinjection.R;
import com.stunningcoders.puredependencyinjection.abstraction.BaseViewMvc;
import com.stunningcoders.puredependencyinjection.abstraction.OnQuestionClickListener;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.List;

/**
 * Created by Jatin on 8/4/19.
 */
public class QuestionListViewMvcImplementation
    extends BaseViewMvc<QuestionsListViewMvc.Listener> implements QuestionsListViewMvc {

  private QuestionsAdapter mQuestionsAdapter;
  private OnQuestionClickListener onQuestionClickListener = new OnQuestionClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onQuestionClicked(QuestionWithBody question) {
      for (Listener listener : getListeners()) {
        listener.onQuestionClicked(question);
      }

    }
  };

  @Override
  public void bindQuestions(List<QuestionWithBody> questions) {
    mQuestionsAdapter.bindData(questions);
  }

  public QuestionListViewMvcImplementation(LayoutInflater layoutInflater, ViewGroup container) {
    setRootView(layoutInflater.inflate(R.layout.layout_questions_list, container));
    setUpRecyclerView();
  }

  private void setUpRecyclerView() {
    RecyclerView mRecyclerView = findViewById(R.id.recycler);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mQuestionsAdapter = new QuestionsAdapter(onQuestionClickListener);
    mRecyclerView.setAdapter(mQuestionsAdapter);
  }
}
