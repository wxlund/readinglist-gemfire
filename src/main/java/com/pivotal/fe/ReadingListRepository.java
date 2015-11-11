package com.pivotal.fe;

import java.util.Collection;

import org.springframework.data.gemfire.mapping.Region;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Region("ReadingList")
public interface ReadingListRepository extends CrudRepository<Book, String> {

	@Query("SELECT * FROM /ReadingList b WHERE b.reader = $1")
	Collection<Book> findByReader(String reader);

}