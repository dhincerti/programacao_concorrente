package br.com.bruno.etapa2.service;

import static br.com.bruno.etapa2.common.Constantes.CONSUMIDOR_SLEEP_TIME;
import static br.com.bruno.etapa2.common.Constantes.TABELACAO;

import org.apache.log4j.Logger;

import br.com.bruno.etapa2.controller.Buffer;

public class Consumidor implements Runnable {

	public static final Logger LOGGER = Logger.getLogger(Consumidor.class);

	private final Buffer buffer;

	private long startDate;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
	}

	public Consumidor(Buffer buffer, long startDate) {
		this.buffer = buffer;
		this.startDate = startDate;
	}

	public void run() {
		final Thread currentThread = Thread.currentThread();
		final String loggerPreMassage = "THREAD CONSUMIDORA [" + currentThread.getId() + "]" + TABELACAO;

		LOGGER.info(loggerPreMassage + "START");

		while (System.currentTimeMillis() < startDate + 10000) {

			buffer.removePedido();

			try {
				Thread.sleep(CONSUMIDOR_SLEEP_TIME);
			} catch (final InterruptedException e) {
				LOGGER.trace("Falha ao tentar colocar a thread para dormir ", e);
			}

		}

		currentThread.interrupt();
	}
}
