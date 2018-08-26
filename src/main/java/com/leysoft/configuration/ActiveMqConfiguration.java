
package com.leysoft.configuration;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class ActiveMqConfiguration {

    @Value(
            value = "${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value(
            value = "${spring.activemq.user}")
    private String username;

    @Value(
            value = "${spring.activemq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(username, password, brokerUrl);
    }

    @Bean
    public JmsTransactionManager jmsTransactionManager(ConnectionFactory connectionFactory) {
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
        jmsTransactionManager.setConnectionFactory(connectionFactory);
        return jmsTransactionManager;
    }

    @Bean
    public JmsComponent jmsComponent(ConnectionFactory connectionFactory,
            JmsTransactionManager transactionManager) {
        return JmsComponent.jmsComponentTransacted(connectionFactory, transactionManager);
    }
}
