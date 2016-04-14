package menuCadenas;

/*
Menú: 
1.­ Introducir cadena. 
2.­ Listar cadenas. 
3.­ Eliminar cadena. 
4.­ Eliminar todas las cadenas. 
5.­ Salir.
*/

import java.util.Scanner;

public class MenuCadenas
{
	
	public static void main(String[] args)
	{
		int numElementos = 0;
		final int TAM = 8;
		Scanner sc = new Scanner(System.in);
		String[] cadenas = new String[TAM];
		String opcion = "0";
		String aux;
		boolean repetido;
		while(!opcion.equals("5"))
		{
			System.out.println("1.-Introducir cadena.\n" +
							   "2.-Listar cadenas.\n" +
							   "3.-Eliminar cadena.\n" +
							   "4.-Eliminar todas las cadenas.\n"+
							   "5.-Salir");
			opcion = sc.nextLine();
			switch(opcion)
			{
				case "1": // Introducir cadena
					if(numElementos == TAM)
					{
						System.out.println("Lista llena, borre antes una cadena.");
					}
					else
					{
						System.out.print("Introduce cadena: ");
						aux = sc.nextLine();
						int i = 0;
						repetido = false;
						while(cadenas[i] != null && !repetido)
						{
							if(aux.equals(cadenas[i]))
							{							
								repetido = true;
							}
							else
							{
								i++;
							}
						}						
						if(cadenas[i] == null)
						{
							cadenas[i] = aux;
							numElementos++;
						}
						else if(repetido)
						{
							System.out.println("Ya existe.");
						}
					}
				break;
				case "2": // Listar
					for(int i = 0; i < numElementos; i++)
					{
						System.out.println(cadenas[i]);
					}
				break;
				case "3": // ELiminar cadena
					if(numElementos != 0)
					{
						System.out.print("Introduzca cadena: ");
						aux = sc.nextLine();
						int i = 0;
						while(!aux.equals(cadenas[i]) && i < numElementos)
						{
							i++;
						}
						if(aux.equals(cadenas[i]))
						{
							while(i < numElementos - 1)
							{						
								cadenas[i] = cadenas[i + 1];
								i++;
							}
							numElementos--;
							cadenas[i] = null;
						}	
						else
						{
							System.out.println("No existe.");
						}
					}
					else
					{
						System.out.println("Lista vacía.");
					}
				break;
				case "4": // Eliminar todos
					for(int i = 0; i < numElementos; i++)
					{
						cadenas[i] =  null;
					}					
					numElementos = 0;
				break;
				case "5": // Salir
				break;
				default:
					System.out.println("Opción no válida.");
					break;
			}

		}
		sc.close();
		
	}
}

