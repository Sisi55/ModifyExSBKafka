package com.learnkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.kafka.KafkaStreamsAnnotationDrivenConfiguration;

//@EnableKafka // 어떤 기능을 하는걸까 ? 없어도 작동했거든
@SpringBootApplication
public class LibraryEventsProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryEventsProducerApplication.class, args);


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
