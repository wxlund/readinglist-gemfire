package com.pivotal.fe;

import java.util.Collection;

import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.data.gemfire.repository.Query;

import com.pivotal.fe.model.Book;

public interface ReadingListRepository extends GemfireRepository<Book, String> {

	@Query("SELECT * FROM /ReadingList b WHERE b.reader = $1")
	Collection<Book> findByReader(String reader);

}