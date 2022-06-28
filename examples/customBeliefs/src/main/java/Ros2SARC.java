import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import jason.asSyntax.Literal;
import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createAtom;

public class Ros2SARC extends DefaultRos4EmbeddedMas{

   public Ros2SARC(String connectionStr, ArrayList<String> topics, ArrayList<String> types){
      super(connectionStr,topics,types);
   }
   
   
   /**
    * Customizes beliefs when should not follow the default format translated from rostopics.
    * By default, returns null. In this case, the belief follows the default translation from the rostopic.
    * To return values other than null, override this method in subclasses. In this case, the method is supposed to build and return a literal representing
    * the belief corresponding to the topic. 
    * 
    * @param topicName: name of the topic to be converted to belief.
    * @param data: JSON containing the topic values. This JSON is produced by the rosbridge, which is an interface ROS-Java. To inspect this JSON, print the value of this parameter. 
    * @return null to follow the default conversion from topic value to belief; a literal representing the corresponding belief otherwise.
   */
   @Override
   protected Literal customizeBelief(String topicName, JsonNode data) {
      if(topicName.equals("turtle1/pose")){ 
         // System.out.println(data.toString()); //uncomment to inspect the JSON to be handled
         
         // The parameter data looks like {"x":0.1,"y":0.2,"theta":0.3,"linear_velocity":0.0,"angular_velocity":0.0}}. It is converted to position(0.1,0.2).
         // To disable this customization, comment the line below
         return createLiteral("position",createAtom(data.get("x").toString()),createAtom(data.get("y").toString()));
      }else
      
      
      /***** Tópicos relacionados à câmera - alterar para transformar em crença ******/      
      if(topicName.equals("uavX/rgbd_down/aligned_depth_to_color/image_raw")){
         System.out.println(topicName + ": " + data.toString()); //print the json to be handled to extract the belief values
         return null;
      }else
      if(topicName.equals("uavX/rgbd_down/aligned_depth_to_color/image_raw/compressed")){
         System.out.println(topicName + ": " + data.toString());
         return null;
      }else
      if(topicName.equals("uavX/rgbd_down/aligned_depth_to_color/image_raw/compressedDepth")){
         System.out.println(topicName + ": " + data.toString());
         return null;
      }else
      if(topicName.equals("uavX/rgbd_down/aligned_depth_to_color/image_raw/theora")){
         System.out.println(topicName + ": " + data.toString());
         return null;
      }
      
      return null;
   }

}
