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

	@Override
	public boolean execEmbeddedAction(String actionName, Object[] args) {
		this.microcontroller.write(actionName);
		return true;
	}
	
}
