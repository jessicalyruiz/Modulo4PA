package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.IEstudianteRepo;
import ec.edu.uce.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired 
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void create(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.create(estudiante);
	}

	@Override
	public Estudiante read(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.read(id);
	}

	@Override
	public void update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepo.update(estudiante);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepo.delete(id);
	}

	@Override
	public List<Estudiante> buscarTodos() {
		// TODO Auto-generated method stub
		return this.estudianteRepo.buscarTodos();
	}
	
}
