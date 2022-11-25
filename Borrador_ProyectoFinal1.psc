//entrada: cantidad de vendedores, ventas x cada zona
//salidas: cada punto que se puede seleccionar en el menú, la matriz impresa en consola
Algoritmo Ventas
	
	Definir n,zonas,informacion,decision,decisionVentasZona,numRepresentante,verificacion,dia,diaAnterior,matrizDiaAnterior,nAnterior como entero; //Se definen las variables del comercio//
	Definir jornada,usuario,menuAvanzadoDecision,cambiarUsuario,salirUsuario,verificacionMatriz,avanzarDia Como Cadena;
	Definir ingresoDiarioAdmin,ingresoDiarioUser,jornadaFinalizada,menuAvanzado,salir,rehacerMatriz,llenadoUser Como Logico;
	//valor predeterminado de variables
	ingresoDiarioAdmin <- Falso;
	jornadaFinalizada<-Falso;
	menuAvanzado<-Falso;
	salir <- Falso;
	rehacerMatriz<-Verdadero;
	ingresoDiarioUser<-Falso;
	llenadoUser<-Falso;
	zonas<-5;
	verificacion <-0;
	dia<-1;
	dimension matrizDiaAnterior(99,5); 
	dimension informacion(99,5);
	
	logo();
	
	Escribir "¡Bienvenido a Palta! Comida saludable, a tu servicio";
	
	
	//Se diferencian dos usuarios: por un lado, quien ingresa la cantidad de empleados al sistema; por otro, el empleado que ingresa la cantidad de ventas realizadas.
	
	Mientras (salir <> Verdadero) Hacer
		
		si verificacion >= 1 Entonces
			Escribir "¿Desea salir del programa?(si/no)";
			leer salirUsuario;
			si salirUsuario = "si" Entonces
				salir <- Verdadero;
			FinSi
			Limpiar Pantalla;
			Si salir = Falso Entonces
				Escribir "¿Avanzar de día?(si/no)";
				Leer AvanzarDia;
				si AvanzarDia = "si" Entonces
					dia<-dia+1;
					ingresoDiarioUser<-Falso;
					nAnterior<-n;
					verificacionAvanceDia(informacion,n,zonas);
					copiarMatriz(informacion,matrizDiaAnterior,n,zonas);
				FinSi
			FinSi
		FinSi
		
		si salir = Falso Entonces
			Repetir
				Escribir "¿Quién está ingresando al programa?(admin/user)";
				leer usuario;
			Hasta que usuario = "admin" o usuario = "user"
			Limpiar Pantalla;
			//El programa una vez decidido el usuario, muestra las opciones correspondientes"
			Escribir "Estamos en el día laboral: ",dia;
			
			Si usuario = "admin" o usuario = "user" entonces
				Si usuario = "admin" Entonces
					Escribir "¡Bienvenido Representante!";
					Si llenadoUser = verdadero Entonces
						Escribir "Ya se ha llenado la información con los ajustes predeterminados(8 trabajadores)";
					SiNo
						Repetir
							Escribir "¿Cuántos empleados trabajarán durante la jornada de hoy? Recuerde que por defecto son 8 mínimo"; //Se solicita al usuario que ingrese el dato por teclado//
							Leer n; //Se lee por consola el número de representantes//
						Hasta Que n >=8
					FinSi
					//Definimos la matriz, la llamaremos información
					//El representante decide si quiere ir al menú más avanzado en el caso de que todavía no hubiese finalizado  la jornada laboral debido a que aún no se ha producido un registro de datos.
					//Se mostrarán los datos del día anterior (con la función aleatorio en el día 1, y guardando la matriz del día anterior en otra variable)
					
					si ingresoDiarioUser = Falso y dia = 1 Entonces
						Escribir "Todavía no se han ingresado datos";
						
					SiNo
						Repetir
							Escribir "¿Desea ver el menú avanzado?(si/no)";
							Leer menuAVanzadoDecision;
						Hasta Que menuAVanzadoDecision = "si" o menuAVanzadoDecision = "no" 
						
						// En caso afirmativo se despliega el menú y se limpia la pantalla
						
						Si menuAvanzadoDecision = "si" Entonces
							
							Escribir "¿Qué información desea ver?"; //Se muestra la información de n y zonas//
							
							Repetir
								Repetir //Menú de opciones para consola de usuario. El usuario determina UNA decisión por entrada//
									Escribir " "; 
									Escribir "1)Total de ventas por zona"; 
									Escribir "2)Total de los representantes";
									Escribir "3)Las ventas de algún representante";
									Escribir "4)Ver las ventas de cada representante";
									Escribir "5)La mayor venta, y ver que representante la hizo y en qué zona";
									Escribir "6)Los datos de las ventas de ayer";
									Escribir "7)Limpiar pantalla";
									Escribir "8)salir";
									Leer decision;
								Hasta Que decision >= 1 y decision <=8
								
								segun decision hacer //El usuario ingresa al menú de opciones respecto de la Zona de ventas y selecciona//
									1:   
										Repetir
											Escribir "¿De qué zona desea ver las ventas";
											Escribir "1)Norte";
											Escribir "2)Sur";
											Escribir "3)Este";
											Escribir "4)Oeste";
											Escribir "5)Centro";
											Leer decisionVentasZona;
										Hasta Que  decisionVentasZona >=1 y decisionVentasZona <=5
										ventaZona(n,zonas,informacion,decisionVentasZona);
									2:
										VentaZonaPorRepresentante(n,zonas,informacion);
									3: 
										Repetir
											Escribir "Indique el representante de ventas que desea consultar"; //El usuario introduce por pantalla el representante a verificar//
											Leer numRepresentante; //Se muestra como salida el represntante detallado por consola como dato de entrada//
										Hasta Que 1 <= numRepresentante y numRepresentante <= n 
										VentasRepresentante(n,zonas,informacion,numRepresentante);
									4:  
										VentaRepresentateXZona(n,zonas,informacion);
									5:
										MayorVenta(n,zonas,informacion);
									6:
										Si dia = 1 Entonces 
											Escribir "No hay datos del día anterior";
										SiNo
											Escribir "Información del día ",dia-1;
											imprimirMatriz(matrizDiaAnterior,nAnterior,zonas);
										FinSi
										
									7:
										Limpiar Pantalla;
										
								FinSegun
							Hasta que decision = 8
							Escribir "¡Entendido!" sin saltar;
							Escribir "¡Gracias por representar a nuestra empresa en su ciudad!";
						FinSi
					FinSi
					
					ingresoDiarioAdmin <- Verdadero;
					verificacion <- verificacion+1;
					
				FinSi
				//Si el admin no cambia la cantidad de trabajadores, es decir que no entró al programa, aparecerá la cantidad predeterminada, que en este caso es 8
				Si ingresoDiarioAdmin = Falso Entonces
					n <- 8;
				FinSi
				//El trabajador puede ingresar la cantidad de ventas realizadas hoy
				Si usuario = "user" Entonces
					ingresoDiarioUser<-Verdadero;
					Escribir "¡Bienvenido Vendedor!";
					Repetir
						Escribir "¿Ha finalizado su jornada laboral?(si/no)";
						Leer jornada;
					Hasta que jornada = "si" o jornada = "no"
					Si jornada = "no" Entonces
						Escribir "Aún no puede ingresar las ventas realizadas el día de hoy";
						verificacion <- verificacion+1;
					SiNo
						Escribir "Ingrese las ventas realizadas por zona durante esta jornada";
						llenarMatriz(n,zonas,informacion,ingresoDiarioUser);
						imprimirMatriz(informacion,n,zonas);
						//verificación de la matriz
						Repetir
							Escribir "¿Son correctos los datos ingresados?(si/no)";
							leer verificacionMatriz;
							Si verificacionMatriz = "si" Entonces
								rehacerMatriz <- Falso;
							Sino 
								llenarMatriz(n,zonas,informacion,ingresoDiarioUser);
								imprimirMatriz(informacion,n,zonas);
							FinSi
						Hasta Que rehacerMatriz = Falso
						Escribir "¡Gracias por trabajar con nosotros!";
						verificacion <- verificacion+1;
						llenadoUser<-Verdadero;
					FinSi
				FinSi
			FinSi
		FinSi
	FinMientras
	
	Limpiar Pantalla;
	logo();
	Escribir "¡Gracias por elegir Palta como su plataforma de comida!";
	
