package com.stunningcoders.puredependencyinjection.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by JS on 8/16/19.
 */

public interface StackoverflowApi {

    @GET("questions?order=desc&sort=activity&site=stackoverflow")
    Call<QuestionsListResponseSchema> lastActiveQuestions(@Query("pagesize") Integer pageSize);

    @GET("questions/{questionId}?site=stackoverflow&filter=withbody")
    Call<SingleQuestionResponseSchema> questionDetails(@Path("questionId") String questionId);

}
