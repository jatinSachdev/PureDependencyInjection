package com.stunningcoders.puredependencyinjection.screens.questionslist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stunningcoders.puredependencyinjection.R;
import com.stunningcoders.puredependencyinjection.abstraction.OnQuestionClickListener;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jatin on 8/4/19.
 */
public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

  private final OnQuestionClickListener mOnQuestionClickListener;

  private List<QuestionWithBody> mQuestionsList = new ArrayList<>(0);

  public class QuestionViewHolder extends RecyclerView.ViewHolder {
    public TextView mTitle;

    public QuestionViewHolder(View view) {
      super(view);
      mTitle = view.findViewById(R.id.txt_title);
    }
  }

  public QuestionsAdapter(OnQuestionClickListener onQuestionClickListener) {
    mOnQuestionClickListener = onQuestionClickListener;
  }

  public void bindData(List<QuestionWithBody> questions) {
    mQuestionsList = new ArrayList<>(questions);
    notifyDataSetChanged();
  }

  @Override
  public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.layout_question_list_item, parent, false);

    return new QuestionViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(QuestionViewHolder holder, final int position) {
    holder.mTitle.setText(mQuestionsList.get(position).getTitle());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        mOnQuestionClickListener.onQuestionClicked(mQuestionsList.get(position));
      }
    });
  }

  @Override
  public int getItemCount() {
    return mQuestionsList.size();
  }
}
