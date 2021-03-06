package com.jeffdoto.sherlock.bamboo;

import com.atlassian.bamboo.event.BuildCompletedEvent;
import com.atlassian.bamboo.event.HibernateEventListener;
import com.atlassian.event.Event;
import com.jeffdoto.sherlock.bamboo.messaging.Messager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;

/**
 * Listens for Bamboo Build Lifecycle events.
 *
 * Sends a message to a configured messaging entity announcing the received event Plan Information, Build Number,
 * and State.
 * User: jdoto200
 * Date: 1/29/12
 * Time: 10:55 PM
 */
public class BuildStateListener implements HibernateEventListener {

    Logger logger = LoggerFactory.getLogger(BuildStateListener.class);
    private Messager messager;

    @Override
    public void handleEvent(Event event) {

        if (event instanceof BuildCompletedEvent) {
            logger.info(String.format("BuildCompletedEvent received.  Publishing message to %s", messager.getName()));
            messager.sendMessage(
                    String.format(((BuildCompletedEvent) event).getBuildPlanKey()
                            + " Build #" + ((BuildCompletedEvent) event).getBuildNumber()
                            + " completed with a result of " + ((BuildCompletedEvent) event).getBuildState()).toUpperCase());
        }
    }

    @Override
    public Class[] getHandledEventClasses() {

        return new Class[]{
                BuildCompletedEvent.class
        };
    }

    @Required
    public void setMessager(Messager messager) {
        this.messager = messager;
    }
}
