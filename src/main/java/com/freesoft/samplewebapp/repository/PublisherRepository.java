package com.freesoft.samplewebapp.repository;

import com.freesoft.samplewebapp.entity.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
