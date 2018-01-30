package ec.edu.upse.proyinv.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="enunciado_campo")
@NoArgsConstructor
public class EnunciadoCampo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_enunciado_campo")
	@Getter @Setter private Long idEnunciadoCampo;
	
	@Getter @Setter private String enunciado;

	@Getter @Setter private String img;

	@Getter @Setter private String estado;
	
	//bi-directional many-to-one association to Campo
	@OneToMany(mappedBy="enunciadoCampo")
	@JsonIgnore
	@Getter @Setter private List<Campo> campo;
	
	//bi-directional many-to-one association to TipoVariable
	@ManyToOne
	@JoinColumn(name="id_tipo_variable")
	@Getter @Setter private TipoVariable tipoVariable;
}
