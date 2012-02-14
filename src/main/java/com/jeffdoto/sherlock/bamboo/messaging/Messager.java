package com.jeffdoto.sherlock.bamboo.messaging;

/**
 * A Generic Interface for Messager.  Sends a message and has a name.  Not too exciting.
 * User: jdoto200
 * Date: 2/13/12
 * Time: 10:37 PM
 */
public interface Messager {
    void sendMessage(String message);
    String getName();
}
