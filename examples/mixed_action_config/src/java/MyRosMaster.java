import embedded.mas.bridges.ros.IRosInterface;
import embedded.mas.bridges.ros.RosMaster;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;
import jason.asSemantics.Unifier;

public class MyRosMaster extends RosMaster{

    public MyRosMaster(Atom id, IRosInterface microcontroller) {
        super(id, microcontroller);
    }
    

    @Override
	public boolean execEmbeddedAction(String actionName, Object[] args, Unifier un) {		
		//execute the actions configured in the yaml file
        super.execEmbeddedAction(actionName, args, un);  // <- do not delete this line

		//Execute a customized actions 
          
		// The action "update_value" is realized through the writing in 2 topics */
		// Parameters of the method rosWrite:
		//     - topic name
		//     - topic type
		//     - value to be written in the topic
		if(actionName.equals("update_value")){		   
		   ((DefaultRos4EmbeddedMas) this.getMicrocontroller()).rosWrite("/value1","std_msgs/Int32",args[0].toString());
		   ((DefaultRos4EmbeddedMas) this.getMicrocontroller()).rosWrite("/value2","std_msgs/Int32",args[0].toString());
		   ((DefaultRos4EmbeddedMas) this.getMicrocontroller()).rosWrite("/value2","std_msgs/Int32",args[0].toString());
		}

		

		return true;
	}

}
