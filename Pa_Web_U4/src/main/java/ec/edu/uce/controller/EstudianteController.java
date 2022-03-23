package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes") //mappear la url en el controlador nombre: /nombreEnPlural del recurso
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	
	//@RequestMapping("/buscar/{idEstudiante}") //poner que recurso voy a buscar (el id)
	@GetMapping("/buscar/{idEstudiante}") //anotacon para simplificar
	//@RequestMapping(path="/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
	Estudiante estudiant=this.estudianteService.read(idEstudiante);
//		estudiant.setApellido("Yanez");
//		estudiant.setNombre("Jessi");
		modelo.addAttribute("estu", estudiant);
		
		return "estudiante"; //\siempre debe retornar un string con el nombre de la VISTA (a el archivo de la vista)
		
	}
	
	@GetMapping("/buscar/todos")
	public String buscarTodos(Model modelo) {
		List<Estudiante> listaEst=this.estudianteService.buscarTodos();
		modelo.addAttribute("estudiantes", listaEst); //el que esta entre comillas es el nombre para llamarle en la vista html
		return "listaEstudiantes";
		
	}
	@GetMapping("/estudianteNuevo")
	public String obtenerPaginaIngresoDatos() {
		return "estudianteNuevo";
		
	}
	
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudianteRecibido, BindingResult resut, Model modelo){
		this.estudianteService.create(estudianteRecibido);
		return "listaEstudiantes";
	}
	
	
	
}
