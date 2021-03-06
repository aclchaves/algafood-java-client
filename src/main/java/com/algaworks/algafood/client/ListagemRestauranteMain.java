package com.algaworks.algafood.client;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;

public class ListagemRestauranteMain {
	
	public static void main(String[] args) {		
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
			String url = "http://localhost:8080";			
			
			RestauranteClient restauranteClient = 
					new RestauranteClient(restTemplate, url);
			
			restauranteClient.listar().stream()
			.forEach(restaurante -> System.out.println(restaurante));
			
		} catch (ClientApiException e) {
			if(e.getProblem() != null) {
				//System.out.println(e.getProblem());
				System.out.println(e.getProblem().getUserMessage());				
			}else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
		
	}

}
