
+!pintar_quadrado
	<-
	.print("Let's make a square!");
	!move(7.544445, 5.544445);
	!paint(0, 255, 0);
	!clear;
	!move(7.544445, 7.544445);
	!move(3.544445, 7.544445);
	!move(3.544445, 5.544445).
	 


+!pintar_hexagono
	<-
	.print("Let's make an hexagon!");
	!move(5.544445, 3.544445);
	!paint(255, 0, 0);
	!clear;
	!move(3.946754, 4.160958);
	!move(3.946754, 6.928932);
	!move(5.544445, 7.544445).

+!pintar_estrela
	<-
	.print("Let's make a star");
	!move(6.461259, 4.821240);
	!paint(255, 165, 0);
	!clear;
	!move(5.519163, 3.015276);
	!move(4.577067, 4.821240);
	!move(2.531694, 5.029211);
	!move(4.000041, 6.448679);
	!move(3.544445, 8.994211).

+!clear
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","clear", []);
      .wait(1000).
      
+!move(X, Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle", [X,Y,0]);
      .wait(1000).
    
+!paint(X, Y, Z)
      <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","pintar", [X,Y,Z,2,off]);
      .wait(1000).    
