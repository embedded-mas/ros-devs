current_position(0,0,0).

!test.

+!test:current_position(CX,CY,CZ) 
    <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("roscore1","drop",[CX, CY, CZ]);
   .print("writing (",CX,",",CY,",",CZ,")");
   .wait(1000);   
   -+current_position(CX+1,CY+2,CZ+3); //update values 
   !test.


-!test <-
   .print("failed... trying again...");
   .wait(1000);
   !test.
