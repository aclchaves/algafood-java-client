package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.RestauranteModel;
import com.algaworks.algafood.client.model.input.CidadeInput;
import com.algaworks.algafood.client.model.input.CozinhaInput;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;

public class InclusaoRestauranteMain {
	
	public static void main(String[] args) {
		
		try {
			
			var restTemplate = new RestTemplate();
			
			String url = "http://localhost:8080";			
			
			var restauranteClient = new RestauranteClient(
					restTemplate, url);
			
			var cozinha = new CozinhaInput();
			cozinha.setId(1L);
			
			var cidade = new CidadeInput();
			cidade.setId(2L);
			
			var endereco = new EnderecoInput();
			endereco.setCidade(cidade);
			endereco.setLogradouro("Rua xyz");
			endereco.setBairro("Fundinho");
			endereco.setNumero("1020");
			endereco.setCep("38500-111");
			
			var restauranteInput = new RestauranteInput();
			restauranteInput.setNome("Mexicali");
			restauranteInput.setTaxaFrete(new BigDecimal(10));
			restauranteInput.setCozinha(cozinha);
			restauranteInput.setEndereco(endereco);
			
			RestauranteModel restaurante = restauranteClient.adicionar(restauranteInput);
			
			System.out.println(restaurante);
			
		} catch (ClientApiException e) {
			if(e.getProblem() != null) {
				//System.out.println(e.getProblem());
				System.out.println(e.getProblem().getUserMessage());
				
				e.getProblem().getObjects().stream()
					.forEach(p -> System.out.println("- " + p.getUserMessage()));
			}else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
		
	}

}
