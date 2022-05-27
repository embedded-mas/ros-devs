/**

**/

import java.util.Collection;

import embedded.mas.bridges.jacamo.JSONWatcherDevice;
import embedded.mas.bridges.jacamo.IPhysicalInterface;
import embedded.mas.bridges.jacamo.DefaultDevice;
import embedded.mas.bridges.jacamo.LiteralDevice;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MyRosMaster extends LiteralDevice {

	public MyRosMaster(Atom id, DefaultRos4EmbeddedMas microcontroller) {
		super(id, microcontroller);
	}

        /* Translate actions into ros topic publications and service requests.
           args:
             - for topic publications: 0. Topic name
                                       1. Topic type
                                       2. Topic value
                                        
             - for service requests: service arguments are the args elements. 
                                     They must be properly handled in the execEmbeddedAction function                                           
             
           obs: args are Strings. The action arguments are send to the ros as strings.
                Type conversions are handled in the "microcontroller" (DefaultRos4EmbeddedMas)       
        */
	@Override
	public boolean execEmbeddedAction(String actionName, Object[] args) {		
		if(actionName.equals("move_turtle")){ //handling the action "move_turtle"
		   try{
		    //build a JSON with the service parameters
		    JsonNode params = new ObjectMapper().readTree("{\"linear\":"+args[0]+", \"angular\":"+args[1]+"}");
		    //send the service request
		    ((DefaultRos4EmbeddedMas) microcontroller).serviceRequest("/turtle1/teleport_relative",params); 		   
		   } catch (JsonMappingException e) {
			e.printStackTrace();
		   } catch (JsonProcessingException e) {
			e.printStackTrace();
		   }
		}
		return true;
	}
	
}
