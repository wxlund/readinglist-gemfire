package com.pivotal.fe;

import java.util.Collection;

import org.springframework.context.annotation.Import;
import org.springframework.data.gemfire.repository.GemfireRepository;

public interface ReadingListRepository extends GemfireRepository<Book, String> {

	@Import("package com.pivotal.fe.Book")
	Collection<Book> findByReaderAnnotated(String reader);

}