FinAlgoritmo



SubProceso  llenarMatriz(n,zonas,informacion por referencia,ingresoDiarioUser)
	Definir i,j,m Como Entero; //Se definen las dimensiones de la matriz//
	Definir nombreZona como caracter; 
	
	//A continuación se muestran las zonas posibles para su consulta//
	
	//Si el vendedor todavía no ingresó datos, se creará una matriz aleatoria
	//que representa los datos del día anterior(simulación base de datos)
	Si ingresoDiarioUser = Falso Entonces
		para i <- 0 hasta n-1 con paso 1 Hacer
			para j <- 0 hasta zonas-1 con paso 1 hacer
				informacion(i,j)<-Aleatorio(0,9);
			FinPara
		FinPara
	SiNo
		Limpiar Pantalla;
		Escribir "Recuerde que no pueden haber más de 10 ventas por zona";
		para i <- 0 hasta n-1 con paso 1 Hacer
			para j <- 0 hasta zonas-1 con paso 1 hacer
				Segun j Hacer
					
					0:nombreZona <- "Norte";
					1:nombreZona <- "Sur";
					2:nombreZona <- "Este";
					3:nombreZona <- "Oeste";
					4:nombreZona <- "Centro";
				FinSegun
				
				Repetir
					Escribir "Introduzca las ventas del vendedor " ,i+1, " en la zona " ,nombreZona; //Mostrar número de ventas de un vendedor por cada zona definida
					Leer m;
					si ConvertirATexto(m) = " " Entonces
						informacion(i,j)<-0;
					SiNo
						informacion(i,j)<-m;
					FinSi
				Hasta Que -1<m y m < 10
			FinPara
		FinPara
	FinSi
	Limpiar Pantalla;
