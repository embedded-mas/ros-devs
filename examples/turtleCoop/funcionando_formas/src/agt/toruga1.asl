!move_quadrado.
	

+!move_quadrado:.random(X)
	<-
	.print("Vamos fazer um Quadrado!")
	.wait(X);
	!anda_quadrado1;
	!vira;
	!anda_quadrado1;
	!vira;
	!anda_quadrado;
	!vira;
	!anda_quadrado1;
	!para;
	!move_hexagono.

+!move_hexagono
	<-
	print("Vamos fazer um Hexagono!");
	!vira_hexagono1;
	!anda_hexagono;
	!vira_hexagono;
	!anda_hexagono;
	!vira_hexagono;
	!anda_hexagono;
	!para;
	!move_losango.
	
+!move_losango
	<-print("Vamos fazer um losango!");
	!anda_losango1;
	!vira_losango;
	!anda_losango;
	!vira_losango1;
	!anda_losango1;
	!para.
     
  +!para
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0,0]);  
      .wait(1000).   
     
 +!anda_quadrado1
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [2,0]);
      .wait(1000).
      
+!vira
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0,1.5707963]);
      .wait(1000).
      
      
      
+!anda_quadrado
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [4,0]);
      .wait(1000).                      
          
   +!anda_hexagono
	<- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [2,0]);
      .wait(1000).
      
+!vira_hexagono
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0,1.0471975512]);
      .wait(1000).      

+!vira_hexagono1
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0,0.5235987756]);
      .wait(1000).     
 
+!anda_losango      
 	<- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [4,0]);
      .wait(1000).
      
+!anda_losango1      
 	<- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [3.0792014357,0]);
      .wait(1000).
      

+!vira_losango     
 	<- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0, 2.0943951024]);
      .wait(1000).      
      
+!vira_losango1     
 	<- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [0, 1.0471975512]);
      .wait(1000).      
        

