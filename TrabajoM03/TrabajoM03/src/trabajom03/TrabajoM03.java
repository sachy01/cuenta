/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajom03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jonathanseguraberiguete
 */
public class TrabajoM03 {


    // En esta constante hemos guardado la ruta en la que almacenamos el fichero de texto
    public static final String RUTA_FICHERO_TXT = "Archivos/taulas.txt";
    public static final String RUTA_FICHERO_USERS = "Archivos/users.dat";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
   
        System.out.println("");
        System.out.println("+------------------------+");
        System.out.println("| GESTIÓN DE RESTAURANTE |");
        System.out.println("+------------------------+");
        System.out.println("");

        //4primerUsuario(arrUsuarios);

        
        primerUsuario();
        
        menuCamarero();
        
        
    }
    
    private static void leerFicheroTxt() {
        
        //Esta funcion lee directamente desde el fichero la información contenida en el fichero de texto
        //En caso de no poder acceder al fichero, el catch devolverá un mensaje de error legible por el usuario
        File fichero = new File(RUTA_FICHERO_TXT);

        System.out.println("");
        System.out.println("*****LISTADO DE MESAS***");

        try {

            Scanner lectorFichero = new Scanner(fichero);

            while (lectorFichero.hasNext()) {
                System.out.println(lectorFichero.nextLine());

            }

            lectorFichero.close();

        } catch (Exception e) {

            System.out.println("Ha ocurrido un error al abrir/leer el fichero");

        }

    }

    private static void editarFicheroTxt() {
         Scanner entrada = new Scanner (System.in);
        
     
        File fichero = new File (RUTA_FICHERO_TXT);
        
        //Array para guardar todas laslíneas leídas
        ArrayList <String> lineas = new ArrayList<>();
        
        try{
        
            Scanner leerFichero = new Scanner (fichero);
            
            while(leerFichero.hasNext()){
                lineas.add(leerFichero.nextLine());
            }
            
            leerFichero.close();
            
        }catch (Exception ex) {
            
            System.out.println("No ha sido posible leer el fichero");
            
        }
        
        System.out.println("Introduce el nombre de la mesa");
        System.out.print(">");
        String nombre = entrada.nextLine();
        //Abrimos el fichero de texto para sobreescribirlo
        
        try{
            FileWriter writer = new FileWriter (fichero);
            
            for (String linea : lineas) {
               
                if (!nombre.equals(linea.substring(0, linea.indexOf(",")))) {
                    
                    writer.write("\n"+linea);
                  
                    
                    
                    
                }
                
          }

            
            writer.close();
        }catch (Exception e) {
            
        }
        
        try {
            Scanner leerFichero = new Scanner(fichero);
            String Nuevonombre, descripcion, respuesta;
            int capacidad, sillas;
            boolean silla_niño = true, ventilador = true, jardin = true;

            //Nueva entrada de Nuevonombre
            System.out.println("Introduce el nuevo nombre: ");
            System.out.print(">");
            Nuevonombre = entrada.nextLine();

            //Nueva entrada de descripcion
            System.out.println("Introduce la descripcion: ");
            System.out.print(">");
            descripcion = entrada.next();

            //Nueva entrada de capacidad
            System.out.println("Introduce la capacidad de la mesa: ");
            System.out.print(">");
            capacidad = entrada.nextInt();

            //Nueva entrada de silla_niño 
            System.out.println("Introduce si la mesa tiene sillas de niño o no: ");
            System.out.print(">");
            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                silla_niño = false;
            }

            System.out.println("Introduce la capacidad de sillas: ");
            System.out.print(">");
            sillas = entrada.nextInt();

            //Nueva entrada de ventilador           
            System.out.println("Introduce si la mesa tiene ventilador: ");
            System.out.print(">");
            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                ventilador = false;
            }

            //Nueva entrada de jardin
            System.out.println("Introduce si la mesa está en el jardin: ");
            System.out.print(">");

            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                jardin = false;
            }

            // El true al final indica que escribiremos al final del fichero 
            //añadiendo texto
            FileWriter nuevaLinea = new FileWriter(fichero, true);
            //Se secribe la nueva entrada del resto de atributos en el fichero     
            nuevaLinea.write("\n"+Nuevonombre + "," + descripcion + "," + capacidad + ","
                    + silla_niño + "," + sillas + "," + ventilador + ","
                    + jardin + "\n");
            nuevaLinea.flush();//limpia la memoria del writer

            nuevaLinea.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al añadir la mesa");
        }

    }

    private static void escribirFicheroTxt() {
        Scanner entrada = new Scanner(System.in);
        //Funcion para escribir, escribirá los datos que el usuario le pase en forma de String
        //En el fichero de texto

        File fichero = new File(RUTA_FICHERO_TXT);

        try {
            Scanner leerFichero = new Scanner(fichero);
            String nombre, descripcion, respuesta;
            int capacidad, sillas;
            boolean silla_niño = true, ventilador = true, jardin = true;

            //Nueva entrada de Nuevonombre
            System.out.println("Introduce el nombre: ");
            System.out.print(">");
            nombre = entrada.nextLine();

            //Nueva entrada de descripcion
            System.out.println("Introduce la descripcion: ");
            System.out.print(">");
            descripcion = entrada.next();

            //Nueva entrada de capacidad
            System.out.println("Introduce la capacidad de la mesa: ");
            System.out.print(">");
            capacidad = entrada.nextInt();

            //Nueva entrada de silla_niño 
            System.out.println("Introduce si la mesa tiene sillas de niño o no: ");
            System.out.print(">");
            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                silla_niño = false;
            }

            System.out.println("Introduce la capacidad de sillas: ");
            System.out.print(">");
            sillas = entrada.nextInt();

            //Nueva entrada de ventilador           
            System.out.println("Introduce si la mesa tiene ventilador: ");
            System.out.print(">");
            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                ventilador = false;
            }

            //Nueva entrada de jardin
            System.out.println("Introduce si la mesa está en el jardin: ");
            System.out.print(">");

            respuesta = entrada.next();

            if (!respuesta.equals("si")) {
                jardin = false;
            }

            // El true al final indica que escribiremos al final del fichero 
            //añadiendo texto
            FileWriter nuevaLinea = new FileWriter(fichero, true);
            //Se secribe la nueva entrada del resto de atributos en el fichero     
            nuevaLinea.write(nombre + "," + descripcion + "," + capacidad + ","
                    + silla_niño + "," + sillas + "," + ventilador + ","
                    + jardin + "\n");
            nuevaLinea.flush();//limpia la memoria del writer

            nuevaLinea.close();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al añadir la mesa");
        }
    }

    private static void borrarLinea() {
        Scanner entrada = new Scanner (System.in);
        boolean mesaExiste = false;
        String lineaBorrar = null;
     
        File fichero = new File (RUTA_FICHERO_TXT);
        
        //Array para guardar todas laslíneas leídas
        ArrayList <String> lineas = new ArrayList<>();
        
        try{
        
            Scanner leerFichero = new Scanner (fichero);
            
            while(leerFichero.hasNext()){
                lineas.add(leerFichero.nextLine());
            }
            
            leerFichero.close();
            
        }catch (Exception ex) {
            
            System.out.println("No ha sido posible leer el fichero");
            
        }
        
        System.out.println("Introduce el nombre de la mesa");
        System.out.print(">");
        String nombre = entrada.nextLine();
        //Abrimos el fichero de texto para sobreescribirlo
        
        try{
            FileWriter writer = new FileWriter (fichero);
            
            for (String linea : lineas) {
               
                if (!nombre.equals(linea.substring(0, linea.indexOf(",")))) {
                    
                    writer.write("\n"+linea);
                  
                    
                    
                    
                }
                
          }

            
            writer.close();
        }catch (Exception e) {
            
        }
    }

    private static void menuCamarero() {
        
        //Esta funcion contiene el menú de camarero con las distintas opciones que tendran los usuarios con este rol
        Scanner sc = new Scanner (System.in);
  
        System.out.println("****** MENU CAMARERO******");

        char letra;
        boolean salir = false;
        int num;

        do {//procedemos a hacer un bucle para que el asta que el usuario no ponga la respuesta correcta o presiona salir se esata repitiendo la opciones 
            System.out.println("1.  Lista de toda la tablas ");
            System.out.println("2.  Dar el alta una tabla");
            System.out.println("3.  Modificar/Editar una tabla");
            System.out.println("4.  Borrar una mesa");
            System.out.println("5.  Salir");
            
            num = sc.nextInt();//esta es un entero que hemos creado para que el usuario selecione en el SWICTH
        

        switch (num) { // dividimos las opciones en casos en un switch para separar cada una de las opciones
            case 1:
                System.out.println("**Lista de todas las mesas**");
                leerFicheroTxt();
                
                System.out.println("");
                System.out.println("*** FIN DEL LISTADO DE MESAS ***");
                System.out.println("");

                break;
            case 2://NUEVA MESA
                
                escribirFicheroTxt();
                
                

                break;
            case 3://MODIFICAR MESA
                
                editarFicheroTxt();
                        
             
                break;
            case 4://BORRAR LÍNEA
                
                borrarLinea();
                

                break;
            case 5:
                salir = true;
                
                System.out.println("Saliendo del Menu");
                break;
        }
        
        
        } while (num !=5);

    }
    
    private static void primerUsuario() {
        Scanner entrada = new Scanner (System.in);
        ArrayList <Usuario> arrUsuarios = new ArrayList<>();
        
        ObjectOutputStream fichero = null;
        try {
            //Guara y crea usuario si la aplicación empieza desde 0
            
            File ficherousuarios = new File (RUTA_FICHERO_USERS);
            boolean existe = ficherousuarios.exists();
            fichero = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO_USERS, true));
            
             
            Usuario usuario1 = new Usuario();
            
            try{
            
                ObjectInputStream Openfichero = new ObjectInputStream(new FileInputStream(RUTA_FICHERO_USERS));
                arrUsuarios =  (ArrayList<Usuario>) Openfichero.readObject();
                Openfichero.close();
            
            }catch (Exception ex) {
                
            }
            
            if (!existe) {
                
                
                
                String rol = "admin";
                usuario1.setRol(rol);

                System.out.println("***********************************");
                System.out.println("Bienvenido nuevo usuario.");
                System.out.println("Registre su cuenta de Administrador.");
                System.out.println("************************************\n");
                System.out.println("Introduce el nombre del Administrador");
                System.out.print("> ");
                
                usuario1.setUser(entrada.next());
                
                System.out.print("Introduce la contraseña: ");
                
                usuario1.setContraseña(entrada.next());
                
                arrUsuarios.add(0, usuario1);
                
                System.out.println("\nUsuario registrado correctamente."
                        + "\nIniciando el programa.");
                
            }
            
            //Escribiremos el nuevo usuario
            fichero.writeObject(usuario1);
            
            fichero.close();
                   
            
            

            } catch (Exception e) {
                System.out.println("");
             }
        
        
        
    }
     
        
    }
    

