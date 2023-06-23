package com.tecazuay.api.models;

public class Language {

    private String textToDetect;
    private Boolean Successful;
    private String DetectedLanguage_ThreeLetterCode;
    private String DetectedLanguage_FullName;

    public String getTextToDetect() {
        return textToDetect;
    }

    public void setTextToDetect(String textToDetect) {
        this.textToDetect = textToDetect;
    }

    public Boolean getSuccessful() {
        return Successful;
    }

    public void setSuccessful(Boolean successful) {
        Successful = successful;
    }

    public String getDetectedLanguage_ThreeLetterCode() {
        return DetectedLanguage_ThreeLetterCode;
    }

    public void setDetectedLanguage_ThreeLetterCode(String detectedLanguage_ThreeLetterCode) {
        DetectedLanguage_ThreeLetterCode = detectedLanguage_ThreeLetterCode;
    }

    public String getDetectedLanguage_FullName() {
        return DetectedLanguage_FullName;
    }

    public void setDetectedLanguage_FullName(String detectedLanguage_FullName) {
        DetectedLanguage_FullName = detectedLanguage_FullName;
    }
}
