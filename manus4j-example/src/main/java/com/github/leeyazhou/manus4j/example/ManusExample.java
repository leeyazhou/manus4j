package com.github.leeyazhou.manus4j.example;

import com.github.leeyazhou.manus4j.*;
import java.util.HashMap;
import java.util.Map;

public class ManusExample {
    public static void main(String[] args) {
        // 创建引擎
        DefaultManusEngine engine = new DefaultManusEngine();
        // 注册 provider
        engine.registerProvider("dummy", new DummyProvider());
        engine.setDefaultProvider("dummy");

        // 构造请求
        Map<String, Object> params = new HashMap<>();
        params.put("name", "manus4j user");
        AIRequest request = new AIRequest("greet", params);
        // 执行
        AIResponse response = engine.execute(request);
        System.out.println("Result: " + response.getResult());
    }

    // 示例 provider
    static class DummyProvider implements AIProvider {
        @Override
        public AIResponse handle(AIRequest request) {
            return new AIResponse(true, "Hello, " + request.getParams().getOrDefault("name", "World"), getName(), null);
        }
        @Override
        public String getName() {
            return "dummy";
        }
    }
}
