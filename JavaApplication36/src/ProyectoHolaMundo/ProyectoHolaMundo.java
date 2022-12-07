/*
entrada: cantidad de vendedores, ventas x cada zona
salidas: cada punto que se puede seleccionar en el menú, la matriz impresa en consola
En el código se identifican los integrantes del equipo que han participado en la adaptación del pseudocódigo creado en 
Fundamentos de la Programación al lenguaje de Java
Se detalla en qué ha trabajado cada uno.
 */
package ProyectoHolaMundo;

import java.util.Scanner;

public class ProyectoHolaMundo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Se definen las variables del comercio
        String avanzarDia, cambiarUsuario, jornada, menuAvanzadoDecision, salirUsuario, usuario, verificacionMatriz;
        int informacion[][], matrizDiaAnterior[][], decision, decisionVentasZona, dia, diaAnterior, n, nAnterior, numRepresentante, verificacion, zonas;

        boolean ingresoDiarioAdmin, ingresoDiarioUser, ingresoUserAnterior, jornadaFinalizada, llenadoUser, menuAvanzado;
        boolean rehacerMatriz;
        boolean salir;

        // Se declaran las matrices
        informacion = new int[99][5];
        matrizDiaAnterior = new int[99][5];

        // valor predeterminado de variables
        ingresoDiarioAdmin = false;
        jornadaFinalizada = false;
        menuAvanzado = false;
        salir = false;
        rehacerMatriz = true;
        ingresoDiarioUser = false;
        llenadoUser = false;
        ingresoUserAnterior = false;
        zonas = 5;
        verificacion = 0;
        dia = 1;
        n = 0;
        avanzarDia = "";
        usuario = "";
        salirUsuario = "";
        menuAvanzadoDecision = "";
        nAnterior = 0;
        verificacionMatriz = "";

        logo();

        System.out.println("¡Bienvenido a Palta! Comida saludable, a tu servicio");

        // Israel Leonardo Montiel 
        // Se diferencian dos usuarios: por un lado, quien ingresa la cantidad de empleados al sistema; por otro, el empleado que ingresa la cantidad de ventas realizadas.
        while (!salir) {
            if (verificacion >= 1) {
                System.out.println("¿Desea salir del programa?(si/no)");            
                    do {
                        salirUsuario = entrada.nextLine();
                    }while (!(salirUsuario.equals("si") || salirUsuario.equals("no")));
                if (salirUsuario.equals("si")) {
                    salir = true;
                    //SE SALE DEL PROGRAMA DIRECTO
                }
                
                // Carlos Gustavo Ortiz
                //Francisco Rodeles(Agregar verificaciones,identación, y agregar correciones)
                // Avanzar día
                if (salir == false) {
                    System.out.println("¿Avanzar de día?(si/no)");
                    do {
                        avanzarDia = entrada.nextLine();
                    }while (!(avanzarDia.equals("si") || avanzarDia.equals("no")));
                    if (avanzarDia.equals("si")) {
                        if (!ingresoDiarioUser) {
                            System.out.println("Seguro que quiere avanzar? Los empleados aun no suben datos");
                            do {
                                usuario = entrada.nextLine();
                            } while (!(usuario.equals("si") || usuario.equals("no")));
                            if (usuario.equals("si")) {
                                System.out.flush();
                                System.out.println("Avanzando dia");
                                dia+=1;
                                ingresoUserAnterior = false;
                            } 
                        }else {
                            System.out.println("Entre en dia");
                            dia +=1;
                            ingresoDiarioUser = false;
                            ingresoUserAnterior = true;
                            nAnterior = n;
                            copiarMatriz(informacion, matrizDiaAnterior, n, zonas);
                            reiniciarMatriz(informacion, n, zonas);
                        }                        
                    }
                }
            }
            
            // Israel Leonardo Montiel	 
            if (salir == false) {
                System.out.println("¿Quién está ingresando al programa?(admin/user)");
                do {
                    usuario = entrada.nextLine();
                }while (!(usuario.equals("admin") || usuario.equals("user")));
                System.out.flush();
                    // Israel Leonardo Montiel  
                    // El programa una vez decidido el usuario, muestra las opciones correspondientes"
                    System.out.println("Estamos en el día laboral: " + dia);
                    
                    if (usuario.equals("admin") || usuario.equals("user")) {
                        if (usuario.equals("admin")) {
                            System.out.println("¡Bienvenido Representante!");
                            if (llenadoUser) {
                                System.out.println("Ya se ha llenado la información con los ajustes predeterminados "
                                        + "(8 trabajadores) o los seleccionados antes: "+n);
                            } else {
                                do {		// Se solicita al usuario que ingrese el dato por teclado//
                                    System.out.println("¿Cuántos empleados trabajarán durante la jornada de hoy? Recuerde que por defecto son 8 mínimo");
                                    n = Integer.parseInt(entrada.nextLine()); // Se lee por consola el número de representantes//
                                } while (!(n >= 8));
                                ingresoDiarioAdmin = true;
                            }

                            // Israel Leonardo Montiel
                            // Definimos la matriz, la llamaremos información
                            // El representante decide si quiere ir al menú más avanzado en el caso de que todavía no hubiese finalizado  la jornada laboral debido a que aún no se ha producido un registro de datos.
                            // Se mostrarán los datos del día anterior (con la función aleatorio en el día 1, y guardando la matriz del día anterior en otra variable)
                            if (!ingresoDiarioUser && dia == 1) {
                                System.out.println("Todavía no se han ingresado datos");
                            } else {
                                if (!ingresoUserAnterior  && dia != 1) {
                                    System.out.println("Ayer no se ingresaron datos, espere los de hoy para trabajar");
                                } else {
                                    do {
                                        System.out.println("¿Desea ver el menú avanzado?(si/no)");
                                        menuAvanzadoDecision = entrada.nextLine();
                                    } while (!(menuAvanzadoDecision.equals("si") || menuAvanzadoDecision.equals("no")));
                                }
                                //Francisco Rodeles(agregue correciones y switch)
                                // En caso afirmativo se despliega el menú y se limpia la pantalla
                                if (menuAvanzadoDecision.equals("si")) {
                                    // Se muestra la información de n y zonas//
                                    System.out.println("¿Qué información desea ver?Recuerde que es diaria");
                                    do {
                                        // Menú de opciones para consola de usuario. El usuario determina UNA decisión por entrada//
                                        do {
                                            System.out.println(" ");
                                            System.out.println("1)Total de ventas por zona");
                                            System.out.println("2)Total de los representantes");
                                            System.out.println("3)Las ventas de algún representante");
                                            System.out.println("4)Ver las ventas de cada representante");
                                            System.out.println("5)La mayor venta, y ver que representante la hizo y en qué zona");
                                            System.out.println("6)Los datos de las ventas de ayer");
                                            System.out.println("7)Limpiar pantalla");
                                            System.out.println("8)salir");
                                            decision = Integer.parseInt(entrada.nextLine());
                                        } while (!(decision >= 1 && decision <= 8));
                                        
                                        switch(decision){
                                            case 1:
                                                do{
                                                    System.out.println("De que zona desea ver las ventas?");
                                                    System.out.println("1)Norte");
                                                    System.out.println("2)Sur");
                                                    System.out.println("3)Este");
                                                    System.out.println("4)Oeste");
                                                    System.out.println("5)Centro");
                                                    decisionVentasZona = Integer.parseInt(entrada.nextLine());
                                                }while(!(decisionVentasZona >= 1 || decisionVentasZona <= 5));
                                                ventaZona(n,zonas,informacion,decisionVentasZona);
                                                break;
                                            case 2:
                                                ventaZonaPorRepresentante(n,zonas,informacion);
                                                break;
                                            case 3:
                                                do{
                                                    System.out.println("Indique el representante de ventas que desea consultar");
                                                    numRepresentante = Integer.parseInt(entrada.nextLine());
                                                }while(!(numRepresentante >= 1 || numRepresentante <= n));
                                                ventasRepresentante(n,zonas,informacion,numRepresentante);
                                                break;
                                            case 4:
                                                ventaRepresentanteXZona(n,zonas,informacion);
                                                break;
                                            case 5:
                                                mayorVenta(n,zonas,informacion);
                                                break;
                                            case 6:
                                                System.out.println("Dia: "+dia);
                                                if (dia == 1){
                                                    System.out.println("No hay datos del dia anterior");
                                                } else {
                                                System.out.println("Información del dia " + (dia - 1));
                                                imprimirMatriz(matrizDiaAnterior, nAnterior, zonas);
                                                }
                                                break;
                                            case 7:
                                                System.out.flush();
                                                break;
                                    }
                                    // Carlos Gustavo Ortiz
                                } while (!(decision == 8));   // Subprograma: reiniciar matriz

                                //Francisco Rodeles
                            }
                        }
                        verificacion++;
                    }

                
                    
                    //Si el admin no cambia la cantidad de trabajadores, se predetermina en 8
                    if (!ingresoDiarioAdmin){
                        n = 3;
                    }
                    //El trabajador puede ingresar la cantidad de ventas realizadas hoy
                    if (usuario.equals("user")){
                        System.out.println("Bienvenido Vendedor");
                        do{
                            System.out.println("Ha finalizado su jornada laboral(si/no)");
                            jornada = entrada.nextLine();
                        }while(!(jornada.equals("si") || jornada.equals("no")));
                        if (jornada.equals("no")){
                            System.out.println("Aún no puede ingresar las ventas realizadas el día de hoy");
                            verificacion++;
                        }else{
                            System.out.println("Ingrese las ventas realizadas por zona durante esta jornada");
                            llenarMatriz(n,zonas,informacion);
                            imprimirMatriz(informacion,n,zonas);
                            //verificación de la matriz
                            do{
                                System.out.println("Son correctos los datos ingresados(si/no)");
                                do {
                                    verificacionMatriz = entrada.nextLine();
                                } while (!(verificacionMatriz.equals("si") || verificacionMatriz.equals("no")));
                                if (verificacionMatriz.equals("si")) {
                                    rehacerMatriz = false;
                                    llenadoUser = true;
                                    ingresoDiarioUser = true;
                                } else {
                                    llenarMatriz(n, zonas, informacion);
                                    imprimirMatriz(informacion, n, zonas);
                                }
                            } while (rehacerMatriz);
                            System.out.println("Gracias por trabajar con nosotros!");
                        }
                    }
                }
            }
        }
        
        System.out.flush();
        logo();
        System.out.println("Gracias por elegir Palta como su plataforma de comida!");
    }
    
                    

    public static void llenarMatriz(int n, int zonas, int informacion[][]) {
        int i, j,m;
        String nombreZona;
        nombreZona = "";
        Scanner entrada = new Scanner(System.in);
        m = 0;
        System.out.flush();
        System.out.println("Recuerde que no pueden haber más de 10 ventas por zona");
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= zonas - 1; j++) {      
                switch (j) {
                    case 0:
                        System.out.println("entre");
                        nombreZona = "Norte";
                        break;
                    case 1:
                        nombreZona = "Sur";
                        break;
                    case 2:
                        nombreZona = "Este";
                        break;
                    case 3:
                        nombreZona = "Oeste";
                        break;
                    case 4:
                        nombreZona = "Centro";
                        break;
                }
                do {
                    System.out.println("Introduzca las ventas del vendedor " + (i + 1) + " en la zona " + nombreZona);
                    m = Integer.parseInt(entrada.nextLine());
                        informacion[i][j] = m;
                                       
                }while (!(m > -1 && m <= 10));
            }
        }
    }


    public static void reiniciarMatriz(int informacion[][], double n, double m) { //Ya lo arreglo yo (Francisco Rodeles)
        int i, j;
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= m - 1; j++) {
                informacion[i][j] = 0;
            }
        }
    }



    // Carlos Gustavo Ortiz
    // Subprograma: imprimir matriz
    public static void imprimirMatriz(int matriz[][], double n, double m) {
        int i;
        int j;
        System.out.println("                N S E O C");
        for (i = 0; i <= n - 1; i++) {
            System.out.print("representante " + (i + 1) + "[");
            for (j = 0; j <= m - 1; j++) {
                System.out.print(matriz[i][j]);
                if (j != m - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
    }

    // Carlos Gustavo Ortiz		
    // Subprograma: copiar matriz
    public static void copiarMatriz(int informacion[][], int matrizDiaAnterior[][], double n, double m) {
        int i;
        int j;
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= m - 1; j++) {
                matrizDiaAnterior[i][j] = informacion[i][j];
            }
        }
    }
    
    public static void ventaZona(int n, int zonas, int informacion [][],int decisionVentasZona){
        int i,acumuladorVentasZona;
        String  nombreZona;
        acumuladorVentasZona = 0;
        nombreZona = "";        
        
        for (i =0; i <= n-1 ;i++){
            acumuladorVentasZona = informacion[i][(decisionVentasZona-1)] + acumuladorVentasZona;
        }
        switch(decisionVentasZona){
            case 1: nombreZona = "Norte"; break;
            case 2: nombreZona = "Sur"; break;
            case 3: nombreZona = "Este"; break;
            case 4: nombreZona = "Oeste"; break;
            case 5: nombreZona = "Centro"; break;
        }
        System.out.println("Las ventas de la zona "+ nombreZona + " son "+acumuladorVentasZona); 
    }
    
    public static void ventaZonaPorRepresentante(int n,int zonas,int informacion[][]){
        int i;
        for (i =1;i <= zonas;i++){
            ventaZona(n,zonas,informacion,i);
        }
    }
    
    private static void ventasRepresentante(int n, int zonas,int informacion[][], int numRepresentante) {
        int ventaRepresentante = 0;
        System.out.println("n: "+n);
        for (int i = 0; i < zonas; i++) {
            ventaRepresentante += informacion[numRepresentante - 1][i];
        }

        System.out.println("Las ventas del representante " + numRepresentante + " son :" + ventaRepresentante);
    }
    
    public static void ventaRepresentanteXZona(int n, int zonas, int informacion[][]){

        int i;
        
        for (i = 0; i <= n;i++){
            System.out.println("i: "+ i);
            ventasRepresentante(n,zonas,informacion,i);
        }
    }

    //Carlos Gustavo Ortiz	
    //Subprograma Mayor venta
    // Se define qué vendedor tiene el mayor número de ventas por zona//
    public static void mayorVenta(int n, int zonas, int informacion[][]) {
        System.out.println("Entre");
        int i;
        int j;
        int vendedor;
        int ventaMayor;
        String zona = "";                 //Duda si está bien inicializado
        vendedor = 1;                     // Duda si está bien inicializado

        ventaMayor = -1;
        for (i = 0; i <= n - 1; i++) {
            for (j = 0; j <= zonas - 1; j++) {
                if (ventaMayor < informacion[i][j]) {
                    ventaMayor = informacion[i][j];
                    vendedor = i;
                    switch (j) {
                        case 0:
                            zona = "Norte";
                            break;
                        case 1:
                            zona = "Sur";
                            break;
                        case 2:
                            zona = "Este";
                            break;
                        case 3:
                            zona = "Oeste";
                            break;
                        case 4:
                            zona = "Centro";
                            break;
                    }
                }
            }
        }
        if (ventaMayor == 0) {
            System.out.println("No hubo ventas el dia de hoy");
        } else {
            System.out.print("La mayor venta fue de " + ventaMayor + " La realizó el vendedor " + (vendedor + 1));
            System.out.println(" En la zona " + zona);
        }
    }

    // Carlos Gustavo Ortiz   
    // Logo
    public static void logo() {
        System.out.println("            .::::::::..                                                                     ");
        System.out.println("           .:::::::::::::                                                                   ");
        System.out.println("          ::::::::::::::::                                                                  ");
        System.out.println("         :::::::::::::::::.                                                                 ");
        System.out.println("        .:::::::::::::::::::                               --.                              ");
        System.out.println("       :::::::::::::::::::::.                              --.  .::.                        ");
        System.out.println("      .:::::::::::::::::::::::     ..  .::..      ..:::.   --. .:--:.     .:::..           ");
        System.out.println("     .::::::::::.....:::::::::     :---:::---.  .--:..:--. --. .:--::.  :-::..:-:          ");
        System.out.println("    :::::   .         .::::::.    :--.    :--   .....:--:  --.  .--.     ....::--           ");
        System.out.println("   :-----.    :----:    :----:    :--     :--  :--::..:-:  --.  .--.   :---::..--           ");
        System.out.println("   :-----.  .-------:   .----:    :--:...:--:  --:  ..--:  --.   --:.  ---.  .:--           ");
        System.out.println("   :-----.  :--------   .----:    :--:----:.   .:----::-:  --.   :--.  :-----:--.          ");
        System.out.println("    -----.   :------.   :----.    :-:                                                       ");
        System.out.println("     .----.     ....    :----.    :-:                                                      ");
        System.out.println("      .---.  .:.     .:----:.                                                               ");
        System.out.println("        .:.  .------------.                                                                 ");
        System.out.println("             .--------:.                                                                    ");
        System.out.println("                 ...                                                                         ");
    }

}
