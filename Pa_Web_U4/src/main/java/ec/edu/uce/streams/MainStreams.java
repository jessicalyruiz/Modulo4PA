package ec.edu.uce.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MainStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicio=System.currentTimeMillis();
		List<Integer> lista=new ArrayList<>();
		for (int i=0; i<10000;i++) {
			lista.add(i);
		}
		List<String>listaNumLetras= lista.parallelStream().map(n->convertirNum(n)).collect(Collectors.toList());
		listaNumLetras.forEach(System.out::println);
		System.out.println("Tiempo total: "+ (System.currentTimeMillis()-tiempoInicio)/1000);
		
	}
	private static String convertirNum(Integer num) {
		System.out.println(Thread.currentThread().getName());
		
		try {
			TimeUnit.MILLISECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "N: " + num.toString();
	}

}
