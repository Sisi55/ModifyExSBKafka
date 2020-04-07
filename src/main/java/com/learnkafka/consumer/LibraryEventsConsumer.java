package com.learnkafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafka.domain.KafkaProducerRequestDto;
import com.learnkafka.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventsConsumer {

    @Autowired
    private LibraryEventsService libraryEventsService;

    @Autowired
    private ObjectMapper objectMapper;

//    @KafkaListener(topics = {"library-events"})
//    public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
//
//        log.info("ConsumerRecord : {} ", consumerRecord );
//        libraryEventsService.processLibraryEvent(consumerRecord);
//    }

    @KafkaListener(topics = {"ubic-shop-test"})
    public void onUserAction(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {

        log.info("ConsumerRecord : {} ", consumerRecord.value() );
        KafkaProducerRequestDto received = objectMapper.readValue(consumerRecord.value(),KafkaProducerRequestDto.class);
    }

    @KafkaListener(topics = {"ubic-stream-test"})
//    @StreamListener
//    @Kafka
    public void onUserActionListener(ConsumerRecord<?,?> consumerRecord) throws JsonProcessingException {

        log.info("StreamsConsumerRecord : {} ", consumerRecord.value() );
//        KafkaProducerRequestDto received = objectMapper.readValue(consumerRecord.value(),KafkaStreamsRequestDto.class);
    }


}
