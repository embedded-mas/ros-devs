import embedded.mas.bridges.jacamo.EmbeddedAgent;
import embedded.mas.bridges.jacamo.JSONDevice;
import embedded.mas.bridges.ros.Ros4EmbeddedMas;

import jason.asSyntax.Atom;

public class DemoEmbeddedAgentROS extends EmbeddedAgent {
	

	@Override
	public void initAg() {
		super.initAg();
	}

	@Override
	protected void setupSensors() {

		Ros4EmbeddedMas arduino = new Ros4EmbeddedMas();
		
		JSONDevice device = new JSONDevice(new Atom("Arduino1"), arduino);
		this.addSensor(device);
		
	}

}
