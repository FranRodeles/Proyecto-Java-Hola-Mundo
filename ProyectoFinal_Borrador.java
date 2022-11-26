/*
entrada: cantidad de vendedores, ventas x cada zona
salidas: cada punto que se puede seleccionar en el menú, la matriz impresa en consola

Integrantes del equipo que han trabajado en la traducción de este Proyecto Integrador desde pseint
a Java:

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
	int informacion[][],matrizdiaanterior[][],decision,decisionVentasZona, dia, diaAnterior, n,nAnterior, numRepresentante, verificacion, zonas;
	
	boolean ingresoDiarioAdmin, ingresoDiarioUser, ingresoUserAnterior,jornadaFinalizada,llenadoUser, menuAvanzado;
	boolean rehacerMatriz;
	boolean salir;
        
        // Se declaran las matrices
        informacion = new int[99][5];    
        matrizdiaanterior= new int[99][5];
				
	
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
                copiarMatriz(informacion,matrizdiaanterior,n,zonas);  // acá aparece otro error
            }
            }
            }
	// Subprograma: reiniciar matriz
    // Carlos Gustavo Ortiz
        
	public static void reiniciarmatriz(double informacion[][], double n, double m) {
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
	public static void verificacionavancedia(double informacion[][], double n, double m) {
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
	public static void imprimirmatriz(String matriz[][], double n, double m) {
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
	public static void copiarmatriz(String informacion[][], String matrizdiaanterior[][], double n, double m) {
		int i;
		int j;
		for (i=0;i<=n-1;i++) {
			for (j=0;j<=m-1;j++) {
				matrizdiaanterior[i][j] = informacion[i][j];
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
    

