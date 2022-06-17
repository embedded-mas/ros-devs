import embedded.mas.bridges.ros.RosMaster;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import embedded.mas.bridges.ros.ServiceParameters;

import jason.asSyntax.Atom;



public class MyRosMaster extends RosMaster {

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
		if(actionName.equals("teste")){ //handling the action "move_turtle"

		   ServiceParameters p = new ServiceParameters(); //p is the set of parameters of the requested service
		   p.addParameter("arrayOfFloatParameter", new Float[]{(Float)args[0], (Float)args[1]} ); //adding a new parameter which is an array of double		   
		   serviceRequest("/turtle1/teleport_relative",p); 
		   return true;
		}
		return false;
	}
	
}
