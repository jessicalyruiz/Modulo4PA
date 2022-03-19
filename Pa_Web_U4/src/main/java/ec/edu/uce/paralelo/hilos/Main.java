package ec.edu.uce.paralelo.hilos;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial=System.currentTimeMillis();
		
		Cajero cajero=new Cajero("Jessica", Arrays.asList(2,2,4,5));
		
		Cajero cajero2=new Cajero("Lorena", Arrays.asList(1,2,1,3));
		
		Cajero cajero3=new Cajero("Andres", Arrays.asList(3,2,3,8));
		
		GestorAtencion gestor=new GestorAtencion();
		GestorAtencion gestor2=new GestorAtencion();
		GestorAtencion gestor3=new GestorAtencion();
		
		gestor.procesar(cajero,tiempoInicial );
		gestor2.procesar(cajero2,tiempoInicial);
		gestor3.procesar(cajero3,tiempoInicial);
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println("tiempoTranscurrido "+tiempoTranscurrido);
		
		
		System.out.println("hilos/-----");
	}

}
