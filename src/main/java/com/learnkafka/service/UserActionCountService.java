package com.learnkafka.service;

import com.google.common.collect.Lists;
import com.learnkafka.elasticdomain.UserAction;
import com.learnkafka.repository.UserActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
@Service
public class UserActionCountService {

    private final UserActionRepository userActionRepository;

    public void save(UserAction action) {
        userActionRepository.save(action);
    }

    public List<UserAction> findAll() {
        return Lists.newArrayList(userActionRepository.findAll());
        // Iterator to List
        // compile group: 'com.google.guava', name: 'guava', version: '25.1-jre'
    }

    public UserAction findByActionType(String actionType) {
        return userActionRepository.findByActionType(actionType);
    }
}
