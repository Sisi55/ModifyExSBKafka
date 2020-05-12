package com.learnkafka.repository;

import com.learnkafka.elasticdomain.UserAction;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository/*("sisiShopRepository")*/
public interface UserActionRepository extends ElasticsearchRepository<UserAction, String> {
    UserAction findByActionType(String actionType);
}
