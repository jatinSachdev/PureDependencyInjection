package com.stunningcoders.puredependencyinjection.networking;

import com.stunningcoders.puredependencyinjection.abstraction.BaseObservable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by JS on 8/17/19.
 */
public class FetchQuestionDetailHelper extends BaseObservable<FetchQuestionDetailListener> implements Callback<SingleQuestionResponseSchema> {

  private StackoverflowApi mStackoverflowApi;

  private Call<SingleQuestionResponseSchema> mCall;

  public FetchQuestionDetailHelper(StackoverflowApi stackoverflowApi) {
    cancelCurrentFetchIfActive();
    mStackoverflowApi = stackoverflowApi;
  }

  private void cancelCurrentFetchIfActive() {
    if (mCall != null && !mCall.isCanceled() && !mCall.isExecuted()) {
      mCall.cancel();
    }
  }

  public void fetchQuestionDetailAndNotify(String mQuestionId) {
    mCall = mStackoverflowApi.questionDetails(mQuestionId);
    mCall.enqueue(this);
  }

  @Override
  public void onResponse(Call<SingleQuestionResponseSchema> call, Response<SingleQuestionResponseSchema> response) {
    SingleQuestionResponseSchema questionResponseSchema;
    if (response.isSuccessful() && (questionResponseSchema = response.body()) != null) {
      for (FetchQuestionDetailListener fetchQuestionDetailListener : getListeners()) {
        fetchQuestionDetailListener.onSuccess(questionResponseSchema.getQuestion());
      }
    } else {
      onFailure(call, null);
    }
  }

  @Override
  public void onFailure(Call<SingleQuestionResponseSchema> call, Throwable t) {
    for (FetchQuestionDetailListener fetchQuestionDetailListener : getListeners()) {
      fetchQuestionDetailListener.onFailure();
    }

  }
}
