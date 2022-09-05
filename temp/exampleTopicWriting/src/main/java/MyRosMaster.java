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

import embedded.mas.bridges.ros.RosMaster;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import embedded.mas.bridges.ros.ServiceParameters;
import embedded.mas.bridges.ros.ServiceParam;

import jason.asSyntax.Atom;
import jason.asSyntax.Term;
import jason.asSyntax.ListTerm;
import static jason.asSyntax.ASSyntax.parseList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MyRosMaster extends RosMaster {

	public MyRosMaster(Atom id, DefaultRos4EmbeddedMas microcontroller) {
		super(id, microcontroller);
	}

	@Override
	public boolean execEmbeddedAction(String actionName, Object[] args) {
	
   	   if(actionName.equals("drop")){		   
	      ((DefaultRos4EmbeddedMas) microcontroller).rosWrite("/rescue_world/drop_buoy","geometry_msgs/Pose","{\"position\": {\"x\": "+args[0]+", \"y\": "+args[1]+", \"z\": "+args[2]+"},\"orientation\": {\"x\": 0.0, \"y\": 0.0, \"z\": 0.0, \"w\": 99.0}}");
		   return true;
	   }
	   return false;

	}
	
}
