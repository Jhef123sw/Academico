package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import edu.unc.academico.domain.Departamento;

public interface DepartamentoService {
	//Esto es una interfaz
	List<Departamento> listaDto();
	Optional<Departamento> buscarPorIdDpto(Long idDpto);
	Departamento gabarDepartamento(Departamento dpto);
	void eliminarDpto(Long idDpto);
}
