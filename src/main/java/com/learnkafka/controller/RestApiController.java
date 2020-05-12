package com.learnkafka.controller;

import com.learnkafka.elasticdomain.ProductSummary;
import com.learnkafka.elasticdomain.dto.ProductSummaryRequestDto;
import com.learnkafka.elasticdomain.dto.ProductSummaryResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestApiController {

    private final ElasticsearchRestTemplate template;

    Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @PostMapping("/products/new")
    public ProductSummaryResponseDto save(@RequestBody ProductSummaryRequestDto requestDto){

        // 인덱스 생성
//        template.createIndex(ProductSummary.class);

        // 엘라스틱 서치에 저장
        ProductSummary productSummary = ProductSummary.builder()
                .name(requestDto.getName())
                .desc(requestDto.getDesc())
                .build();

        // 문서 추가
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(productSummary.getName()) // _id
                .withObject(productSummary)
                .build();

        logger.info("\n" + template.index(indexQuery) + "\n");

        return new ProductSummaryResponseDto(requestDto);
    }

}
