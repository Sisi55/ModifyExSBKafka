package com.learnkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.learnkafka.domain.KafkaProducerRequestDto;
import com.learnkafka.producer.UbicUserActionProducer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LibraryEventsController {

    Logger logger = LoggerFactory.getLogger(LibraryEventsController.class);

//    @Autowired
//    LibraryEventProducer libraryEventProducer;

    @Autowired
    UbicUserActionProducer ubicUserActionProducer;

//    @PostMapping("/v1/libraryevent")
//    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent) throws JsonProcessingException, ExecutionException, InterruptedException {
//
//        //invoke kafka producer
//        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
//        libraryEventProducer.sendLibraryEvent_Approach2(libraryEvent);
//        return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
//    }

    @PostMapping("/v1/ubicshop")
    public ResponseEntity<KafkaProducerRequestDto> postUbicUserActionEvent(@RequestBody KafkaProducerRequestDto kafkaProducerRequestDto) throws JsonProcessingException{
        //invoke kafka producer
        logger.info("\ncontroller\n"+kafkaProducerRequestDto+"\n");
        ubicUserActionProducer.sendToKafka(kafkaProducerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(kafkaProducerRequestDto);
    }

//    //PUT
//    @PutMapping("/v1/libraryevent")
//    public ResponseEntity<?> putLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent) throws JsonProcessingException, ExecutionException, InterruptedException {
//
//
//        if(libraryEvent.getLibraryEventId()==null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass the LibraryEventId");
//        }
//
//        libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
//        libraryEventProducer.sendLibraryEvent_Approach2(libraryEvent);
//        return ResponseEntity.status(HttpStatus.OK).body(libraryEvent);
//    }
}