FinSubProceso


Subproceso verificacionAvanceDia(informacion Por Referencia,n,m)
	definir i,j como entero;
	para i<-0 hasta n-1 con paso 1 hacer
		para j<-0 hasta m-1 con paso 1 hacer
			si ConvertirATexto(m) = " " Entonces
				informacion(i,j)<-0;
			FinSi
		finpara
	FinPara
FinSubProceso

SubProceso imprimirMatriz(Matriz,n,m) 
	definir i,j Como Entero;
	Escribir "                N S E O C";
	para i<-0 hasta n-1 con paso 1 hacer
		Escribir "representante " ,i+1, "[" Sin Saltar;
		para j<-0 hasta m-1 con paso 1 hacer
			Escribir Matriz(i,j) Sin Saltar;
			si j<>m-1 Entonces
				Escribir "," Sin Saltar;
			FinSi
		finpara
		Escribir "]";
	FinPara
FinSubProceso

SubProceso copiarMatriz(informacion,matrizDiaAnterior Por Referencia,n,m)
	definir i,j como entero;
	para i<-0 hasta n-1 con paso 1 hacer
		para j<-0 hasta m-1 con paso 1 hacer
			matrizDiaAnterior(i,j) <- informacion(i,j);
		finpara
	FinPara
FinSubProceso


subproceso ventaZona(n,zonas,informacion,decisionVentasZona) //Se define la cantidad de ventas totales por zona//
	definir i,acumuladorVentasZona como enteros;
	Definir nombreZona como caracter;
	acumuladorVentasZona <- 0;
	
	para i <- 0 hasta n-1 con paso 1 hacer
		acumuladorVentasZona <- informacion(i,decisionVentasZona-1) + acumuladorVentasZona;
	FinPara
	
	Segun decisionVentasZona  Hacer
		1:nombreZona <- "Norte";
		2:nombreZona <- "Sur";
		3:nombreZona <- "Este";
		4:nombreZona <- "Oeste";
		5:nombreZona <- "Centro";
	FinSegun
	Escribir "Las ventas de la zona " ,nombreZona, " son " ,acumuladorVentasZona;
	
