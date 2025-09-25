package com.github.leeyazhou.manus4j;

import java.util.HashMap;
import java.util.Map;

/**
 * DefaultManusEngine
 * @author leeyazhou
 */
public class DefaultManusEngine implements ManusEngine {
    private final Map<String, AIProvider> providers = new HashMap<>();
    private String defaultProvider;

    @Override
    public AIResponse execute(AIRequest request) {
        AIProvider provider = providers.getOrDefault(defaultProvider, null);
        if (provider == null) {
            throw new IllegalStateException("No provider registered");
        }
        return provider.handle(request);
    }

    @Override
    public void registerProvider(String name, AIProvider provider) {
        providers.put(name, provider);
    }

    @Override
    public void setDefaultProvider(String name) {
        this.defaultProvider = name;
    }
}
