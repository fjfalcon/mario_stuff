package es.sanoguera.view;

import java.util.Scanner;

/**
 * Created by fjfalcon on 26.11.14.
 */
public class Menu
{
    static final String menuWelcome = "Elige una de las siguientes opciones:\n" +
            "        Pulsa el número y aprieta enter para seleccionar tu opcion\n" +
            "        \n" +
            "        1. Departamentos\n" +
            "        2. Empleados\n" +
            "        3. Salir\n";

    static final String departamentos = "Pulsa el número y aprieta enter para seleccionar tu opcion\n" +
            "            \n" +
            "            1. Dar de Alta un Departamento\n" +
            "            2. Dar de Baja un Departamento\n" +
            "            3. Modificar un Departamento\n" +
            "               ";

    static final String empleados = "Pulsa el número y aprieta enter para seleccionar tu opcion\n" +
            "            \n" +
            "            1. Dar de Alta un Empleado\n" +
            "            2. Dar de Baja un Empleado\n" +
            "            3. Modificar un Empleado\n";


    static final String salir = "El programa ahora se cerrara";

    private Scanner in;

    public Menu()
    {
        in = new Scanner(System.in);
        displayMenu();
    }

    private void displayMenu()
    {
        System.out.println(menuWelcome);

        switch(in.nextInt())
        {
            case 1:

            break;

            case 2:
                break;

            case 3:
                System.out.println(salir);
                System.exit(0);
                break;

            default:
                displayMenu();
        }
    }

}
