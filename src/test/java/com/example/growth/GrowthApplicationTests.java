package com.example.growth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrowthApplicationTests {



    @Test
    public void contextLoads() {
    }

//    @Autowired
//    AndroidPushNotificationsService service;
//
//
//    @Test
//    public void pushMessage() throws JSONException, ExecutionException, InterruptedException {
//
//        JSONObject body = new JSONObject();
//        List<String> tokenlist = new ArrayList<>();
//
//        tokenlist.add();
//
//        JSONArray array = new JSONArray();
//
//        array.put(tokenlist.get(0));
//
//        body.put("registration_ids", array);
//
//        HttpEntity<String> request = new HttpEntity<>(body.toString());
//
//        CompletableFuture<String> push = service.send(request);
//        CompletableFuture.allOf(push).join();
//
//        System.out.println(push.get());
//
//    }

}
