package com.jeffdoto.sherlock.bamboo.messaging;

/**
 * Created by IntelliJ IDEA.
 * User: jdoto200
 * Date: 2/13/12
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Messager {
    void sendMessage(String message);
    String getName();
}
