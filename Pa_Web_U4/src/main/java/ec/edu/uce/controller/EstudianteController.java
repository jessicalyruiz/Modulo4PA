package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes") //mappear la url en el controlador nombre: /nombreEnPlural del recurso
public class EstudianteController {

	@Autowired
	private IEstudianteService estudianteService;
	
	@RequestMapping("/buscar/{idEstudiante}") //poner que recurso voy a buscar (el id)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
	Estudiante estudiant=this.estudianteService.read(idEstudiante);
//		estudiant.setApellido("Yanez");
//		estudiant.setNombre("Jessi");
		modelo.addAttribute("estu", estudiant);
		
		return "estudiante"; //\siempre debe retornar un string con el nombre de la VISTA (a el archivo de la vista)
		
	}
}
