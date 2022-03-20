package ec.edu.uce.paralelo.hilos.paralelo;

import java.util.Arrays;

import ec.edu.uce.paralelo.hilos.Cajero;
import ec.edu.uce.paralelo.hilos.GestorAtencion;

public class MainHilo {

	public static void main(String[] args) {
long tiempoInicial=System.currentTimeMillis();
		
		CajeroHilo cajero=new CajeroHilo("Jessica", Arrays.asList(2,2,4,5));
		
		CajeroHilo cajero2=new CajeroHilo("Lorena", Arrays.asList(1,2,1,3));
		
		CajeroHilo cajero3=new CajeroHilo("Andres", Arrays.asList(3,2,3,8));
		
		
		System.out.println("Hilo proncipal: "+Thread.currentThread().getName());
		GestorAtencionHilos gestor=new GestorAtencionHilos(cajero,tiempoInicial);
		GestorAtencionHilos gestor2=new GestorAtencionHilos(cajero2,tiempoInicial);
		GestorAtencionHilos gestor3=new GestorAtencionHilos(cajero3,tiempoInicial);
		
		gestor.start();//procesar
		gestor2.start();
		gestor3.start();
		

		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido=(tiempoFinal-tiempoInicial)/1000;
		
		System.out.println("tiempoTranscurrido "+tiempoTranscurrido);
		System.out.println("Hilo proncipal: "+Thread.currentThread().getName());
		
		System.out.println("termino----");
	}

}
