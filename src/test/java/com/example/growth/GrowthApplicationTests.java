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


//    @Test
//    public void pushMessage(){
//        MulticastMessage message = MulticastMessage.builder()
//                .putData("message", "water!!")
//                .addToken("epv-fcTBLsk:APA91bHFV1ABmNnfTK4pROzrkgT9Lt3NfDlSCTjLC3UfHkwFab08iTAXt2_UwntSPjTBvbE-cX5pebhciA_shFytUsh3S-7HhMsNsR_B3MICkJmFN9m_41edcVJoPgBWJPCw9fuQYWy7")
//                .build();
//        try {
//            BatchResponse response = FirebaseMessaging.getInstance().sendMulticast(message);
//        } catch (FirebaseMessagingException e) {
//            e.printStackTrace();
//        }
//    }

}
