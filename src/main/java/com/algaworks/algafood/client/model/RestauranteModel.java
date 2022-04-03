package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteModel {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;	
	private boolean ativo;
	private boolean aberto;
	
	private CozinhaModel cozinha;
	private EnderecoModel endereco;
	

}
