package br.com.bruno.etapa1.controller;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Buffer {
	
	public ConcurrentLinkedQueue<Integer> pedidos;
	
	public Buffer() {
		pedidos = new ConcurrentLinkedQueue<Integer>();	
	}
	
	public void addPedido(int qtdPedidos) {
		for(int i = 1; i<=qtdPedidos; i++){
		pedidos.add(i);
		}
	}
	
	public ConcurrentLinkedQueue<Integer> retornaPedidos(){
		return pedidos;
	}
	
	public Integer getPedido(){
		Integer retorno = pedidos.poll();		
		return retorno;
	}
	
	public boolean getNext() {
        return (!this.pedidos.isEmpty());
    }
}
