package spotify;

import java.util.HashSet;
import java.util.Objects;

public class Playlist {
	private String nome;
	private String descricao;
	private String criador;
	private HashSet<Musica> musicas;
	
	public Playlist(String nome, String descricao, String criador) {
		this.nome = nome;
		this.descricao = descricao;
		this.criador = criador;
		this.musicas = new HashSet<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		return Objects.equals(nome, other.nome);
	}
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getCriador() {
		return criador;
	}
	@Override
	public String toString() {
	    return nome + " - " + descricao + " - " + criador;
	}
	public boolean adicionarMusica(Musica musica) {
		return musicas.add(musica);
	}
	public int contarMusicas() {
		return musicas.size();
	}
	public String exibirMusicas() {
	    String resultado = "";
	    int contador = 0;

	    for (Musica musica : musicas) {

	        resultado += musica.toString();

	        contador++;

	        if (contador != musicas.size()) {
	            resultado += "\n";
	        }
	    }

	    return resultado;
	}
	
}
