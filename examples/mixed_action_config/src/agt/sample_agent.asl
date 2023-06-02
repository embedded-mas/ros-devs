//initial goals
!move.

//test service request without response
+!move: .random(X) & .random(Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [X,Y]);      
      .wait(500);
      !move.

//react to topic-based belief changes      
+turtle_position(x(X),y(Y),theta(T),linear_velocity(LV),angular_velocity(AV))
   <- .print("Position changed. x: ", X, "; y: ", Y, "; theta: ", T, "; linear velocity: ", LV, "; angular velocity: ", AV).  
      

//react to a topic-base belief change     
+value(V) 
   <- .print("Read value 1: ", V);
      .wait(100);
      embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","update_value", V+1 ).     

