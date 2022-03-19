package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

import ec.edu.uce.paralelo.hilos.Cajero;

public class GestorAtencionHilos extends Thread{

	private CajeroHilo cajero;
	private long tiempoInicial;
	
	
	
	

	public GestorAtencionHilos(CajeroHilo cajero, long tiempoInicial) {
		super();
		this.cajero = cajero;
		this.tiempoInicial = tiempoInicial;
	}

	//sobreescribir el metodo run
	@Override
	public void run() {
		this.procesar(this.cajero, this.tiempoInicial);
	}
	
	public void procesar(CajeroHilo cajero, long tiempoInicial) {
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
