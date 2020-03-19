package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public Date getEntrada() {
		return entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	//método que retorna dia hora e minutos de entrada e saida
	public long duracao() {
		long diff=entrada.getTime() - saida.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	//metodo que atualiza
	public String dataDeAtualizacao(Date entrada,Date saida) {
		//data de agora
		Date now = new Date();
		if(entrada.before(now) ||saida.before(now)) {
			return "Erro na reserva ,a data de reserva tem que ser futura";	
		}
		 if (!saida.after(entrada)) {
			return "Erro na reserva ,a data de saida nao pode ser antes da data de entrada";
		}
		this.entrada=entrada;
		this.saida=saida;
		return null;
	}
	
@Override
public String toString() {
	return "quarto"
			+numeroQuarto
			+",entrada: "
			+sdf.format(entrada)
			+"saida: "
			+sdf.format(saida)
			+" ,"
			+duracao()
			+",noites";
}
}
