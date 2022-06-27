
package topicReader;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;

import embedded.mas.bridges.ros.ros.RosListenDelegate;
import embedded.mas.bridges.ros.ros.RosBridge;

import jason.asSyntax.Literal;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;

import static jason.asSyntax.ASSyntax.parseLiteral;

public class App {
    
    public static void main(String[] args) {

        String topicName = "turtle1/pose";
        String topicType = "turtlesim/Pose";
    
        RosBridge bridge = new RosBridge();
	bridge.connect("ws://localhost:9090", true);
		


	RosListenDelegate listener = new RosListenDelegate() {
	   public void receive(JsonNode data, String stringRep) {
		System.out.println(topicName + ": " + data.get("msg"));
	   }
	};

	bridge.subscribe(topicName, topicType, listener, 1, 1);
    }
    
}
