package ec.edu.uce.paralelo.hilos;

import java.util.concurrent.TimeUnit;

public class GestorAtencion {

	public void procesar(Cajero cajero, long tiempoInicial) {
		System.out.println("inicia atender el cajero "+cajero.getNombre());
		for (Integer tiempo : cajero.getClientes()) {
			this.atenderCliente(tiempo);
			
		}
		System.out.println("finaliza atender el cajero "+cajero.getNombre());
		long tiempoTranscurrido=(System.currentTimeMillis()- tiempoInicial)/1000;
		
		System.out.println("tiempoTranscurrido "+tiempoTranscurrido);
	}
	
	private void atenderCliente(Integer tiempo) {
		System.out.println("Atendiendo a cliente: "+tiempo);
		System.out.println("hilo "+ Thread.currentThread().getName());
		try {
			//se demora en la atencion
			TimeUnit.SECONDS.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
