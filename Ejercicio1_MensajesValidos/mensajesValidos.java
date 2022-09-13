package mensajesValidos;

/*
 * Caracteres validos en los mensajes:
 * p q r s t u v w x y z  (pueden ir solas)
 * 
 * junto con las mayúsculas:
 * N C D E I
 * 
 * Cada caracter de la p a la z forma un mensaje correcto
 * 
 * si s es un mensaje correcto, entonces tambien lo es Ns
 * 
 * si s y t son mensajes correctos, tambien lo son Cst, Dst, Est, Ist
 * 
 */

import java.util.Arrays;
import java.util.Scanner;


public class mensajesValidos {
		
	public static void main(String args[]) {
		
			Scanner teclado = new Scanner(System.in);
			
			while(teclado.hasNext()){	
				String mensaje = teclado.nextLine();
			
				System.out.println(funcion(mensaje));
			}
			
	}
		
		public static String funcion(String mensaje) {
			
			char[] arrayMensaje = mensaje.toCharArray();
			boolean comprueba = compruebaValido(arrayMensaje);
			String respuesta;
			
			if(comprueba == true) {
				respuesta = "Sí";
				return respuesta;
			}
			else {
				respuesta = "No";
				return respuesta;
			}
			
		}
		
		public static boolean compruebaValido(char[] arrayMensaje) {
			
			try {
			
				if((arrayMensaje.length == 1) && ((arrayMensaje[0] >= 'p') && (arrayMensaje[0] <= 'z'))) {  //Regla 2

					return true;	
				}
				
				else if(arrayMensaje[0] == 'N'){ //Regla 3
				
						return compruebaValido(Arrays.copyOfRange(arrayMensaje, 1, arrayMensaje.length));
						
				}else if((arrayMensaje[0] == 'C') || (arrayMensaje[0] == 'D') || (arrayMensaje[0] == 'E') || (arrayMensaje[0] == 'I')){ //Regla 4
			
						int divIndice = -1;
						
						//Bucle compruebo los limites de la cadena
						
						String aux = "";
						for (int i = 1; i < arrayMensaje.length; i++) {
							
							aux += arrayMensaje[i];
							if(compruebaValido(aux.toCharArray())) {
								divIndice = i;
								break;
							}
						}
						//No hay mensaje valido
						if(divIndice == -1) {
							return false;
						}
						else {
							//Hay mensaje valido
							return compruebaValido(Arrays.copyOfRange(arrayMensaje, divIndice + 1, arrayMensaje.length));
						}
				}
			}catch(Exception e){
				return false;
			}
				
			return false;

		}

}
