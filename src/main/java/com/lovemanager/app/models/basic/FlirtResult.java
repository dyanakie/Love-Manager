package com.lovemanager.app.models.basic;

public class FlirtResult {

    private String resultPicUrl;
    private String resultText;
    private boolean result;
    private String buttonUrl;
    private String link;
    private int yourStatLevel;
    private int girlStatLevel;

    public FlirtResult(String resultText, Boolean result){
        this.result = result;
        this.resultText = resultText;

        if(result){
            resultPicUrl = "pics/buttons/flirtSuccessful.png";
            buttonUrl = "pics/buttons/next";
            link = "/mainGameScreen";
        }else{
            resultPicUrl = "pics/buttons/flirtFails.png";
            buttonUrl = "pics/newGame";
            link = "/index2";
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

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
