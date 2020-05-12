package com.learnkafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnkafka.domain.KafkaProducerRequestDto;
import com.learnkafka.elasticdomain.UserAction;
import com.learnkafka.service.UserActionCountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@RequiredArgsConstructor
@Component
@Slf4j
public class LibraryEventsConsumer {

//    DefaultKafkaConsumerFactory

//    @Autowired
//    private final LibraryEventsService libraryEventsService;

    Logger logger = LoggerFactory.getLogger(LibraryEventsConsumer.class);

    //    @Autowired
    private final ObjectMapper objectMapper;

    private final UserActionCountService userActionCountService;
//    @Autowired
//    private ElasticsearchConverter elasticsearchConverter;

//    @KafkaListener(topics = {"library-events"})
//    public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {
//
//        log.info("ConsumerRecord : {} ", consumerRecord );
//        libraryEventsService.processLibraryEvent(consumerRecord);
//    }

    @KafkaListener(topics = {"ubic-shop-test"}, containerFactory = "defaultKafkaListenerContainerFactory")
    public void onUserAction(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

        log.info("ubic-shop-test :: ConsumerRecord : {} ", consumerRecord.value());
        KafkaProducerRequestDto received = objectMapper.readValue(consumerRecord.value(), KafkaProducerRequestDto.class);
//        log.info("ubic-shop-test :: ObjectMapper : {} ", received );
    }

    //    String[] charSet = {"utf-8","euc-kr","ksc5601","iso-8859-1","x-windows-949"};

    private final ElasticsearchRestTemplate template; //  :: 얘가 하는 역할 ? ok


    @KafkaListener(topics = {"ubic-stream-test-re"}, containerFactory = "kafkaListenerContainerFactory")
    public void onUserActionListener(/*ConsumerRecords<String,Long>*/ConsumerRecord<String, Long> consumerRecord) throws JsonProcessingException {

        log.info("ubic-stream-test-re :: StreamsConsumerRecord : {}-{} ", consumerRecord.key(), consumerRecord.value());//value()/*.replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", "")*/);

        // 엘라스틱 서치에 저장
        UserAction userAction = UserAction.builder()
//                .id(consumerRecord.key())
                .actionType(consumerRecord.key())
                .count(consumerRecord.value())
                .build();

//        userActionCountService.save(userAction);
        // 인덱스 생성
        template.createIndex(UserAction.class);

        // 문서 추가
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(userAction.getActionType()) // _id
                .withObject(userAction)
                .build();
        logger.info("\n" + template.index(indexQuery) + "\n");

//        KafkaStreamsResponseDto received = objectMapper.readValue(consumerRecord.value(), KafkaStreamsResponseDto.class);
//        log.info("ubic-stream-test-re :: StreamsConsumerRecord : {} ", received/*consumerRecord.value()*/);

    }


}
