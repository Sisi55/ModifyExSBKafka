package com.learnkafka.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

//@Configuration
//@EnableElasticsearchRepositories/*(basePackages = "com.baeldung.spring.data.es.repository")*/
//@ComponentScan/*(basePackages = { "com.baeldung.spring.data.es.service" })*/
//@EnableElasticsearchRepositories // ?
@RequiredArgsConstructor
@Configuration
public class DefaultElasticsearchConfig /*extends AbstractElasticsearchConfiguration*/ {

//    @Autowired
//    RestClientBuilder builder;


    //    @Autowired
    private final RestHighLevelClient elasticsearchRestHighLevelClient;

    private final ElasticsearchRestTemplate template; // TODO :: 얘가 하는 역할 ?
    //    @Autowired
//    private ElasticsearchDataConfiguration.RestClientConfiguration restClientConfiguration;
//
//    private final ElasticsearchCustomConversions elasticsearchCustomConversions;

    // TODO
//    @Bean // 이렇게 하면 커스텀 conversion ?? 아닐텐데 아예 새로 정의될텐데.. 아니야 생성자 내부 로직에서 다 추가해줌!
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        return new ElasticsearchCustomConversions(
//                Arrays.asList(/*new AddressToMap(), new MapToAddress()*/));
//    }

//    XContentBuilder // JSON 구문 생성해준다

//    @Bean
//    RestClientBuilder builder() {
//        // TODO  :: @Value 로 대체해야 한다! 보안!!
//        String hostname = "https://sisishop-test-6538126880.ap-southeast-2.bonsaisearch.net:443"; // localhost or bonsai url
//        String username = "l6smulhiww"; // needed only for bonsai
//        String password = "kflud49otx"; // needed only for bonsai
//
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(username, password));
//
//        return RestClient.builder(
//                new HttpHost(hostname, 443, "https"))
//                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//                    @Override
//                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    }
//                });
//    }
//
////    @Override
//    public RestHighLevelClient elasticsearchClient() {
//        return elasticsearchClient(null);
//    }
//
//    @Override
//    public RestHighLevelClient elasticsearchClient(/*RestClientBuilder builder*/) {
//        return new RestHighLevelClient(builder);//RestClients.create(ClientConfiguration.localhost()).rest();
//    }
////
////    // 블로그
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate((Client)elasticsearchClient());
//    }
////
////    // no special bean creation needed
////    // use the ElasticsearchEntityMapper
//    @Bean
////    @Override
//    public EntityMapper entityMapper() {
//        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(
//                elasticsearchMappingContext(),
//                new DefaultConversionService());
//        entityMapper.setConversions(elasticsearchCustomConversions()); // 하나만 등록 가능?
//        // entityMapper 를 어디서 사용하는지 알면 @Qulifier 인지 뭔지로 지정 가능할텐데
//        // 아니면 이 함수에 여러 개를 지정할 수 있는건가 ?
//
//        return entityMapper;
//    }
////
//    @Bean
////    @Override
//    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
//        return new ElasticsearchCustomConversions(
//                Arrays.asList(new AddressToMap(), new MapToAddress()));
//    }
////
////
//    @WritingConverter
//    static class AddressToMap implements Converter<UserAction/*Address*/, Map<String, Object>> {
//
//        @Override
//        public Map<String, Object> convert(UserAction/*Address*/ source) {
//
//            LinkedHashMap<String, Object> target = new LinkedHashMap<>();
//            target.put("_id", source.getId());
//            target.put("actionType", source.getActionType());
//            target.put("count", source.getCount());
//            // ...
//
//            return target;
//        }
//    }
////
//    @ReadingConverter
//    static class MapToAddress implements Converter<Map<String, Object>, UserAction> {
//
//        @Override
//        public UserAction convert(Map<String, Object> source) {
//
//            // ...
//
//            return UserAction.builder()
//                    .id(source.get("_id").toString())
//                    .actionType(source.get("actionType").toString())
//                    .count(Long.parseLong(source.get("count").toString()))
//                    .build();
//        }
//    }
}

/*{ // 이거 말고 .yml 로 정의하는 방법 ..?

//    @Qualifier("client") // ?
    @Autowired
    RestHighLevelClient highLevelClient;



//    @Qualifier("client")
//    @Bean
//    RestHighLevelClient client() {
//
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("localhost:9200", "localhost:9201")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
}*/
