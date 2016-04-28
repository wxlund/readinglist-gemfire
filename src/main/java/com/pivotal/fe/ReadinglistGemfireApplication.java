package com.pivotal.fe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.pivotal.fe.model.Book;


@SpringBootApplication
@EnableGemfireRepositories
public class ReadinglistGemfireApplication implements CommandLineRunner {
	@Autowired
	ReadingListRepository readingListRepository;
	
	@Override
	public void run(String... strings) throws Exception {
		Book craig = new Book("ISBN-1234", "craig", "Spring Boot in Action", "Craig Walls", "Best Book on Spring Boot");
		Book greg = new Book("ISBN-2345", "greg", "Learning Spring Boot", "Greg Turnquist", "First Book on Spring Boot");
		Book dan = new Book("ISBN-2345", "dan", "Spring Boot", "Dan Varga", "Udemy: Spring Boot");

		System.out.println("Before linking up with Gemfire...");
		for (Book Book : new Book[] { craig, greg, dan }) {
			System.out.println("\t" + Book);
		}

		readingListRepository.save(craig);
		readingListRepository.save(greg);
		readingListRepository.save(dan);

		System.out.println("Lookup each Book by name...");
		for (String reader : new String[] { craig.getReader(), greg.getReader(), dan.getReader() }) {
			System.out.println("\t" + readingListRepository.findByReader(reader));
		}

	}
	
   public static void main(String[] args) {
        SpringApplication.run(ReadinglistGemfireApplication.class, args);
    }
    

}
