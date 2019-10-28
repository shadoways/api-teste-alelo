package br.com.teste.alelo.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.alelo.exception.EstabelecimentoNotFoundException;
import br.com.teste.alelo.model.Estabelecimento;
import br.com.teste.alelo.repository.EstabelecimentoRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("rest/v1")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@PostMapping("/estabelecimento")
	public Estabelecimento saveEstabelecimento(@RequestBody Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	@PutMapping("/estabelecimento/{id}")
	public Estabelecimento updateEstabelecimento(@RequestBody Estabelecimento estabelecimento, @PathVariable Long id) {

		return estabelecimentoRepository.findById(id).map(estab -> {
			estab.setAvaliacao(estabelecimento.getAvaliacao() == null ? estab.getAvaliacao() : estabelecimento.getAvaliacao());
			estab.setCozinha(estabelecimento.getCozinha() == null ? estab.getCozinha() : estabelecimento.getCozinha());
			estab.setRazaoSocial(estabelecimento.getRazaoSocial() == null ? estab.getRazaoSocial() : estabelecimento.getRazaoSocial());
			estab.setDtCadastro(new Date());
			estab.setEndereco(estabelecimento.getEndereco() == null ? estab.getEndereco() : estabelecimento.getEndereco());
			return estabelecimentoRepository.save(estab);
		}).orElseGet(() -> {
			estabelecimento.setId(id);
			return estabelecimentoRepository.save(estabelecimento);
		});

	}

	@GetMapping("/estabelecimento/{id}")
	public Estabelecimento getEstabelecimento(@PathVariable Long id) {
		return estabelecimentoRepository.findById(id).orElseThrow(() -> new EstabelecimentoNotFoundException(id));
	}

	@GetMapping("/estabelecimento")
	public List<Estabelecimento> getAllEstabelecimento() {
		return estabelecimentoRepository.findAll();
	}

	@DeleteMapping("/estabelecimento/{id}")
	public void deleteEstabelecimento(@PathVariable Long id) {
		estabelecimentoRepository.deleteById(id);
	}
}
