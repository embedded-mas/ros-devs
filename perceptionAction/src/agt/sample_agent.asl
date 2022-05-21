+topic1(V) <- .print("Read topic 1: ", V).

+topic2(V) : .time(H,M,S) & .concat("current time: ", H, ":", M, ":", S, Msg)
   <- .print("Read topic 2: ", V);
      //execute "action1" upon "roscore1". Such action is translated to rostopic pub in MyDemoDevice class
      embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("roscore1","action1",[Msg] ).


