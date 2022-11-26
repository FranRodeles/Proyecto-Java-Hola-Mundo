/*
entrada: cantidad de vendedores, ventas x cada zona
salidas: cada punto que se puede seleccionar en el menú, la matriz impresa en consola

Integrantes del equipo que han trabajado en la adaptación del código creado en Fundamentos de las Programación al lenguaje de Java:

- Israel Leonardo Montiel 
- Carlos Gustavo Ortiz

En el código se detalla qué partes ha trabajado cada integrante. 
 */
package proyectofinal_borrador;

import java.util.Scanner;


public class ProyectoFinal_Borrador {

   
    public static void main(String[] args) {
        
         Scanner entrada = new Scanner (System.in);

	
// Se definen las variables del comercio
	String avanzarDia,cambiarUsuario, jornada, menuAvanzadoDecision, salirUsuario, usuario, verificacionMatriz ;
	int informacion[][],matrizDiaAnterior[][],decision,decisionVentasZona, dia, diaAnterior, n,nAnterior, numRepresentante, verificacion, zonas;
	
	boolean ingresoDiarioAdmin, ingresoDiarioUser, ingresoUserAnterior,jornadaFinalizada,llenadoUser, menuAvanzado;
	boolean rehacerMatriz;
	boolean salir;
        
        // Se declaran las matrices
        informacion = new int[99][5];    
        matrizDiaAnterior= new int[99][5];
				
	
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
        n=0;               //******Duda si está bien inicializado
		       
	logo();
        
	System.out.println("¡Bienvenido a Palta! Comida saludable, a tu servicio");
        // Israel Leonardo Montiel 
	// Se diferencian dos usuarios: por un lado, quien ingresa la cantidad de empleados al sistema; por otro, el empleado que ingresa la cantidad de ventas realizadas.
	while ((salir!=true)) {
	    if (verificacion>=1) {
	       System.out.println("¿Desea salir del programa?(si/no)");
	       salirUsuario = entrada.nextLine();
               if (salirUsuario.equals("si")) {
               salir = true;
	}
            
	System.out.println(""); 
	if (salir==false) {
	    System.out.println("¿Avanzar de día?(si/no)"); 		
		avanzarDia = entrada.nextLine();
            if (avanzarDia.equals("Sí")){
                dia = dia+1;
                ingresoDiarioUser=false;
                nAnterior=n;
                verificacionAvanceDia(informacion,n,zonas);           // acá aparece un error
                copiarMatriz(informacion,matrizDiaAnterior,n,zonas);  // acá aparece otro error
            }
            }
            }
	// Israel Leonardo Montiel	 
	    if (salir==false) {
	   	do {
            System.out.println("¿Quién está ingresando al programa?(admin/user)");
	    usuario = entrada.nextLine();
            				
        while (!(usuario.equals("admin") || usuario.equals("user")));
	System.out.println(""); 
        
            
        // El programa una vez decidido el usuario, muestra las opciones correspondientes"
        // Israel Leonardo Montiel 
	System.out.println("Estamos en el día laboral: " + dia);
	if (usuario.equals("admin") || usuario.equals("user")) {
            if (usuario.equals("admin")) {
                System.out.println("¡Bienvenido Representante!");
                if (llenadoUser==true) {
	        System.out.println("Ya se ha llenado la información con los ajustes predeterminados (8 trabajadores");
						} 
                else {
                    do {		// Se solicita al usuario que ingrese el dato por teclado//
                        System.out.println("¿Cuántos empleados trabajarán durante la jornada de hoy? Recuerde que por defecto son 8 mínimo");
				n = Integer.parseInt(entrada.nextLine()); // Se lee por consola el número de representantes//
				} while (n>=8);
				}
	// Definimos la matriz, la llamaremos información
	// El representante decide si quiere ir al menú más avanzado en el caso de que todavía no hubiese finalizado  la jornada laboral debido a que aún no se ha producido un registro de datos.
	// Se mostrarán los datos del día anterior (con la función aleatorio en el día 1, y guardando la matriz del día anterior en otra variable)
        // Israel Leonardo Montiel 
            if (ingresoDiarioUser==false && dia==1) {
		System.out.println("Todavía no se han ingresado datos");
						} 
            else {
		do {
                	System.out.println("¿Desea ver el menú avanzado?(si/no)");
			menuAvanzadoDecision = entrada.nextLine();
		} while (!(menuAvanzadoDecision.equals("si") || menuAvanzadoDecision.equals("no")));
	// En caso afirmativo se despliega el menú y se limpia la pantalla
	if (menuAvanzadoDecision.equals("si")) {
	// Se muestra la información de n y zonas//
	System.out.println("¿Qué información desea ver?");
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
          } while (!(decision>=1 && decision<=8));
		
		
	// Subprograma: reiniciar matriz
    // Carlos Gustavo Ortiz
        
	public static void reiniciarMatriz(double informacion[][], double n, double m) {
		int i;
		int j;
		for (i=0;i<=n-1;i++) {
			for (j=0;j<=m-1;j++) {
				informacion[i][j] = 0;
			}
		}
	}
    // Subprograma: verificación avance día
    // Carlos Gustavo Ortiz
	public static void verificacionAvanceDia(double informacion[][], double n, double m) {
		int i;
		int j;
		for (i=0;i<=n-1;i++) {
			for (j=0;j<=m-1;j++) {
				if (Double.toString(m).equals(" ")) {
					informacion[i][j] = 0;
				}
			}
		}
	}
    // Subprograma: imprimir matriz
    // Carlos Gustavo Ortiz
	public static void imprimirMatriz(String matriz[][], double n, double m) {
		int i;
		int j;
		System.out.println("                N S E O C");
		for (i=0;i<=n-1;i++) {
			System.out.print("representante "+i+1+"[");
			for (j=0;j<=m-1;j++) {
				System.out.print(matriz[i][j]);
				if (j!=m-1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
	}
		
		
    //Subprograma: copiar matriz
    // Carlos Gustavo Ortiz
	public static void copiarMatriz(String informacion[][], String matrizDiaAnterior[][], double n, double m) {
		int i;
		int j;
		for (i=0;i<=n-1;i++) {
			for (j=0;j<=m-1;j++) {
				matrizDiaAnterior[i][j] = informacion[i][j];
			}
		}
	}
      //Subprograma Mayor venta
// Se define qué vendedor tiene el mayor número de ventas por zona//
//Carlos Gustavo Ortiz
       	public static void mayorVenta(double n, double zonas, int informacion[][]) {
		int i;
		int j;
		int vendedor;
		int ventaMayor;
		String zona="";                 //Duda si está bien inicializado
                vendedor=1;                     // Duda si está bien inicializado
                
		ventaMayor = -1;
		for (i=0;i<=n-1;i++) {
			for (j=0;j<=zonas-1;j++) {
				if (ventaMayor<informacion[i][j]) {
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
		if (ventaMayor==0) {
			System.out.println("No hubo ventas el dia de hoy");
		} else {
			System.out.print("La mayor venta fue de "+ventaMayor+" La realizó el vendedor "+vendedor+1);
			System.out.println(" En la zona "+zona);
		}
	}  
        
// Logo
// Carlos Gustavo Ortiz
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
    

