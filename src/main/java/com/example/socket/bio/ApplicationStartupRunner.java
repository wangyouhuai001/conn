package com.example.socket.bio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ApplicationStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
       while (true){
           TimeUnit.SECONDS.sleep(1);
           Random random=new Random();
           String merchantId=String.valueOf(random.nextInt(10));
           if (PushMessageWebScoketServer.webSocketClientMap.containsKey(merchantId)){
                PushMessageWebScoketServer.sendMessage(merchantId,"这是给商户id为:"+merchantId+"推送的订单消息");
           }
           //log.info("当前的商户id为:"+merchantId);
       }
    }
}