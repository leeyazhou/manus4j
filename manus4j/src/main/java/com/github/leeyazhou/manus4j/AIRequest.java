package com.github.leeyazhou.manus4j;

import java.util.Map;

/**
 * AIRequest
 * @author leeyazhou
 */
public class AIRequest {
    private String type;
    private Map<String, Object> params;

    public AIRequest(String type, Map<String, Object> params) {
        this.type = type;
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
