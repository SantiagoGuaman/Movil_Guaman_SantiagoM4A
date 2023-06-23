package com.tecazuay.api.io;

import com.tecazuay.api.models.Language;
import com.tecazuay.api.models.Sentiment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @FormUrlEncoded
    @POST("detect")
    Call<Language> DETECTION_CALL(
            @Field("textToDetect") String textDetect
    );

    @FormUrlEncoded
    @POST("sentiment")
    Call<Sentiment> SENTIMENT_CALL(
            @Field("TextToAnalyze") String textAnalyze
    );

}
