package me.dio.sacola.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Builder
@Data
@Embeddable // Endereco não será uma tabela no banco de dados. Ela somente fará parte na tabela restaurante e cliente
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String complemento;
}