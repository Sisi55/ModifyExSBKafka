package com.learnkafka.elasticdomain;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(indexName="product_summary3", type="_doc")
public class ProductSummary {

    @Field(analyzer = "standard", searchAnalyzer = "standard", type = FieldType.Text)
    private String name;

    @Field(analyzer = "standard", searchAnalyzer = "standard", type = FieldType.Text)
    private String desc;
}
