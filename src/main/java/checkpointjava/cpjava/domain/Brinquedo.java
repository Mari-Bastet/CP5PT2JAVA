package checkpointjava.cpjava.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="TDS_TB_BRINQUEDOS")
@SequenceGenerator(name="SEQ",sequenceName = "SEQ_ID_BRINQUEDO", allocationSize = 1 )
@Getter
@Setter
@NoArgsConstructor
public class Brinquedo {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	 private Long id;
	 private String nome;
	 private String tipo;
	 private int classificacao;
	 private Double tamanho;
	 private Double preco;
	 
//	public Brinquedo() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getClassificacao() {
		return classificacao;
	}
	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	public Double getTamanho() {
		return tamanho;
	}
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
