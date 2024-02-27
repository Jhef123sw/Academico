package edu.unc.academico.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.services.InvestigadorService;


@RestController
@RequestMapping("api/v1/investigadores")
public class InvestigadorController {
	
	@Autowired
	private InvestigadorService invService;
	
	
	@GetMapping
	public List<Investigador> listarInvestigadores() {
		return invService.listaInv();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorInv(@PathVariable Long id) {
		Optional<Investigador> invOptional = invService.buscarPorIdInv(id);
		if(invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	private ResponseEntity<?> crearInv(@RequestBody Investigador inv) {
		// TODO Auto-generated method stub
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.gabarInv(inv));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarInv(@PathVariable Long id, @RequestBody Investigador inv){
		Optional<Investigador> o = invService.buscarPorIdInv(id);
		if(o.isPresent()) {
			Investigador invDB = o.get();
			
			invDB.setApeMat(inv.getApeMat());
			invDB.setApePat(inv.getApePat());
			invDB.setEmail(inv.getEmail());
			invDB.setFechaNac(inv.getFechaNac());
			invDB.setDepartamento(inv.getDepartamento());
			
			
			
			
			return ResponseEntity.status(HttpStatus.CREATED).body(invService.gabarInv(invDB));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> eliminarInv(@PathVariable Long id) {
		// TODO Auto-generated method stub
		Optional<Investigador> o = invService.buscarPorIdInv(id);
		if(o.isPresent()) {
			invService.eliminarInv(id);
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
