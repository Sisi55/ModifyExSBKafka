package com.learnkafka.elasticdomain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(indexName="user_action"/*, type="action_count"*/)
public class UserAction {

    @Id
    private String id; // data 채우면서 id 삽입하는 과정이 있으므로 멤버로 필요는 없을듯!

//    @Field(analyzer = "standard", searchAnalyzer = "standard")
    private String actionType;
    private Long count;

//    @Builder
//    public UserAction(String id, String actionType, Long count){
//        this.id = id;
//        this.actionType = actionType;
//        this.count = count;
//    }
}
