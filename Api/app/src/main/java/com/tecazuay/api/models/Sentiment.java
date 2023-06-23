package com.tecazuay.api.models;

public class Sentiment {

    private String TextToAnalyze;
    private Boolean Successful;
    private String SentimentClassificationResult;
    private Double SentimentScoreResult;
    private Integer SentenceCount;

    public String getTextToAnalyze() {
        return TextToAnalyze;
    }

    public void setTextToAnalyze(String textToAnalyze) {
        TextToAnalyze = textToAnalyze;
    }

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean successful) {
        Successful = successful;
    }

    public String getSentimentClassificationResult() {
        return SentimentClassificationResult;
    }

    public void setSentimentClassificationResult(String sentimentClassificationResult) {
        SentimentClassificationResult = sentimentClassificationResult;
    }

    public Double getSentimentScoreResult() {
        return SentimentScoreResult;
    }

    public void setSentimentScoreResult(Double sentimentScoreResult) {
        SentimentScoreResult = sentimentScoreResult;
    }

    public Integer getSentenceCount() {
        return SentenceCount;
    }

    public void setSentenceCount(Integer sentenceCount) {
        SentenceCount = sentenceCount;
    }
}
