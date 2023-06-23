
/* The plans below illustrate the reading of integer values and the writing to ros topics */
+value1(0) 
   <- .print("Li que o tópico está em 0");
      embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","update_value1",1 );
      .print("Transformei em 1").
      
+value1(1)
   <- .print("Li que o tópico está em 1");
      embedded.mas.bridges.jacamo.defaultEmbeddedInternalAction("sample_roscore","update_value1",0 );
      .print("Transformei em 0").
     
      
