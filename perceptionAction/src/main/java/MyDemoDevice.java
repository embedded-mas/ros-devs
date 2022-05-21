/**

**/

import java.util.Collection;

import embedded.mas.bridges.jacamo.JSONWatcherDevice;
import embedded.mas.bridges.jacamo.IPhysicalInterface;
import embedded.mas.bridges.jacamo.DefaultDevice;
import embedded.mas.bridges.ros.RosDevice;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;



public class MyDemoDevice extends RosDevice {

	public MyDemoDevice(Atom id, DefaultRos4EmbeddedMas microcontroller) {
		super(id, microcontroller);
	}

        /* Translate actions into ros topic publications 
           args: 0. Topic name
                 1. Topic type
                 2. Topic value
        */
	@Override
	public boolean execEmbeddedAction(String actionName, Object[] args) {
		if(actionName.equals("action1"))
		   ((DefaultRos4EmbeddedMas) microcontroller).rosWrite("/action1","std_msgs/String",(String) args[0]);		   
		return true;
	}
	
}
