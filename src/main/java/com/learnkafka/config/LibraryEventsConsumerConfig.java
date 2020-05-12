package com.learnkafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.Map;

@EnableKafka
@Configuration
@Slf4j
public class LibraryEventsConsumerConfig {



//    @Autowired
//    LibraryEventsService libraryEventsService;

    @Autowired
    private KafkaProperties kafkaProperties;
//    @Autowired
//    private RestClientConfigurations.RestHighLevelClientConfiguration restHighLevelClientConfiguration;


//    @Autowired
//    private ElasticsearchDataConfiguration.RestClientConfiguration restClientConfiguration;

//    @Autowired
//    private RestClientConfigurations.RestHighLevelClientConfiguration restHighLevelClientConfiguration;


    @Bean
    public Map<String, Object> consumerConfigs() { // KafkaProperties 로 대체 가능하려나 ? 아냠
//     KafkaProperties 가져와서 Deserializer 재정의하면 될듯! default 가 String 이야!
//        Map<String,Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
//        props.put(ProducerConfig.ID, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");

        KafkaProperties.Consumer consumerProps = kafkaProperties.getConsumer();
        consumerProps.setKeyDeserializer(StringDeserializer.class);
        consumerProps.setValueDeserializer(LongDeserializer.class);

        return kafkaProperties.buildConsumerProperties(); // ? KafkaProperties to Map
    }

    @Bean
    public ConsumerFactory<String,Long/*String,String*/> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), new LongDeserializer()); // 여기에 key/value deserilaizer 추가하면 될듯!
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,Long>>/*ConcurrentKafkaListenerContainerFactory<String,Long>*/
    kafkaListenerContainerFactory(
            /*ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ConsumerFactory<String,Long> consumerFactory*/) {

        ConcurrentKafkaListenerContainerFactory<String,Long> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(1);
//        factory.setBatchListener(true); // test !!!!!!!!!!!!!!!!!!!!!!!! ok batch

//        configurer.configure(factory, consumerFactory);
//        factory.setConcurrency(1); // TODO
//       // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
//        factory.setErrorHandler(((thrownException, data) -> {
//            log.info("Exception in consumerConfig is {} and the record is {}", thrownException.getMessage(), data);
//            //persist
//        }));
//        factory.setRetryTemplate(retryTemplate());
//        factory.setRecoveryCallback((context -> {
//            if(context.getLastThrowable().getCause() instanceof RecoverableDataAccessException){
//                //invoke recovery logic
//                log.info("Inside the recoverable logic");
//               /* Arrays.asList(context.attributeNames())
//                        .forEach(attributeName -> {
//                            log.info("Attribute name is : {} ", attributeName);
//                            log.info("Attribute Value is : {} ", context.getAttribute(attributeName));
//                        });*/
//
//               ConsumerRecord<Object,Object> consumerRecord = (ConsumerRecord<Object,Object>) context.getAttribute("record");
//               libraryEventsService.handleRecovery(consumerRecord);
//            }else{
//                log.info("Inside the non recoverable logic");
//                throw new RuntimeException(context.getLastThrowable().getMessage());
//            }
//
//
//            return null;
//        }));
        return factory;
    }
//
//    private RetryTemplate retryTemplate() {
//
//        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
//        fixedBackOffPolicy.setBackOffPeriod(1000);
//        RetryTemplate retryTemplate = new RetryTemplate();
//        retryTemplate.setRetryPolicy(simpleRetryPolicy());
//        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
//        return  retryTemplate;
//    }
//
//    private RetryPolicy simpleRetryPolicy() {
//
//        /*SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
//        simpleRetryPolicy.setMaxAttempts(3);*/
//        Map<Class<? extends Throwable>, Boolean> exceptionsMap = new HashMap<>();
//        exceptionsMap.put(IllegalArgumentException.class, false);
//        exceptionsMap.put(RecoverableDataAccessException.class, true);
//        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy(3,exceptionsMap,true);
//        return simpleRetryPolicy;
//    }
}