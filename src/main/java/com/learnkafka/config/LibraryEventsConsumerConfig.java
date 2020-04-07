package com.learnkafka.config;

import com.learnkafka.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
@Slf4j
public class LibraryEventsConsumerConfig {

    @Autowired
    LibraryEventsService libraryEventsService;

//    @Bean
//    public ConsumerFactory<Object,Object/*String,String*/> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }

//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String,Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
//        props.put(ProducerConfig.ID, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
//
//        return props;
//    }

//    @Bean
//    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(
//            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
//            ConsumerFactory<Object,Object> kafkaConsumerFactory) {
//
//        ConcurrentKafkaListenerContainerFactory<Object,Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        configurer.configure(factory, kafkaConsumerFactory);
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
//        return factory;
//    }
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