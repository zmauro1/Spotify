package spotify;

import java.util.ArrayList;
import java.util.Objects;

public class Album {
	private String titulo;
	private String artistaPrincipal;
	private int anoLancamento;
	private ArrayList<Musica> musicas;
	
	public Album(String titulo, String artistaPrincipal, int anoLancamento) {
		this.titulo = titulo;
		this.artistaPrincipal = artistaPrincipal;
		this.anoLancamento = anoLancamento;
		this.musicas = new ArrayList<>();
	}
	public String getTitulo() {
		return titulo;
	}
	public String getArtistaPrincipal() {
		return artistaPrincipal;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(anoLancamento, artistaPrincipal, titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return anoLancamento == other.anoLancamento && Objects.equals(artistaPrincipal, other.artistaPrincipal)
				&& Objects.equals(titulo, other.titulo);
	}
	public boolean adicionarMusica(Musica musica) {
		return musicas.add(musica);
		
	}
	public int contarMusicas() {
		return musicas.size();
	}
	public int calcularTempoTotalDoAlbum() {
		int total = 0;
		for(int i = 0; i<musicas.size(); i++) {
			total += musicas.get(i).getDuracaoEmSeg();
		}
		return total;
	}
	public String exibirMusicas() {
	    String resultado = "";

	    for (int i = 0; i < musicas.size(); i++) {
	        resultado += (i + 1) + ". " + musicas.get(i).toString();

	        if (i != musicas.size() - 1) {
	            resultado += "\n";
	        }
	    }

	    return resultado;
	}
	public String toString() {
	    return titulo + " - " + artistaPrincipal + " - " + anoLancamento;
	}
}
