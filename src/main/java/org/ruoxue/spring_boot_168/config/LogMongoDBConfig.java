package org.ruoxue.spring_boot_168.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.model.SnakeCaseFieldNamingStrategy;
import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientSettings.Builder;
import com.mongodb.client.MongoClient;

//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientOptions;
//import com.mongodb.MongoClientOptions.Builder;

import lombok.extern.slf4j.Slf4j;

//import com.mongodb.MongoClientURI;

@EnableMongoRepositories(mongoTemplateRef = "logMongoTemplate", //
		basePackages = { //
				"org.ruoxue.spring_boot_168.sso.login_account_log.repository, " //
		})
@Configuration
@Slf4j
public class LogMongoDBConfig {

	@Value("${spring.data.mongodb.log.custom.uri}")
	private String uri;

	@Value("${spring.data.mongodb.log.custom.connectionsPerHost}")
	private int connectionsPerHost;

	@Value("${spring.data.mongodb.log.custom.minConnectionsPerHost}")
	private int minConnectionsPerHost;

	@Value("${spring.data.mongodb.log.custom.retryWrites}")
	private boolean retryWrites;

	@Value("${spring.data.mongodb.log.custom.connectTimeout}")
	private int connectTimeout;

	@Value("${spring.data.mongodb.log.custom.socketTimeout}")
	private int socketTimeout;

	@Value("${spring.data.mongodb.log.custom.maxConnectionIdleTime}")
	private int maxConnectionIdleTime;

	@Value("${spring.data.mongodb.log.custom.maxConnectionLifeTime}")
	private int maxConnectionLifeTime;

	@Value("${spring.data.mongodb.log.custom.maxWaitTime}")
	private int maxWaitTime;

//	@Bean(name = "logMongoBuilder")
//	public Builder logMongoBuilder() {
//		Builder builder = MongoClientSettings.builder();
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
//	@Bean(name = "logMongoClientURI")
//	public MongoClientURI logMongoClientURI(@Qualifier("logMongoBuilder") Builder builder) {
//		MongoClientURI mongoClientURI = new MongoClientURI(this.uri, builder);
//		return mongoClientURI;
//	}
//
//	@Bean(name = "logMongoClient")
//	public MongoClient logMongoClient(@Qualifier("logMongoClientURI") MongoClientURI mongoClientURI) {
//		MongoClient mongoClient = new MongoClient(mongoClientURI);
//		return mongoClient;
//	}
//
//	@Bean(name = "logMongoDbFactory")
//	public MongoDatabaseFactory logMongoDbFactory(@Qualifier("logMongoClientURI") MongoClientURI mongoClientURI) {
//		return new SimpleMongoClientDatabaseFactory(mongoClientURI);
//	}
//
//	@Bean(name = "logMongoTemplate")
//	public MongoTemplate logMongoTemplate(@Qualifier("logMongoDbFactory") MongoDatabaseFactory mongoDbFactory) {
//		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
//		MongoMappingContext mongoMappingContext = new MongoMappingContext();
//		mongoMappingContext.setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy());
//		MongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, mongoConverter);
//		return mongoTemplate;
//
//	}
}
