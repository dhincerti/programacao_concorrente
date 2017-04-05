package br.com.bruno.etapa2;

import static br.com.bruno.etapa2.common.Constantes.CONSUMIDOR_SLEEP_TIME;
import static br.com.bruno.etapa2.common.Constantes.EXECUTION_MAX_TIME;
import static br.com.bruno.etapa2.common.Constantes.MAXIMO_DE_PEDIDOS;
import static br.com.bruno.etapa2.common.Constantes.PRODUTOR_SLEEP_TIME;
import static br.com.bruno.etapa2.common.Constantes.QUANTIDADE_DE_THREADS;
import static br.com.bruno.etapa2.common.Constantes.TABELACAO;

import org.apache.log4j.Logger;

import br.com.bruno.etapa2.controller.Buffer;
import br.com.bruno.etapa2.service.Consumidor;
import br.com.bruno.etapa2.service.Produtor;

public class Principal {

	public static final Logger LOGGER = Logger.getLogger(Consumidor.class);

	private Principal() {
		super();
	}

	public static void main(String[] args) {

		LOGGER.info("####  INICIO DA APLICAÇÂO  ####");
		LOGGER.info("MAXIMO_DE_PEDIDOS: " + TABELACAO + MAXIMO_DE_PEDIDOS);
		LOGGER.info("QUANTIDADE_DE_THREADS: " + TABELACAO + QUANTIDADE_DE_THREADS);
		LOGGER.info("CONSUMIDOR_SLEEP_TIME: " + TABELACAO + CONSUMIDOR_SLEEP_TIME);
		LOGGER.info("PRODUTOR_SLEEP_TIME: " + TABELACAO + PRODUTOR_SLEEP_TIME);
		LOGGER.info("EXECUTION_MAX_TIME: " + TABELACAO + EXECUTION_MAX_TIME);
		LOGGER.info("###############################\n\n");

		final long startDate = System.currentTimeMillis();

		final Buffer buffer = new Buffer();
		final Produtor produtor = new Produtor(buffer, startDate);
		final Consumidor consumir = new Consumidor(buffer, startDate);

		for (int i = 1; i <= QUANTIDADE_DE_THREADS; i++) {

			final Thread threadProdutora = new Thread(produtor);
			final Thread threadConsumidora = new Thread(consumir);

			threadProdutora.start();
			threadConsumidora.start();

		}

		LOGGER.info("####  FIM DA APLICAÇÂO  ####");
	}
}
