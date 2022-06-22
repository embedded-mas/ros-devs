import embedded.mas.bridges.ros.RosMaster;
import embedded.mas.bridges.ros.DefaultRos4EmbeddedMas;
import embedded.mas.bridges.ros.ServiceParameters;
import embedded.mas.bridges.ros.ServiceParam;

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
		if(actionName.equals("teste")){ 
		   ServiceParam pSeq = new ServiceParam("seq", Integer.parseInt(args[0].toString())); //parameter "seq"
		   ServiceParam pSecs = new ServiceParam("secs",  Integer.parseInt(args[1].toString())); //parameter "secs"
		   ServiceParam pNSecs = new ServiceParam("nsecs",  Integer.parseInt(args[2].toString()));	//parameter "nsecs"	
				 
		   //the parameter stamp is composed of the nested set of parameters spStamp
   		   ServiceParameters spStamp = new ServiceParameters();
		   spStamp.add(pSecs);
		   spStamp.add(pNSecs);
		   ServiceParam pStamp = new ServiceParam("stamp", spStamp);  //parameter "stamp"
		
		   ServiceParam pFrame_id = new ServiceParam("frame_id",  args[3]); //parameter "frame_id"
		
		   //the parameter header is composed of the nested set of parameters spHeader
		   ServiceParameters spHeader = new ServiceParameters();
		   spHeader.add(pSeq);
		   spHeader.add(pStamp);
		   spHeader.add(pFrame_id);
		   ServiceParam pHeader = new ServiceParam("header", spHeader); //parameter "header"
		
		
		   ServiceParam pX = new ServiceParam("x", Float.parseFloat(args[4].toString())); //parameter "x"
		   ServiceParam pY = new ServiceParam("y", Float.parseFloat(args[5].toString())); //parameter "y"
		   ServiceParam pZ = new ServiceParam("z", Float.parseFloat(args[6].toString())); //parameter "z"
		
		
		   //the parameter position is composed of the nested set of parameters spPosition
		   ServiceParameters spPosition = new ServiceParameters();
		   spPosition.add(pX);
		   spPosition.add(pY);
		   spPosition.add(pZ);
		   ServiceParam pPosition = new ServiceParam("position", spPosition); //parameter "position"
		
		   ServiceParam pHeading = new ServiceParam("heading", Float.parseFloat(args[7].toString())); //parameter "heading"
		
		
		   //the parameter reference is composed of the nested set of parameters spReference
		   ServiceParameters spReference = new ServiceParameters();
		   spReference.add(pPosition);
		   spReference.add(pHeading);
		   ServiceParam pReference = new ServiceParam("reference", spReference); //parameter "reference";
		
		   //final set of parameters
		   ServiceParameters spFinal = new ServiceParameters();
		   spFinal.add(pHeader);
		   spFinal.add(pReference);

		   serviceRequest("/uav1/control_manager/reference",spFinal); 
		   return true;
		}
		return false;
	}
	
}
