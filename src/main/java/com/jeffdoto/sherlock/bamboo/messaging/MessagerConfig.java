package com.jeffdoto.sherlock.bamboo.messaging;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by IntelliJ IDEA.
 * User: jdoto200
 * Date: 2/13/12
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class MessagerConfig {

    private ConnectionFactory connectionFactory;
    private String exchangeName;
    private String completedTopicName;

    public ConnectionFactory getConnectionFactory() {
        return this.connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public void setCompletedTopicName(String completedTopicName) {
        this.completedTopicName = completedTopicName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getCompletedTopicName() {
        return completedTopicName;
    }
}
