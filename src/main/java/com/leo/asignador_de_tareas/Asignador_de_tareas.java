/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 * Clase principal de la aplicación Asignador de Tareas.
 * Esta clase contiene el punto de entrada de la aplicación y define las clases
 * auxiliares relacionadas con usuarios y tareas.
 * 
 * Funcionalidad:
 * - Gestión de usuarios y sus datos.
 * - Gestión de tareas asignadas a los usuarios.
 */
package com.leo.asignador_de_tareas;

import interfaz.login;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase principal para iniciar la aplicación.
 */
public class Asignador_de_tareas {
 /**
     * Método principal que inicia la aplicación.
     * Lanza la interfaz de login.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
          javax.swing.SwingUtilities.invokeLater(() -> {
           // new VENTANA_PRINCIPAL(); // Crea e inicia la ventana del login
           new login();
        });
        
    }
    
    /**
     * Clase que representa un usuario con su información básica.
     * 
     * Campos:
     * - usuario: el nombre de usuario.
     * - correo: el correo electrónico asociado al usuario.
     */
      public static class User{
        private String usuario;
        private String correo;
     /**
         * Constructor de la clase User.
         *
         * @param usuario el nombre del usuario
         * @param correo el correo electrónico del usuario
         */
     public User(String usuario, String correo) {
        this.usuario = usuario;
        this.correo = correo;
        }
     /**
         * Obtiene el nombre del usuario.
         *
         * @return el nombre del usuario
         */
        public String getUsuario() { return usuario; }
         /**
         * Obtiene el correo electrónico del usuario.
         *
         * @return el correo del usuario
         */
        public String getCorreo() { return correo;}
     }
     /**
     * Clase encargada de gestionar las operaciones relacionadas con los usuarios.
     * Incluye funcionalidades como leer y escribir usuarios en un archivo.
     */
     public static class UserManager {
        /**
         * Lee una lista de usuarios desde un archivo de texto.
         * 
         * El archivo debe tener cada usuario en una línea con el formato:
         * "Usuario: [nombre], Correo: [correo]".
         *
         * @param archivo la ruta del archivo desde el cual leer los usuarios.
         * @return una lista de objetos User leídos desde el archivo.
         * @throws IOException si ocurre un error al leer el archivo.
         */
    public List<User> leerUsuariosDesdeArchivo(String archivo) {
        List<User> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separar la línea en usuario y correo usando una coma
                String[] partes = linea.split(", ");
                if (partes.length == 2) {
                    String usuario = partes[0].substring(8).trim(); // Extraer el usuario
                    String correo = partes[1].substring(8).trim(); // Extraer el correo

                    // Agregar el nuevo usuario a la lista
                    usuarios.add(new User(usuario, correo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); //Maneja errores desde el archivo
        }

        return usuarios;
        }
       /**
         * Escribe una lista de usuarios en un archivo de texto.
         * Cada usuario se guarda en una línea con el formato:
         * "Usuario: [nombre], Correo: [correo]".
         *
         * @param archivo la ruta del archivo donde escribir los usuarios.
         * @param usuarios la lista de usuarios a escribir.
         * @throws IOException si ocurre un error al escribir en el archivo.
         */
        public static void escribirUsuariosEnArchivo(String archivo, List<User> usuarios) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        for (User usuario : usuarios) {
            writer.write("Usuario: " + usuario.getUsuario() + ", Correo: " + usuario.getCorreo());
            writer.newLine(); // Añade una nueva línea para separar cada usuario
        }
    } catch (IOException e) {
        e.printStackTrace();
        // Manejar el error de escritura
    }
}

     
       
     }
     
    
     

    /**
     * Clase que representa una tarea con su información básica.
     */
    public static class Tarea {
    private String usuario;
    private String nombre;
    private String descripcion;
    private String prioridad;
    private String estado;
       /**
         * Constructor de la clase Tarea.
         *
         * @param usuario el usuario asignado a la tarea
         * @param nombre el nombre de la tarea
         * @param descripcion la descripción de la tarea
         * @param prioridad la prioridad de la tarea
         * @param estado el estado de la tarea
         */
    public Tarea(String usuario, String nombre, String descripcion, String prioridad, String estado) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
    }
       /**
         * Obtiene el usuario asignado a la tarea.
         *
         * @return el usuario
         */
    public String getUsuario() { return usuario; }
       /**
         * Obtiene el nombre de la tarea.
         *
         * @return el nombre
         */
    public String getNombre() { return nombre; }
    /**
         * Obtiene la descripción de la tarea.
         *
         * @return la descripción
         */
    public String getDescripcion() { return descripcion; }
       /**
         * Obtiene la prioridad de la tarea.
         *
         * @return la prioridad
         */
    public String getPrioridad() { return prioridad; }
       /**
         * Obtiene el estado de la tarea.
         *
         * @return el estado
         */
    public String getEstado() { return estado; }
}
   /**
     * Clase encargada de gestionar las operaciones relacionadas con las tareas.
     */
public static class TareaManager {
       /**
         * Lee una lista de tareas desde un archivo de texto.
         *
         * @param archivo la ruta del archivo
         * @return una lista de objetos Tarea
         */
    public List<Tarea> leerTareasDesdeArchivo(String archivo) {
        List<Tarea> tareas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            String usuario = null, nombre = null, descripcion = null, prioridad = null, estado = null;
            
            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Usuario:")) {
                    usuario = linea.substring(8).trim();
                } else if (linea.startsWith("Nombre de la tarea:")) {
                    nombre = linea.substring(19).trim();
                } else if (linea.startsWith("Descripción:")) {
                    descripcion = linea.substring(12).trim();
                } else if (linea.startsWith("Prioridad:")) {
                    prioridad = linea.substring(10).trim();
                } else if (linea.startsWith("Estado:")) {
                    estado = linea.substring(7).trim();
                    tareas.add(new Tarea(usuario, nombre, descripcion, prioridad, estado));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tareas;
    }
       /**
         * Guarda una lista de tareas en un archivo de texto.
         *
         * @param archivo la ruta del archivo
         * @param tareas la lista de tareas a escribir
         */
   public void guardarTareasEnArchivo(String archivo, List<Tarea> tareas) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
        for (Tarea tarea : tareas) {
            writer.write("Usuario: " + tarea.getUsuario());
            writer.newLine();
            writer.write("Nombre de la tarea: " + tarea.getNombre());
            writer.newLine();
            writer.write("Descripción: " + tarea.getDescripcion()); // Asegúrate de que tienes un método getDescripcion() en tu clase Tarea
            writer.newLine();
            writer.write("Prioridad: " + tarea.getPrioridad());
            writer.newLine();
            writer.write("Estado: " + tarea.getEstado());
            writer.newLine();
            writer.write("---------------------------");
            writer.newLine(); // Añade una línea nueva para separar tareas
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}


}
}
    

    
    
    
    
    
    
    
    
    
    


