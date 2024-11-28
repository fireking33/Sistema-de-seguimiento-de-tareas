
SISTEMA DE SEGUIMIENTO DE TAREAS
Paquetes
    * com.leo.asignador_de_tareas
         Clases y descripcion
         --Asignador_de_tareas: Clase principal para iniciar la aplicación.
             Nested Classes
                 Modifier and Type	          Class	                                        Description
                   static class 	Asignador_de_tareas.Tarea	        Clase que representa una tarea con su información básica.
                   static class 	Asignador_de_tareas.TareaManager	Clase encargada de gestionar las operaciones relacionadas con las tareas.
                   static class 	Asignador_de_tareas.User	        Clase que representa un usuario con su información básica.
                   static class 	Asignador_de_tareas.UserManager	        Clase encargada de gestionar las operaciones relacionadas con los usuarios.
             Methods
             Modifier and Type	            Method	                 Description
                 static void	     main​(String[] args)	Método principal que inicia la aplicación.
         --Asignador_de_tareas.Tarea: Clase que representa una tarea con su información básica.
             Modifier and Type	               Method	                 Description
        String	                          getDescripcion()	Obtiene la descripción de la tarea.
        String	                          getEstado()	        Obtiene el estado de la tarea.
        String	                          getNombre()	        Obtiene el nombre de la tarea.
        String	                          getPrioridad()	Obtiene la prioridad de la tarea.
        String	                          getUsuario()	        Obtiene el usuario asignado a la tarea.
         --Asignador_de_tareas.TareaManager: Clase encargada de gestionar las operaciones relacionadas con las tareas.
            Modifier and Type	                   Method	                                                                                         Description
        void	                                  guardarTareasEnArchivo​(String archivo, List<Asignador_de_tareas.Tarea> tareas)	Guarda una lista de tareas en un archivo de texto.
        List<Asignador_de_tareas.Tarea>	          leerTareasDesdeArchivo​(String archivo)	                                        Lee una lista de tareas desde un archivo de texto.
         --Asignador_de_tareas.User: Clase que representa un usuario con su información básica.
         
            Modifier and Type	                   Method	                                                            Description
        String	                                 getCorreo()	                                             Obtiene el correo electrónico del usuario.
        String	                                getUsuario()	                                             Obtiene el nombre del usuario.
         --Asignador_de_tareas.UserManager: Clase encargada de gestionar las operaciones relacionadas con los usuarios.
            Modifier and Type	                   Method	                                                                                        Description
        static void	                      escribirUsuariosEnArchivo​(String archivo, List<Asignador_de_tareas.User> usuarios)	Escribe una lista de usuarios en un archivo de texto.
        List<Asignador_de_tareas.User>	      leerUsuariosDesdeArchivo​(String archivo)	                                                Lee una lista de usuarios desde un archivo de texto.

    * interfaz	 
        Clases y descripcion
        --editar_tarea: Clase que representa la interfaz gráfica para editar una tarea.
                Constructor	                                                             Description
               editar_tarea()	                                                     Constructor predeterminado.
               editar_tarea​(Asignador_de_tareas.Tarea tareaSeleccionada)	     Constructor que recibe una tarea seleccionada.
               
               Modifier and Type	Method	                                             Description
                static void	         main​(String[] args)	                     Método principal para ejecutar la ventana de edición de tareas.
        --editar_user: Clase editar_user que representa una interfaz gráfica para editar los datos de un usuario.
                Constructor	                                                                Description
               editar_user()	                                                                Constructor predeterminado que inicializa la interfaz gráfica.
               editar_user​(Asignador_de_tareas.User usuarioSeleccionado, lista_user lista)	Constructor que inicializa la ventana con un usuario seleccionado.

               Modifier and Type	                  Method	                        Description
                  static void	                   main​(String[] args)	                        Método principal para ejecutar la aplicación.
        --login: Clase para la ventana de inicio de sesión.
                Constructor	                        Description
                  login()	                        Constructor de la clase login.
                  Modifier and Type	Method	                                            Description
                     static void	main​(String[] args)	                            Método principal para ejecutar la aplicación.
        --registro: Clase para la ventana de registro de usuarios.
                 Constructor	                        Description
                  registro()	                        Constructor de la clase registro.
                  Modifier and Type	Method	                            Description
                     static void	main​(String[] args)	            Método principal para ejecutar la ventana de registro.
        --VENTANA_PRINCIPAL: Esta clase representa la ventana principal de la aplicación.
        
    * ventanas
        Clases y descripcion
        --crear_tarea: Panel para la creación de tareas en la aplicación.
                Constructor	               Description
               crear_tarea()	               Constructor que inicializa los componentes de la interfaz gráfica y carga los usuarios disponibles en el filtro.
        --historial: Clase que representa un panel de historial de tareas.
                Constructor	Description
                historial()	Crea una nueva instancia del panel historial.
                Modifier and Type	Method	                   Description
                void	            mostrarHistorial()	           Muestra el historial de tareas leyendo el contenido del archivo "tareas.txt".

        --inicio: Clase que representa el panel de inicio en la aplicación.
                Constructor	Description
                   inicio()	Crea una nueva instancia del panel de inicio.

        --lista: Clase que representa una lista de tareas con funcionalidad de filtro, visualización y edición de tareas.
                Constructor	 Description
                  lista()	 Constructor de la clase lista.
                  Modifier and Type	        Method	                         Description
                        void	            aplicarFiltro()	                 Aplica los filtros seleccionados a la tabla de tareas.
                        void	       cargarTareasEnTabla​(String archivo)	 Carga las tareas desde un archivo y las muestra en la tabla.
                        void	     guardarTareasEnArchivo​(String archivo)	 Guarda la lista de tareas en un archivo especificado.
       --lista_user: Panel para gestionar la lista de usuarios.
                Constructor	           Description
               lista_user()	           Constructor de la clase.
               Modifier and Type	        Method	                        Description
                    void	            aplicarFiltro()	                Aplica el filtro seleccionado en el JComboBox a la tabla de usuarios.
                    void	cargarUsuariosEnTabla​(String archivo)	        Carga los usuarios desde un archivo y los muestra en la tabla.
