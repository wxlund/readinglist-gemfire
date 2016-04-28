package com.pivotal.fe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;

@SpringBootApplication
//@Configuration
@EnableGemfireRepositories
public class ReadinglistGemfireApplication {

	@Bean
	CacheFactoryBean gemfireCache() {
		return new CacheFactoryBean();
	}

	@Bean
	LocalRegionFactoryBean<String, Book> localRegionFactory(final GemFireCache cache) {
		return new LocalRegionFactoryBean<String, Book>() {{
			setCache(cache);
			setName("ReadingList");
		}};
	}
	
    public static void main(String[] args) {
        SpringApplication.run(ReadinglistGemfireApplication.class, args);
    }
    
    @Autowired
   ReadingListRepository readingListRepository;     
}
