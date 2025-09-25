package com.github.leeyazhou.manus4j;

/**
 * AIProvider
 * @author leeyazhou
 */
public interface AIProvider {
    AIResponse handle(AIRequest request);
    String getName();
}
