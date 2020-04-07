package com.learnkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.kafka.KafkaStreamsAnnotationDrivenConfiguration;

//@EnableKafka // 어떤 기능을 하는걸까 ? 없어도 작동했거든
@SpringBootApplication
public class LibraryEventsProducerApplication {

//    @Autowired
//    Properties loadConfig;

//    @Bean
//    public static Properties loadConfig() throws IOException {
//        ClassPathResource resource = new ClassPathResource("kafka/java.config");
////        Path path = Paths.get(resource.getURI());
//
////        final String configFile = "";
//        if (!Files.exists(Paths.get(resource.getURI()))) {
//            throw new IOException(resource.getFilename() + " not found.");
//        }
//        final Properties cfg = new Properties();
////        Files.read
//        try (InputStream inputStream = resource.getInputStream()) {
//            cfg.load(inputStream);
//        }
//        return cfg;
//    }

//    @Autowired
//    private KafkaAdmin kafkaAdmin;

//    @Bean
//    public KafkaAdmin admin() {
//        Map<String, Object> configs = new HashMap<>();
//        /*loadConfig*/configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
//        /*loadConfig*/configs.put(AdminClientConfig.CLIENT_ID_CONFIG,"test-sisi");
//        return new KafkaAdmin(configs/*(Map) loadConfig*/);
//    }

//    @Bean
//    public ProducerFactory<String, String> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    @Bean
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        /*loadConfig*/props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-43n10.us-central1.gcp.confluent.cloud:9092");
//        /*loadConfig*/props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        /*loadConfig*/props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        // See https://kafka.apache.org/documentation/#producerconfigs for more properties
//        return props/*(Map)loadConfig*/;
//    }
//
//    @Bean
//    public KafkaTemplate<String, String> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }

    public static void main(String[] args) throws InterruptedException {
//        new PracStreams().testStreamsAPI();
        SpringApplication.run(LibraryEventsProducerApplication.class, args);
//        Thread.sleep(10*1000);
//        new PracStreams().testStreamsAPI();


//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//		System.out.println("빈찾기");
//
//		for (String beanName : beanNames) {
//
//			System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
//		}
    }

//	o.a.k.clients.admin.AdminClientConfig
//	o.a.k.clients.consumer.ConsumerConfig
//  o.a.k.clients.producer.ProducerConfig

//	@Bean
//	public KafkaTemplate<Integer, String> kafkaTemplate(ProducerConfig producerConfig) {
//		return new KafkaTemplate<>(new DefaultKafkaProducerFactory<Integer, String>(producerConfig));
//	}

}
