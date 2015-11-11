package com.pivotal.fe;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.Region;

@Region("ReadingList")
public class Book {
	@Id
	private String id;
	private String reader;
	private String isbn;
	private String title;
	private String author;
	private String description;

    @PersistenceConstructor
    public Book(String id, String reader, String isbn, String title, String author, String description) {
        this.id = id;
        this.reader = reader;
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return reader + " is reading" + title + " by." + author;
    }	
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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