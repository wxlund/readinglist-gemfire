package io.pivotal.spring.gemfire;

import java.util.Collection;

import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.pivotal.spring.gemfire.model.Book;

public interface ReadingListRepository extends CrudRepository<Book, String> {

	@Query("SELECT * FROM /ReadingList b WHERE b.reader = $1")
	Collection<Book> findByReader(String reader);

}