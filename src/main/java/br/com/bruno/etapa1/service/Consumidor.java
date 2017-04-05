package br.com.bruno.etapa1.service;

import br.com.bruno.etapa1.common.Constantes;
import br.com.bruno.etapa1.controller.Buffer;
import org.apache.log4j.Logger;

public class Consumidor implements Runnable{
	
	Logger logConsumidor = Logger.getLogger(Consumidor.class);

    private Buffer buffer;
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
    	
    	logConsumidor.info(String.format("INICIOU THREAD"+" "+Thread.currentThread().getId()));
        
        while(buffer.getNext()){
            try {
            	Integer numPedido = buffer.getPedido();
                long idThread = Thread.currentThread().getId();
                logConsumidor.info(String.format("THREAD: "+idThread + " ==> CONSUMIU PEDIDO: "+ numPedido));
                Thread.sleep(Constantes.timeThread);
            } catch (InterruptedException ex) {
            	ex.printStackTrace();
            }
        }
        
        Thread.currentThread().interrupt();  
        	logConsumidor.info(String.format("TERMINOU THREAD"+" "+Thread.currentThread().getId()));       
    }    	
}
