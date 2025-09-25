package com.github.leeyazhou.manus4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class DummyProvider implements AIProvider {
    @Override
    public AIResponse handle(AIRequest request) {
        return new AIResponse(true, "Hello, " + request.getParams().getOrDefault("name", "World"), getName(), null);
    }
    @Override
    public String getName() {
        return "dummy";
    }
}

public class DefaultManusEngineTest {
    private DefaultManusEngine engine;

    @BeforeEach
    public void setUp() {
        engine = new DefaultManusEngine();
        engine.registerProvider("dummy", new DummyProvider());
        engine.setDefaultProvider("dummy");
    }

    @Test
    public void testExecute() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", "manus4j");
        AIRequest request = new AIRequest("greet", params);
        AIResponse response = engine.execute(request);
        Assertions.assertTrue(response.isSuccess());
        Assertions.assertEquals("Hello, manus4j", response.getResult());
        Assertions.assertEquals("dummy", response.getProvider());
    }

    @Test
    public void testNoProvider() {
        DefaultManusEngine emptyEngine = new DefaultManusEngine();
        AIRequest request = new AIRequest("greet", new HashMap<>());
        Assertions.assertThrows(IllegalStateException.class, () -> emptyEngine.execute(request));
    }
}
