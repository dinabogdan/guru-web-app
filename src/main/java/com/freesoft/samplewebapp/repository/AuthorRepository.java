package com.freesoft.samplewebapp.repository;

import com.freesoft.samplewebapp.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
