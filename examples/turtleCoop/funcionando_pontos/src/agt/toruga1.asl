!move_quadrado.
	

+!move_quadrado
	<-
	.print("Vamos fazer um Quadrado!")
	!anda_quadrado1;
	!anda_quadrado2;
	!anda_quadrado3;
	!anda_quadrado4;
	!anda_quadrado5;
	!anda_quadrado6.
	


 +!anda_quadrado1
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [7.54445,5.544445,0]);
      .wait(1000).
 
 +!anda_quadrado2
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [7.54445,7.544445,0]);
      .wait(1000).
 
 +!anda_quadrado3
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [3.54445,7.544445,0]);
      .wait(1000).
 
 +!anda_quadrado4
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [3.54445,3.544445,0]);
      .wait(1000).
 
 +!anda_quadrado5
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [7.54445,3.544445,0]);
      .wait(1000).
 
 +!anda_quadrado6
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [7.54445,5.544445,0]);
      .wait(1000).     

