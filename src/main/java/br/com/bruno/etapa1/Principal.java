package br.com.bruno.etapa1;

import br.com.bruno.etapa1.common.Constantes;
import br.com.bruno.etapa1.controller.Buffer;
import br.com.bruno.etapa1.service.Consumidor;
import org.apache.log4j.Logger;

public class Principal {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		Consumidor Consumir = new Consumidor(buffer);

		buffer.addPedido(Constantes.qtdPedidos);
		
		Logger logMain = Logger.getLogger(Principal.class);
		logMain.info(String.format("####  INICIA SISTEMA  ####"));

		for (int i = 1; i <= Constantes.qtdThreads; i++) {
            Thread t = new Thread(Consumir);
            t.start();
        }		
	}
}
