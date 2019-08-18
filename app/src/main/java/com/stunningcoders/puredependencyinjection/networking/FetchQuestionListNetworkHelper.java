package com.stunningcoders.puredependencyinjection.networking;

import com.stunningcoders.puredependencyinjection.abstraction.BaseObservable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by JS on 8/17/19.
 */
public class FetchQuestionListNetworkHelper extends BaseObservable<FetchQuestionListListener> implements Callback<QuestionsListResponseSchema> {

  private Call<QuestionsListResponseSchema> mCall;
  private StackoverflowApi mStackoverflowApi;

  public FetchQuestionListNetworkHelper(StackoverflowApi stackoverflowApi) {
    this.mStackoverflowApi = stackoverflowApi;
  }

  public void fetchLastActiveQuestionsAndNotify(int pages) {
    cancelCurrentFetchIfActive();
    mCall = mStackoverflowApi.lastActiveQuestions(pages);
    mCall.enqueue(this);
  }

  private void cancelCurrentFetchIfActive() {
    if (mCall != null && !mCall.isCanceled() && !mCall.isExecuted()) {
      mCall.cancel();
    }
  }

  @Override
  public void onResponse(Call<QuestionsListResponseSchema> call, Response<QuestionsListResponseSchema> response) {
    QuestionsListResponseSchema responseSchema;
    if (response.isSuccessful() && (responseSchema = response.body()) != null) {
      for (FetchQuestionListListener fetchQuestionListListener : getListeners()) {
        fetchQuestionListListener.onSuccess(responseSchema.getQuestions());
      }
    } else {
      onFailure(call, null);
    }
  }

  @Override
  public void onFailure(Call<QuestionsListResponseSchema> call, Throwable t) {
    for (FetchQuestionListListener fetchQuestionListListener : getListeners()) {
      fetchQuestionListListener.onFailure();
    }
  }

}
