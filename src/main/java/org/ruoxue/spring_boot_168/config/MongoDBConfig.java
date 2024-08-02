package org.ruoxue.spring_boot_168.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;
//import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientOptions;
//import com.mongodb.MongoClientOptions.Builder;
//import com.mongodb.MongoClientURI;

import lombok.extern.slf4j.Slf4j;

//@EnableMongoRepositories(mongoTemplateRef = "mongoTemplate", //
//		basePackages = { //
//				"org.ruoxue.spring_boot_168.chat.chat_message.repository, " //
//		})
//@Configuration
@Slf4j
public class MongoDBConfig {

	@Value("${spring.data.mongodb.custom.uri}")
	private String uri;

	@Value("${spring.data.mongodb.custom.connectionsPerHost}")
	private int connectionsPerHost;

	@Value("${spring.data.mongodb.custom.minConnectionsPerHost}")
	private int minConnectionsPerHost;

	@Value("${spring.data.mongodb.custom.retryWrites}")
	private boolean retryWrites;

	@Value("${spring.data.mongodb.custom.connectTimeout}")
	private int connectTimeout;

	@Value("${spring.data.mongodb.custom.socketTimeout}")
	private int socketTimeout;

	@Value("${spring.data.mongodb.custom.maxConnectionIdleTime}")
	private int maxConnectionIdleTime;

	@Value("${spring.data.mongodb.custom.maxConnectionLifeTime}")
	private int maxConnectionLifeTime;

	@Value("${spring.data.mongodb.custom.maxWaitTime}")
	private int maxWaitTime;

//	@Primary
//	@Bean(name = "mongoBuilder")
//	public Builder mongoBuilder() {
//		Builder builder = MongoClientOptions.builder();
//		builder.connectionsPerHost(this.connectionsPerHost);
//		builder.minConnectionsPerHost(this.minConnectionsPerHost);
//		builder.retryWrites(this.retryWrites);
//		builder.connectTimeout(this.connectTimeout);
//		builder.socketTimeout(this.socketTimeout);
//		builder.maxConnectionIdleTime(this.maxConnectionIdleTime);
//		builder.maxConnectionLifeTime(this.maxConnectionLifeTime);
//		builder.maxWaitTime(this.maxWaitTime);
//		log.info("uri: " + this.uri);
//		log.info("connectionsPerHost: " + this.connectionsPerHost);
//		return builder;
//	}
//
//	@Primary
//	@Bean(name = "mongoClientURI")
//	public MongoClientURI mongoClientURI(@Qualifier("mongoBuilder") Builder builder) {
//		MongoClientURI mongoClientURI = new MongoClientURI(this.uri, builder);
//		return mongoClientURI;
//	}
//
//	@Primary
//	@Bean(name = "mongoClient")
//	public MongoClient mongoClient(@Qualifier("mongoClientURI") MongoClientURI mongoClientURI) {
//		MongoClient mongoClient = new MongoClient(mongoClientURI);
//		return mongoClient;
//	}
//
//	@Primary
//	@Bean(name = "mongoDbFactory")
//	public MongoDbFactory mongoDbFactory(@Qualifier("mongoClientURI") MongoClientURI mongoClientURI) {
//		return new SimpleMongoDbFactory(mongoClientURI);
//	}
//
//	@Primary
//	@Bean(name = "mongoTemplate")
//	public MongoTemplate mongoTemplate(@Qualifier("mongoDbFactory") MongoDbFactory mongoDbFactory) {
//		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
//		MongoMappingContext mongoMappingContext = new MongoMappingContext();
//		mongoMappingContext.setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy());
//		MongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, mongoConverter);
//		return mongoTemplate;
//
//	}
}
