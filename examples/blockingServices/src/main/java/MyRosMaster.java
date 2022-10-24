import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import embedded.mas.bridges.ros.ServiceParameters;
import embedded.mas.bridges.ros.RosMaster;
	
import jason.asSemantics.Unifier;
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
	public boolean execEmbeddedAction(String actionName, Object[] args, Unifier un) {		
		if(actionName.equals("move_turtle")){ //handling the action "move_turtle"		
		   
		   /* building the parameters of the service request.
		      "p" is a set of parameters (empty when created). 
		      New parameters are added to the set through the method addParameter.
		   */
		   ServiceParameters p = new ServiceParameters(); 
		   p.addParameter("linear", Float.parseFloat(args[0].toString()));  //add a parameter to "p". The parameter name is "linear" and its value is the 1st in the array "args"
		   p.addParameter("angular", Float.parseFloat(args[1].toString())); //add a parameter to "p". The parameter name is "angular" and its value is the 2nd in the array "args"
		   
		   /* Forcing to sleep to simulate the delay of the reply */
		   try {
                      Thread.sleep(1000);                
                   }catch (Exception e) {            
                     System.out.println(e);
                   }
                   
		   
		   /* Request the service in the blocking mode: the excution waits the reply from the ros server.
		      The reply informs whether the request has been successful. If it is not the case, the internal action fails.
		   */
		   return blockingServiceRequest("/turtle1/teleport_relative",p);
		}
		return false;
	}
	
}
