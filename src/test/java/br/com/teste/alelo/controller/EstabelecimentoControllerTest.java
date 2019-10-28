package br.com.teste.alelo.controller;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.teste.alelo.model.Estabelecimento;
import br.com.teste.alelo.repository.EstabelecimentoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EstabelecimentoControllerTest {
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void beforeEachTest() {
		reset(this.estabelecimentoRepository);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findAllEstabelecimento() throws Exception {
		final Estabelecimento estab1 = new Estabelecimento();
		estab1.setId(1l);
		estab1.setCozinha("FastFood");
		estab1.setDtCadastro(new Date());
		estab1.setEndereco("Rua 13 de Maio");
		estab1.setRazaoSocial("Pizzaria");
		estab1.setAvaliacao(4);

		final Estabelecimento estab2 = new Estabelecimento();
		estab1.setId(1l);
		estab1.setCozinha("Mexicano");
		estab1.setDtCadastro(new Date());
		estab1.setEndereco("Rua 13 de Maio, 123");
		estab1.setRazaoSocial("Sin Señor");
		estab1.setAvaliacao(3);

		when(estabelecimentoRepository.findAll())
				.thenReturn((List<Estabelecimento>) Arrays.asList(estab1, estab2).iterator());

		this.mockMvc.perform(get("/rest/avarias")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$").isArray()).andExpect(jsonPath("$.[0].id").value(1))
				.andExpect(jsonPath("$.[0].cozinha").value("FastFood"))
				.andExpect(jsonPath("$.[0].avaliacao").value(4))
				.andExpect(jsonPath("$.[0].endereco").value("Rua 13 de Maio"))
				.andExpect(jsonPath("$.[0].razaoSocial").value("Pizzaria"))
				.andExpect(jsonPath("$.[1].id").value(2))
				.andExpect(jsonPath("$.[1].cozinha").value("Mexicano"))
				.andExpect(jsonPath("$.[1].avaliacao").value(3))
				.andExpect(jsonPath("$.[1].endereco").value("Rua 13 de Maio, 123"))
				.andExpect(jsonPath("$.[1].razaoSocial").value("Sin Señor"));
	}

}
