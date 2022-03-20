package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultadService;
import ec.edu.uce.service.ProcesamientoFacultadServiceImpl;
//matriculacion
@SpringBootApplication
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
	Integer valor1 =this.facultadService.calcularDeuda("21313",3);
	Integer valor2 =this.facultadService.calcularDeuda("78945",6);
	Integer valor3 =this.facultadService.calcularDeuda("7891",3);
	Integer valor4 =this.facultadService.calcularDeuda("96423",3);
	LOG.info("Total"+ (valor1+valor2+valor3+valor4));
	
	long tiempoFinal=System.currentTimeMillis();
	LOG.info("TiempoTranscurrido: "+(System.currentTimeMillis()-inicio)/1000);
	}
}
