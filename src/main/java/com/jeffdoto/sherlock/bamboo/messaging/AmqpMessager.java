package com.jeffdoto.sherlock.bamboo.messaging;

/**
 * AMQP Specific Messager Interface.
 * User: jdoto200
 * Date: 2/13/12
 * Time: 9:59 PM
 */
public interface AmqpMessager extends Messager {
    String getExchangeName();
    String getTopicName();
}
