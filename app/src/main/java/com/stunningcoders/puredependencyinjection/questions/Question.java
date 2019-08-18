package com.stunningcoders.puredependencyinjection.questions;

import com.google.gson.annotations.SerializedName;


/**
 * Created by JS on 8/16/19.
 */

public class Question {

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("question_id")
    private final String mId;

    public Question(String title, String id) {
        mTitle = title;
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getId() {
        return mId;
    }
}
