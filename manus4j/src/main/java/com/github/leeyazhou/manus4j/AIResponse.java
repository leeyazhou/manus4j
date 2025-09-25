package com.github.leeyazhou.manus4j;

/**
 * AIResponse
 * @author leeyazhou
 */
public class AIResponse {
    private boolean success;
    private String result;
    private String provider;
    private String errorMsg;

    public AIResponse() {}

    public AIResponse(boolean success, String result, String provider, String errorMsg) {
        this.success = success;
        this.result = result;
        this.provider = provider;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
