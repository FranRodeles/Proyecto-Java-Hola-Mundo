/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    

