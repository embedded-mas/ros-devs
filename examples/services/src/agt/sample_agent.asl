!move. //initial goal

+!move: .random(X) & .random(Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("roscore1","move_turtle", [X,Y]);
      //embedded.mas.bridges.jacamo.concurrentEmbeddedInternalAction("roscore1","move_turtle", [X,Y]);
      .wait(500);
      !move.
      
      
+turtle1_pose(x(X),y(Y),theta(T),linear_velocity(LV),angular_velocity(AV))
   <- .print("Position changed. x: ", X, "; y: ", Y, "; theta: ", T, "; linear velocity: ", LV, "; angular velocity: ", AV).
      
     
 

      
      
