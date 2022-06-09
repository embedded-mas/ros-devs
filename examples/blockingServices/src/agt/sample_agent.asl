//initial belief
c(0).

//initial goal
!move. 
!count.



//plans
+!move: .random(X) & .random(Y)
   <- //move the turtle. This is a concurrent internal action: the intention is suspended while it is executed, with timeout of 5 seconds.
      embedded.mas.bridges.jacamo.concurrentEmbeddedInternalAction("roscore1","move_turtle", [X,Y,5000]);
      .wait(500);
      !move.
 
      
-!move      
   <- .print("Failed to move");
      .wait(100);
      !move.	


+!count: c(X)
   <- .print("counting ", X);
      -+c(X+1);
      .wait(100);      
      !count.
     
 

      
      
