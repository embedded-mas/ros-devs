//initial belief
c(0).

//initial goal
!move. 
!count.



/*
  This plan uses a concurrent internal action. Thus, only the corresponding intention is suspended. 
  If the concurrentEmbeddedInternalAction is replaced by defaultEmbeddedInternalAction, all the agent thread is blocked until the action is completed.
*/
+!move: .random(X) & .random(Y)
   <- //move the turtle. This is a concurrent internal action: the intention is suspended while it is executed, with timeout of 5 seconds.
      embedded.mas.bridges.jacamo.concurrentEmbeddedInternalAction("roscore1","move_turtle", [X,Y]);
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
     
 

      
      
