package com.stunningcoders.puredependencyinjection;

import android.support.annotation.UiThread;

import com.stunningcoders.puredependencyinjection.networking.FetchQuestionDetailHelper;
import com.stunningcoders.puredependencyinjection.networking.FetchQuestionListNetworkHelper;
import com.stunningcoders.puredependencyinjection.networking.StackoverflowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JS on 8/18/19.
 */
public class ApplicationComponent {

  private Retrofit retrofit;
  private StackoverflowApi stackoverflowApi;



  @UiThread
  private Retrofit getRetrofit(){
    if(retrofit == null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(Constants.BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }

  @UiThread
  private StackoverflowApi getStackoverflowApi(){
    if(stackoverflowApi == null){
      stackoverflowApi = getRetrofit().create(StackoverflowApi.class);
    }
    return stackoverflowApi;
  }

  @UiThread
  public FetchQuestionListNetworkHelper getFetchQuestionListNetworkHelper(){
    return new FetchQuestionListNetworkHelper(getStackoverflowApi());
  }

  @UiThread
  public FetchQuestionDetailHelper getFetchQuestionDetailNetworkHelper(){
    return new FetchQuestionDetailHelper(getStackoverflowApi());
  }
}
