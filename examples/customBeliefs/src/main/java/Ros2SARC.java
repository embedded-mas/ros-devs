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
   
   
   @Override
   public Literal customizeBelief(String topicName, JsonNode data) {
      if(topicName.equals("turtle1/pose")){
         // Belief creation: the first argument is the functor (i.e. the "name" of the belief) and the following are the belief argumentss
         // To disable this customization, comment the line below
         return createLiteral("position",createAtom(data.get("x").toString()),createAtom(data.get("y").toString()));
      }else
      
      /***** Tópicos relacionados à câmera - alterar para transformar em crença ******/
      
      if(topicName.equals("uavX/rgbd_down/aligned_depth_to_color/image_raw")){
         System.out.println(data.toString()); //print the json to be handled to extract the belief values
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
