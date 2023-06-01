

public class Candidato {

	//atributos
	protected String nome;
	protected String partido;
	protected int intencoesVoto;
	
	public Candidato(String nome, String partido, int intencoesVoto) {
		this.nome = nome;
		this.partido = partido;
		this.intencoesVoto = intencoesVoto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getIntencoesVoto() {
		return intencoesVoto;
	}

	public void setIntencoesVoto(int intencoesVoto) {
		this.intencoesVoto = intencoesVoto;
	}

	@Override
	public String toString() {
		return """
		        Candidato:
		               Nome: %s,
		               Partido: %s,
		               Intencoes de Voto: %d
		           
		           """.formatted(getNome(), getPartido(), getIntencoesVoto());
	}
}
