package com.lovemanager.app.models.basic;

public class FlirtResult {

    private String resultPicUrl;
    private String resultText;
    private boolean result;

    public FlirtResult(String resultText, Boolean result){
        this.result = result;
        this.resultText = resultText;

        if(result){
            resultPicUrl = "pics/buttons/flirtSuccessful.png";
        }else{
            resultPicUrl = "pics/buttons/flirtFails.png";
        }

    }

    public String getResultPicUrl() {
        return resultPicUrl;
    }

    public void setResultPicUrl(String resultPicUrl) {
        this.resultPicUrl = resultPicUrl;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
}
