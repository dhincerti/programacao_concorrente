package br.com.bruno.etapa2.controller;

import static br.com.bruno.etapa2.common.Constantes.MAXIMO_DE_PEDIDOS;
import static br.com.bruno.etapa2.common.Constantes.TABELACAO;

import java.util.LinkedList;

import org.apache.log4j.Logger;

public class Buffer {

	private static final Logger LOGGER = Logger.getLogger(Buffer.class);

	private final LinkedList<Integer> pedidos = new LinkedList<Integer>();
	private Integer proximoPedido = 0;

	public Buffer() {
		super();
	}

	public synchronized void addPedido() {

		final Thread currentThread = Thread.currentThread();
		final String loggerPreMassage = "THREAD PRODUTORA [" + currentThread.getId() + "]" + TABELACAO;

		while (pedidos.size() == MAXIMO_DE_PEDIDOS) {
			try {
				LOGGER.info(loggerPreMassage + "Atingiu o limite máximo de pedidos");
				wait();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}

		proximoPedido++;
		pedidos.add(proximoPedido);
		LOGGER.info(loggerPreMassage + "Produziu o pedido: " + proximoPedido);

		notify();
	}

	public synchronized Integer removePedido() {
		final Thread currentThread = Thread.currentThread();
		final String loggerPreMassage = "THREAD CONSUMIDORA [" + currentThread.getId() + "]" + TABELACAO;

		while (pedidos.size() == 0) {
			try {
				LOGGER.info(loggerPreMassage + "Não encontrou pedido");
				wait();
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
		}

		final Integer poll = pedidos.poll();
		LOGGER.info(loggerPreMassage + "Consumiu o pedido: " + poll);
		notify();

		return poll;
	}

}
