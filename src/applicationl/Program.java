package applicationl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[]args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new   SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Numero do quarto");
		int numero = sc.nextInt();
		System.out.println("data de entrada(dd/MM/yyyy):");
		Date entrada = sdf.parse(sc.next());
		System.out.println("data de saida(dd/MM/yyyy):");
		Date saida = sdf.parse(sc.next());
		
		//testando se a data de saidda nao é antes da de entrada
		if (!saida.after(entrada)) {
			System.out.println("Erro na reserva ,a data de saida nao pode ser antes da data de entrada");
		}else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reserva"+reserva);
			//fzendo a atualizacao das datas
			System.out.println();
			System.out.println("Entre com os dados para atualizar as reservas");
			
			System.out.println("data de entrada(dd/MM/yyyy):");
			entrada = sdf.parse(sc.next());
			System.out.println("data de saida(dd/MM/yyyy):");
			saida = sdf.parse(sc.next());
			//tratando atualizacao das datas
			Date now = new Date();
			if(entrada.before(now) ||saida.before(now)) {
				System.out.println("Erro na reserva ,a data de saida nao pode ser antes da data de entrada");
				
			}
			else if (!saida.after(entrada)) {
				System.out.println("Erro na reserva ,a data de saida nao pode ser antes da data de entrada");

				
			}else {
				reserva.dataDeAtualizacao(entrada, saida);
				System.out.println("Reserva"+reserva);
			}	
			}
			
		sc.close();
	}
}
