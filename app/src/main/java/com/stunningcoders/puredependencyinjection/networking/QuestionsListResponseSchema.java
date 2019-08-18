package com.stunningcoders.puredependencyinjection.networking;

import com.google.gson.annotations.SerializedName;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.List;


/**
 * Created by JS on 8/16/19.
 */

public class QuestionsListResponseSchema {

    @SerializedName("items")
    private final List<QuestionWithBody> mQuestions;

    public QuestionsListResponseSchema(List<QuestionWithBody> questions) {
        mQuestions = questions;
    }

    public List<QuestionWithBody> getQuestions() {
        return mQuestions;
    }
}
