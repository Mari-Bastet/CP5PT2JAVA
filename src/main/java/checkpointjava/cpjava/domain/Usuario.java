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
@Table(name="TDS_TB_USUARIO")
@SequenceGenerator(name="SEQ",sequenceName = "SEQ_ID_USUARIO", allocationSize = 1 )
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
	

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private Long id;
	private String username;
	private String senha;
	
//	public Usuario() {
//		super();
//	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
