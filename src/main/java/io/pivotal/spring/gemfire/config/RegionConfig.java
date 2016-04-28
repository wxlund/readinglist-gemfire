package io.pivotal.spring.gemfire.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.pivotal.fe.model.Book;

@Configuration
public class RegionConfig {

	@Autowired
	private Pool pool;

	private static final Logger LOG = LoggerFactory.getLogger(RegionConfig.class);

	@Bean(name = "Book")
	public Region<String, Book> createBookRegion(ClientCache cache) {
		LOG.info("creating Book Region");
		ClientRegionFactory<String, Book> crf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
		crf.setPoolName(pool.getName());
		Region<String, Book> r = crf.create("Book");
		return r;
	}

}