package ec.edu.uce;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import ec.edu.uce.service.IProcesamientoFacultadService;
import ec.edu.uce.service.ProcesamientoFacultadServiceImpl;
//matriculacion
@SpringBootApplication
@EnableAsync //
public class PaWebU4Application  implements CommandLineRunner{
	private static final Logger LOG=LoggerFactory.getLogger(ProcesamientoFacultadServiceImpl.class);

	@Autowired
	private IProcesamientoFacultadService facultadService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PaWebU4Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		long inicio=System.currentTimeMillis();
		//procesamiento Asincrono sin manejo de respuesta por cada hilo
//	Integer valor1 =this.facultadService.calcularDeuda("21313",3);
//	Integer valor2 =this.facultadService.calcularDeuda("78945",6);
//	Integer valor3 =this.facultadService.calcularDeuda("7891",3);
//	Integer valor4 =this.facultadService.calcularDeuda("96423",3);
//	LOG.info("valor1: "+valor1);
	
		//procesamiento Asincrono con manejo de respuesta por cada hilo
		CompletableFuture<Integer> valor1 =this.facultadService.calcularDeudaFuture("21313",3);
		CompletableFuture<Integer> valor2 =this.facultadService.calcularDeudaFuture("78945",6);
		CompletableFuture<Integer> valor3 =this.facultadService.calcularDeudaFuture("7891",3);
		CompletableFuture<Integer> valor4 =this.facultadService.calcularDeudaFuture("96423",3);

	//esperar a que se preocesen todos los hilos
		//sentencia que termina de procesar los hilos 
		CompletableFuture.allOf(valor1,valor2,valor3,valor4).join();
		
		LOG.info("Valor Total: "+ (valor1.get()+valor2.get()+valor3.get()+valor4.get()));
	long tiempoFinal=System.currentTimeMillis();
	LOG.info("TiempoTranscurrido: "+(System.currentTimeMillis()-inicio)/1000);
	}
}
