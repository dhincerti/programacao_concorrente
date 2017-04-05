package br.com.bruno.etapa2.common;

public class Constantes {

	public static final int MAXIMO_DE_PEDIDOS = 5000;
	public static final int QUANTIDADE_DE_THREADS = 1000;
	public static final int CONSUMIDOR_SLEEP_TIME = 2000;
	//public static final int PRODUTOR_SLEEP_TIME = CONSUMIDOR_SLEEP_TIME / 2;
	public static final int PRODUTOR_SLEEP_TIME = CONSUMIDOR_SLEEP_TIME;
	public static final String TABELACAO = " \t ==> \t";

	private Constantes() {
		super();
	}
}
