package com.learnkafka;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
//import org.springframework.kafka.support.KafkaStreamsBrancher;

public class PracStreams {

//    @Autowired
//    private org.springframework.boot.autoconfigure.kafka.KafkaProperties KafkaProperties;

//    @Autowired
//    private ProducerFactory kafkaProducerFactory;

//    @Qualifier("kafkaTemplate")
//    @Autowired
//    private KafkaTemplate kafkaTemplate;


//    @Autowired
//    private KafkaStreamsConfiguration defaultKafkaStreamsConfig;

//    @Autowired
//    private KafkaStreamsAnnotationDrivenConfiguration.KafkaStreamsFactoryBeanConfigurer kafkaStreamsFactoryBeanConfigurer;

    @Bean // kafka-stream lib 추가했다 config 는 빈이 있어서 주입해주는구나
    public FactoryBean<StreamsBuilder> myKStreamBuilder(KafkaStreamsConfiguration streamsConfig) {
        return new StreamsBuilderFactoryBean(streamsConfig);
    }

    @Autowired // 이렇게 주입받는구나!!
    StreamsBuilder kStreamBuilder;

    //	@Autowired
//	private static ApplicationContext applicationContext;

    private void testStreamsAPI() {
        KStream<Integer, String> stream = kStreamBuilder.stream("");

    }

    private void streamBrancher() {
// TODO 왜 안될까
//        new KafkaStreamsBrancher<String, String>()
//                .branch((key, value) -> value.contains("A"), ks -> ks.to("A"))
//                .branch((key, value) -> value.contains("B"), ks -> ks.to("B"))
//                //default branch should not necessarily be defined in the end of the chain!
//                .defaultBranch(ks -> ks.to("C"))
//                .onTopOf(kStreamBuilder.stream("source"));
        //onTopOf method returns the provided stream so we can continue with method chaining
    }

}
