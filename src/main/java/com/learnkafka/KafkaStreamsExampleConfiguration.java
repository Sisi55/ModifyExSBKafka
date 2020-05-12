package com.learnkafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsExampleConfiguration {

//    @Bean
//    public KStream<String, Long> kStream(StreamsBuilder streamsBuilder) {
//
//        KStream<String, Long> stream = streamsBuilder.stream("ubic-shop-test");
//        /*KStream<String, Long> output = */stream.peek((key,value) -> System.out.println("key="+key+",value="+value))
//                .groupBy((key, word) -> word)
//                .count(Materialized.as("counts-store"))
//                .toStream()
//                .to("ubic-stream-test-re")
//                ;
////        stream.map((k, v) -> new KeyValue<>(k, v.toUpperCase())).to("ks1Out",
////                Produced.with(Serdes.Integer(), new JsonSerde<>()));
//        return stream;
//    }
}
