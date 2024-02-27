package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.repository.DepartamentoRepository;


@Service
public class DepartamentoServiceImp implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository dptoRep;
	
	@Override
	public List<Departamento> listaDto() {
		// TODO Auto-generated method stub
		return (List<Departamento>) dptoRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Departamento> buscarPorIdDpto(Long idDpto) {
		// TODO Auto-generated method stub
		return dptoRep.findById(idDpto);
	}

	@Override
	public Departamento gabarDepartamento(Departamento dpto) {
		// TODO Auto-generated method stub
		return dptoRep.save(dpto);
	}

	@Override
	public void eliminarDpto(Long idDpto) {
		// TODO Auto-generated method stub
		dptoRep.deleteById(idDpto);
	}

}
