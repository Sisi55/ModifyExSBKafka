package com.learnkafka.domain;

import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent,Integer> {
}
