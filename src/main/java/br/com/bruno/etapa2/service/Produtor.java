package br.com.bruno.etapa2.service;

import static br.com.bruno.etapa2.common.Constantes.EXECUTION_MAX_TIME;
import static br.com.bruno.etapa2.common.Constantes.PRODUTOR_SLEEP_TIME;
import static br.com.bruno.etapa2.common.Constantes.TABELACAO;

import org.apache.log4j.Logger;

import br.com.bruno.etapa2.controller.Buffer;

public class Produtor implements Runnable {

	public static final Logger LOGGER = Logger.getLogger(Consumidor.class);

	private final Buffer buffer;
	private long startDate;

	public Produtor(Buffer buffer) {
		this.buffer = buffer;
	}

	public Produtor(Buffer buffer, long startDate) {
		this.buffer = buffer;
		this.startDate = startDate;
	}

	public void run() {
		final Thread currentThread = Thread.currentThread();
		final String loggerPreMassage = "THREAD PRODUTORA [" + currentThread.getId() + "]" + TABELACAO;

		LOGGER.info(loggerPreMassage + "START");

		while (System.currentTimeMillis() < startDate + EXECUTION_MAX_TIME) {

			buffer.addPedido();

			try {
				Thread.sleep(PRODUTOR_SLEEP_TIME);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}

		}

		currentThread.interrupt();
	}
}
