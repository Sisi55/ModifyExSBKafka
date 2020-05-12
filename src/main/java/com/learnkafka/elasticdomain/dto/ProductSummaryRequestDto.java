package com.learnkafka.elasticdomain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummaryRequestDto {

    private String name;
    private String desc;

}
