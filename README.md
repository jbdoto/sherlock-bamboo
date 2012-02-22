#The Sherlock Bamboo Messaging Plugin

##DESCRIPTION:
Out of the box, Sherlock will talk to a Rabbit MQ Instance, configured via the `spring-context.xml` file, located
at `src/main/resources/META-INF/spring`.

##INSTALLATION:
Download the Atlassian SDK, which will include their version of Maven, "atlas-mvn".

Adjust the `spring-context.xml` file to your needs.  You will most likely need to tweak the `host` property to something other than *localhost*.

Build your project with `atlas-mvn clean install`.

Install the built jar through Bamboo's web-based plugin management page.

##USAGE
Whenever a build completed event fires in Bamboo, the plugin will send a message to your configured queue. 

Do whatever you want with these enqueued messages.


##NOTES:
The external `sherlock.properties` config file is not yet active.
