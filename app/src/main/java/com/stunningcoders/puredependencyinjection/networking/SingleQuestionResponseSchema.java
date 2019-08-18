package com.stunningcoders.puredependencyinjection.networking;

import com.google.gson.annotations.SerializedName;
import com.stunningcoders.puredependencyinjection.questions.QuestionWithBody;

import java.util.Collections;
import java.util.List;


/**
 * Created by JS on 8/16/19.
 */

public class SingleQuestionResponseSchema {

    @SerializedName("items")
    private final List<QuestionWithBody> mQuestions;

    public SingleQuestionResponseSchema(QuestionWithBody question) {
        mQuestions = Collections.singletonList(question);
    }

    public QuestionWithBody getQuestion() {
        return mQuestions.get(0);
    }
}
