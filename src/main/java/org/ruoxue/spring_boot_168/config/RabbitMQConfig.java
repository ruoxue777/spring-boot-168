package org.ruoxue.spring_boot_168.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnsCallback;
import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

@EnableRabbit
@Configuration
@Slf4j
public class RabbitMQConfig {

	@Bean(name = "messageConverter")
	public MessageConverter messageConverter() {
		return new ContentTypeDelegatingMessageConverter(new Jackson2JsonMessageConverter());
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
			@Qualifier("messageConverter") MessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setConfirmCallback(confirmCallback());
		rabbitTemplate.setReturnsCallback(returnsCallback());
		return rabbitTemplate;
	}

	@Bean(name = "confirmCallback")
	public RabbitTemplate.ConfirmCallback confirmCallback() {
		RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
			@Override
			public void confirm(CorrelationData correlationData, boolean ack, String cause) {
				// do something
			}
		};
		return confirmCallback;
	}

	@Bean(name = "returnCallback")
	public ReturnsCallback returnsCallback() {
		ReturnsCallback returnCallback = new ReturnsCallback() {
			@Override
			public void returnedMessage(ReturnedMessage returned) {
				// do something
			}
		};
		return returnCallback;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
			@Qualifier("messageConverter") MessageConverter messageConverter) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(messageConverter);

		String podName = System.getProperty("pod.name");
		factory.setConsumerTagStrategy(q -> podName + "." + q);
		return factory;
	}

}
