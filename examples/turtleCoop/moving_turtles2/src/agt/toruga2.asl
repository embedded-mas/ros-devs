
+!pintar_quadrado_assist
	<-
	.print("Let's make a square!");
	!move(3.544445, 5.544445);
	!paint(0, 255, 0);
	.wait(1000);
	!move(3.544445, 3.544445);
	!move(7.544445, 3.544445);
	!move(7.544445, 5.544445).
	 
+!pintar_hexagono_assist
	<-
	.print("Let's make an hexagon!");
	!move(5.544445, 7.544445);
	!paint(255, 0, 0);
	.wait(1000);
	!move(7.142135, 6.928932);
	!move(7.142135, 4.160958);
	!move(5.544445, 3.544445).

+!pintar_estrela_assist
	<-
	.print("Let's make a star");
	!move(3.544445, 8.994211);
	!paint(255, 165, 0);
	.wait(1000);
	!move(5.519163, 7.505605);
	!move(7.494381, 8.994211);
	!move(7.038311, 6.448679);
	!move(8.506631, 5.029211);
	!move(6.461259, 4.821240).

+!move(X, Y)
   <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","move_turtle2", [X,Y,0]);
      .wait(1000).
    
+!paint(X, Y, Z)
      <- embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","pintar2", [X,Y,Z,2,off]);
      .wait(1000).     
