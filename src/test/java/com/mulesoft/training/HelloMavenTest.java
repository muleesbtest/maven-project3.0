package com.mulesoft.training;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

    @Test
    public void mavenFlowReturnsHelloMaven() throws Exception {
        runFlowAndExpect("mavenFlow", "Hello World");
    }
    
    @Test
    public void retrieveFlightsAddsAppropriateHeader() throws Exception {
      MuleEvent event = runFlow("mavenFlow");
      String contentType = event.getMessage().getOutboundProperty("Content-Type");
      assertEquals("text/plain", contentType);
      //assertEquals("text/xml", contentType);
    }

    
    @Override
    protected String getConfigFile() {
        return "02-maven-project.xml";
    }

}
