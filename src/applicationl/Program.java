package applicationl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DominioException;

public class Program {

	public static void main(String[]args)  {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new   SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do quarto");
			int numero = sc.nextInt();
			System.out.println("data de entrada(dd/MM/yyyy):");
			Date entrada = sdf.parse(sc.next());
			System.out.println("data de saida(dd/MM/yyyy):");
			Date saida = sdf.parse(sc.next());
			
		
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva"+reserva);
			//fzendo a atualizacao das datas
			System.out.println();
			System.out.println("Entre com os dados para atualizar as reservas");
			
			System.out.println("data de entrada(dd/MM/yyyy):");
			entrada = sdf.parse(sc.next());
			System.out.println("data de saida(dd/MM/yyyy):");
			saida = sdf.parse(sc.next());
		
		    reserva.dataDeAtualizacao(entrada, saida);
			 System.out.println("erro na Reserva:" +reserva);
				
			}
		catch(ParseException e) {
			System.out.println("Por favor digite uma data valida");
		}
		catch(DominioException e) {
			System.out.println("Erro na reserva:" + e.getMessage());
		}
	   catch(RuntimeException e) {
		   System.out.println("erro inesperado");
	   }
		sc.close();
	}
}
