package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.repository.modelo.Estudiante;

public interface IEstudianteService {

	public void create(Estudiante estudiante);
	public Estudiante read(Integer id); 
	public void update(Estudiante estudiante); 
	public void delete(Integer id); 
	public List<Estudiante> buscarTodos();
}
