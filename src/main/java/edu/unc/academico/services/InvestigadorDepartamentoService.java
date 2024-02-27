package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;

public interface InvestigadorDepartamentoService {
	public Investigador replaceDpto(Long idInvestigador, Long idDepartamento);
	public void removeDpto(Long idInvestigador);
}
