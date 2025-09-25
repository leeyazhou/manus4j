package com.github.leeyazhou.manus4j;

/**
 * ManusEngine
 * @author leeyazhou
 */
public interface ManusEngine {
    AIResponse execute(AIRequest request);
    void registerProvider(String name, AIProvider provider);
    void setDefaultProvider(String name);
}
