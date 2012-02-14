package com.jeffdoto.sherlock.bamboo.messaging;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: jdoto200
 * Date: 2/13/12
 * Time: 10:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class RabbitMessager implements AmqpMessager{

    private MessagerConfig messagerConfig;
    private static final Logger logger = LoggerFactory.getLogger(RabbitMessager.class);
    private String name;

    @Override
    public String getExchangeName() {
        return messagerConfig.getExchangeName();
    }

    @Override
    public void sendMessage(String message) {
        Connection connection;
        try {
            connection = messagerConfig.getConnectionFactory().newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare(messagerConfig.getExchangeName(), "topic");
            channel.basicPublish(messagerConfig.getExchangeName(), messagerConfig.getCompletedTopicName(), null, message.getBytes());
        } catch (IOException e) {
            logger.error("Error encountered during send operation", e);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Required
    public void setMessagerConfig(MessagerConfig messagerConfig) {
        this.messagerConfig = messagerConfig;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }
}
