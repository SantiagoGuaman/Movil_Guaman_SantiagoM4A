package com.tecazuay.api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tecazuay.api.io.SentimentApiAdapter;
import com.tecazuay.api.models.Sentiment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sentiment_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentiment);
        Button btn_sentiment = findViewById(R.id.btn_sentiment_analysis);
        Button btn_back = findViewById(R.id.btn_go_back);

        btn_back.setOnClickListener(l -> GoBack());
        btn_sentiment.setOnClickListener(l -> AnalyzeSentiment());
    }

    public void AnalyzeSentiment() {
        EditText editText = findViewById(R.id.txt_sentiment);

        String textToAnalyze = String.valueOf(editText.getText()).trim();

        Call<Sentiment> call = SentimentApiAdapter.getSentimentService().SENTIMENT_CALL(textToAnalyze);

        call.enqueue(new Callback<Sentiment>() {
            @Override
            public void onResponse(@NonNull Call<Sentiment> call, Response<Sentiment> response) {

                if(response.isSuccessful() && response.body() != null) {
                    editText.getText().clear();
                    String result = response.body().getSentimentClassificationResult();

                    TextView textView = findViewById(R.id.textView_analysis_sent);
                    textView.setText("This Sentiment is: " + result);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Sentiment> call, Throwable t) {
                Toast.makeText(Sentiment_Activity.this,"Error, I can't analyze this, Sorry :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GoBack() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}