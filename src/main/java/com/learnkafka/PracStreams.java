package com.learnkafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.stereotype.Component;

//import java.util.logging.Logger;
//import org.springframework.kafka.support.KafkaStreamsBrancher;

@EnableKafkaStreams
@EnableKafka
@Component
public class PracStreams {


//    @Autowired
//    private KafkaAutoConfiguration kafkaAutoConfiguration; // 아닌듯
    @Autowired
    private KafkaStreamsConfiguration defaultKafkaStreamsConfig;

    private Logger logger = LoggerFactory.getLogger(PracStreams.class);

//    @Bean // kafka-stream lib 추가했다 config 는 빈이 있어서 주입해주는구나
//    public FactoryBean<StreamsBuilder> myKStreamBuilder(KafkaStreamsConfiguration streamsConfig) {
//        return new StreamsBuilderFactoryBean(streamsConfig);
//    }

//    @Autowired // 이렇게 주입받는구나!!
//    StreamsBuilder defaultKafkaStreamsBuilder//kStreamBuilder;

    @Bean
    public KStream<?, ?> kStream(StreamsBuilder kStreamBuilder) {
        logger.info("\n"+kStreamBuilder.toString()+"\n");
//        KStream<Integer, String> stream = kStreamBuilder.stream(STREAMING_TOPIC1);
        // Fluent KStream API
        KStream<Integer, String> stream = kStreamBuilder.stream("ubic-shop-test");
        // Todo 맞나 ??
        KTable<String, Long> wordCounts = stream
                .peek((key,value)->
                System.out.println("\nkey="+key+",value="+value+"\n"))
                .groupBy((key, word) -> word) // TODO username 으로 그룹화도 해야할걸
                .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store"));

        wordCounts.toStream().to("ubic-stream-test",
                Produced.with(Serdes.String(), Serdes.Long()));
//        defaultKafkaStreamsConfig.asProperties();

        logger.info("\n"+defaultKafkaStreamsConfig.asProperties()+"\n"); // ok

        KafkaStreams streams = new KafkaStreams(kStreamBuilder.build(),
                defaultKafkaStreamsConfig.asProperties());
//        streams.start();

        return stream;
    }

    //	@Autowired
//	private static ApplicationContext applicationContext;

//    public void testStreamsAPI() {
//        if(kStreamBuilder == null)
//            logger.info("\nbuilder is null\n");
//
//        KStream<Integer, String> stream = kStreamBuilder.stream("ubic-shop-test");
//        // Todo 맞나 ??
//        KTable<String, Long> wordCounts = stream.peek((key,value)->
//                    logger.info("\nkey="+key+",value="+value+"\n"))
//                .groupBy((key, word) -> word) // TODO username 으로 그룹화도 해야할걸
//                .count();
//
//        wordCounts.toStream().to("ubic-stream-test",
//                Produced.with(Serdes.String(), Serdes.Long()));
////        defaultKafkaStreamsConfig.asProperties();
//
//        KafkaStreams streams = new KafkaStreams(kStreamBuilder.build(),
//                defaultKafkaStreamsConfig.asProperties());
//        streams.start();
//    }

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
