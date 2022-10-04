package me.dio.sacola.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor // construtor com todos os atributos
@Builder //ajuda na criação do objeto
@Data //todos os getters and setters, hashcode e equals
@Entity //É uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //ignora alguns erros de hibernate
@NoArgsConstructor //construtor vazio utilizado pelo hibernate
public class Sacola {
    @Id // Toda tabela deve ter uma primary ke
    @GeneratedValue(strategy = GenerationType.AUTO) //gera automaticamente os valores do id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)    //Um cliente pode ter mais de uma sacola
    @JsonIgnore //elimina erros de serialzação
    private Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private Double valorTotal;
    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;


}