package io.pivotal.spring.gemfire.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

@Region("ReadingList")
public class Book {
	@Id
	private String isbn;
	private String reader;
	private String title;
	private String author;
	private String description;

	public Book() {
		super();
		this.isbn =  UUID.randomUUID().toString(); 
	}
    @PersistenceConstructor
    public Book(String isbn, String reader, String title, String author, String description) {
    	if (isbn == null) {
    		this.isbn =  UUID.randomUUID().toString(); 
    	}
        this.reader = reader;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return reader + " is reading" + title + " by." + author;
    }	
    
	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}