package com.tecazuay.api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tecazuay.api.io.LanguageApiAdapter;
import com.tecazuay.api.models.Language;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn_analyze_text);
        Button btn_try = findViewById(R.id.btn_try_another);
        btn.setOnClickListener(l -> AnalyzeThis());
        btn_try.setOnClickListener(l -> TrySentimentAnalysis());
    }

    public void AnalyzeThis() {
        EditText editText = findViewById(R.id.txt_detect_string);
        String textToAnalyze = String.valueOf(editText.getText()).trim();

        Call<Language> call = LanguageApiAdapter.getLanguageService().DETECTION_CALL(textToAnalyze);

        call.enqueue(new Callback<Language>() {
            @Override
            public void onResponse(Call<Language> call, Response<Language> response) {

                if (response.isSuccessful() && response.body() != null) {
                    editText.getText().clear();
                    String result = response.body().getDetectedLanguage_FullName();

                    TextView textView = findViewById(R.id.txtview_answer);
                    textView.setText("The language detected is: " + result);
                }
            }

            @Override
            public void onFailure(Call<Language> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error, I can't analyze this, Sorry :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void TrySentimentAnalysis() {
        Intent intent = new Intent(getApplicationContext(), Sentiment_Activity.class);
        startActivity(intent);
        finish();
    }
}