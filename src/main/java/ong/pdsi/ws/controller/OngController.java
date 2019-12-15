package ong.pdsi.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ong.pdsi.business.service.OngService;
import ong.pdsi.domain.ong.Ong;
import ong.pdsi.ws.validator.OngValidator;

@RestController
@RequestMapping("/api/ongs")
public class OngController {
		
	@Autowired
	private OngService ongService;

	@GetMapping
	public ResponseEntity<List<Ong>> getAllOngs() {
		return ResponseEntity.ok(ongService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Ong> createOng(@RequestBody Ong ong) {
		OngValidator.validateCreateOng(ong);
		return ResponseEntity.ok(ongService.createOng(ong));
	}
	
	@PutMapping
	public ResponseEntity<Ong> updateOng(@RequestBody Ong ong) {
		return ResponseEntity.ok(ongService.updateOng(ong));
	}
	
	@DeleteMapping
	public void deleteOng(@RequestBody Ong ong) {
		ongService.deleteOng(ong.getId());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ong> getOngById(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(ongService.getOngById(id));
	}
}