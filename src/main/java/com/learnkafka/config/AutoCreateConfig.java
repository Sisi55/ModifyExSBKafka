package com.learnkafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class AutoCreateConfig {

//    @Bean
//    public NewTopic libraryEvents(){
//        return TopicBuilder.name("library-events")
//                .partitions(3)
//                .replicas(1)
//                .build();
//    }

//    @Bean
//    public NewTopic ubicShopTopic(){
//        return TopicBuilder.name("ubic-shop-test")
//                .partitions(3)
//                .replicas(3)
//                .build();
//    }

}