FinSubProceso



subproceso VentaZonaPorRepresentante(n,zonas,informacion,)
	Definir i como entero; 
	
	para i <-  1 hasta zonas con paso 1 hacer
		ventaZona(n,zonas,informacion,i);
	FinPara
	
FinSubProceso

subproceso VentasRepresentante(n,zonas,informacion,numRepresentante)
	Definir j,VentaRepresentante Como Entero;
	VentaRepresentante <- 0;
	
	para j <-0 hasta zonas-1 con paso 1 hacer
		VentaRepresentante <- informacion(numRepresentante-1,j) + VentaRepresentante;
	FinPara
	
	Escribir "las ventas del representante ", numRepresentante, " son :" 	,VentaRepresentante; // Se muestra como dato de salida el 
	//número de ventas por representante seleccionado//
	
FinSubProceso

subproceso VentaRepresentateXZona(n,zonas,informacion)
	Definir k Como Entero;
	
	Para k <- 1 hasta n con paso 1 Hacer
		
		VentasRepresentante(n,zonas,informacion,k);
		
	FinPara
	
FinSubProceso

subproceso MayorVenta(n,zonas,informacion) //Se define qué vendedor tiene el mayor número de ventas por zona//
	Definir i,j,ventaMayor como entero;
	Definir Vendedor como entero;
	Definir zona como cadena;
	VentaMayor <- -1;
	para i <- 0 hasta n-1 con paso 1 Hacer
		para j <- 0 hasta zonas-1 con paso 1 Hacer
			si ventaMayor < informacion(i,j) Entonces
				ventaMayor <- informacion(i,j);
				Vendedor <- i;
				Segun j Hacer
					0: zona <- "Norte";
					1: zona <- "Sur";
					2: zona <- "Este";
					3: zona <- "oeste";
					4: zona <- "centro";
				FinSegun
			FinSi
		FinPara
	FinPara
	
	Escribir "La mayor venta fue de " ,ventaMayor, " La realizó el vendedor " ,vendedor+1, sin saltar;
	Escribir " En la zona " ,zona;
	
FinSubProceso



SubProceso logo()
	Escribir		"            .::::::::..                                                                     ";
	Escribir		"           .:::::::::::::                                                                   ";
	Escribir		"          ::::::::::::::::                                                                  ";
	Escribir		"         :::::::::::::::::.                                                                 ";
	Escribir		"        .:::::::::::::::::::                               --.                              "; 
	Escribir		"       :::::::::::::::::::::.                              --.  .::.                        "; 
	Escribir 		"      .:::::::::::::::::::::::     ..  .::..      ..:::.   --. .:--:.     .:::..           ";  
	Escribir 		"     .::::::::::.....:::::::::     :---:::---.  .--:..:--. --. .:--::.  :-::..:-:          ";  
	Escribir 		"    :::::   .         .::::::.    :--.    :--   .....:--:  --.  .--.     ....::--           "; 
	Escribir 		"   :-----.    :----:    :----:    :--     :--  :--::..:-:  --.  .--.   :---::..--           "; 
	Escribir 		"   :-----.  .-------:   .----:    :--:...:--:  --:  ..--:  --.   --:.  ---.  .:--           ";
	Escribir 		"   :-----.  :--------   .----:    :--:----:.   .:----::-:  --.   :--.  :-----:--.          ";
	Escribir 		"    -----.   :------.   :----.    :-:                                                       ";
	Escribir 		"     .----.     ....    :----.    :-:                                                      ";
	Escribir 		"      .---.  .:.     .:----:.                                                               ";
	Escribir 		"        .:.  .------------.                                                                 ";
	Escribir 		"             .--------:.                                                                    ";  
	Escribir		"                 ...                                                                         ";
FinSubProceso


