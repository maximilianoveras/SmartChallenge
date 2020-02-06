package main;

import java.util.HashMap;
import java.util.Map;

import flow.ActionException;
import flow.AdapterException;
import flow.AdapterNotFoundException;
import flow.AgentException;
import flow.AppException;
import flow.EmptyFlowException;
import flow.Engine;
import flow.EventException;
import flow.IAdapter;
import flow.ProtocolException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class MessageTest {

	TextApp textApp;	
	Engine engine;
	String response;
	
	@Given("A User sends an {string} message")
	public void a_User_sends_an_message(String message) throws AgentException, EmptyFlowException, AdapterNotFoundException, AdapterException, ActionException, EventException, ProtocolException, AppException {
	    Map<String, IAdapter> adapters = new HashMap();
	    adapters.put("TEXT", new TextAdapter());
	    engine = new Engine(new TextAgent(message), adapters, new TextApp());
	    engine.run();
	    
	    
	}

	@When("The message is converted by the Adapter")
	public void the_message_is_converted_by_the_Adapter() {
	    
		textApp = (TextApp) engine.getApp();
		response = textApp.popResponse(); 
	    
	}

	@Then("The Message server should contain the {string} message in the queue")
	public void the_Message_server_should_contain_the_message_in_the_queue(String message) {
		  
		 Assert.assertEquals(message, response);
				
	}
}
