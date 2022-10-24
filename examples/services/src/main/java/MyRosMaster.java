

import embedded.mas.bridges.ros.RosMaster;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import embedded.mas.bridges.ros.ServiceParameters;

import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;



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
	public boolean execEmbeddedAction(String actionName, Object[] args, Unifier un) {		
		if(actionName.equals("move_turtle")){ //handling the action "move_turtle"
		   /* building the parameters of the service request.
		      "p" is a set of parameters (empty when created). 
		      New parameters are added to the set through the method addParameter.
		   */
		   ServiceParameters p = new ServiceParameters(); 
		   p.addParameter("linear", Float.parseFloat(args[0].toString()));  //add a parameter to "p". The parameter name is "linear" and its value is the 1st in the array "args"
		   p.addParameter("angular", Float.parseFloat(args[1].toString())); //add a parameter to "p". The parameter name is "angular" and its value is the 2nd in the array "args"
		   
		   /* Request the service. 
		      The first parameter of the method serviceRequest is the service name and the second is the set of parameters.
		      The method serviceRequest is nonblocking: the request is supposed to be successful and, thus, returns true.
		   */		  
		   serviceRequest("/turtle1/teleport_relative",p); 
		   return true;
		}else
		/**** Example of service with response ***/
		if(actionName.equals("get_loggers")){
			/* The second parameter is null because turtlesim/getloggers is a service that does not require any parameter. 
			 * Responses of service requests are stored in Literals.
			*/
			Literal response = serviceRequestResponse("/turtlesim/get_loggers", null);
			/* The response must be unified with a variable included in the arguments of the action action triggered by the agent 
			 * In this case, the only argument is the variable that must record the response.
			*/
			return un.unifies(response, (Term) args[0]);
		}
		return false;
	}
	
}
