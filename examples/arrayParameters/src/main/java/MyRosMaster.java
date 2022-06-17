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
		   /* building the parameters of the service request.
		      "p" is a set of parameters (empty when created). 
		      New parameters are added to the set through the method addParameter.
		   */
		   
		   ServiceParameters p = new ServiceParameters(); 
		   p.addParameter("arrayOfFloatParameter", new Double[]{1.99, 3.14} );  
		   p.addParameter("arrayOfStringParameter", new String[]{"a","b","c"}); 
		   
		   /* Request the service. 
		      The first parameter of the method serviceRequest is the service name and the second is the set of parameters.
		      The method serviceRequest is nonblocking: the request is supposed to be successful and, thus, returns true.
		   */		  
		   serviceRequest("/turtle1/teleport_relative",p); 
		   return true;
		}
		return false;
	}
	
}
