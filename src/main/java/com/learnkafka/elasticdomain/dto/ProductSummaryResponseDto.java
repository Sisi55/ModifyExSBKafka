package com.learnkafka.elasticdomain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummaryResponseDto {
    private String name;
    private String desc;

    public ProductSummaryResponseDto(ProductSummaryRequestDto requestDto) {
        this.name = requestDto.getName();
        this.desc = requestDto.getDesc();
    }
}
