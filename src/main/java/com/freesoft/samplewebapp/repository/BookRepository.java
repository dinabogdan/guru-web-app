package com.freesoft.samplewebapp.repository;

import com.freesoft.samplewebapp.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
