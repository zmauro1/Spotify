package spotify;

import java.util.Objects;

public class Musica {
	private String titulo;
	private String artista;
	private int duracaoEmSeg;
	private String genero;
	private int codigo;
	
	public Musica(String titulo, String artista, int duracaoEmSeg, String genero, int codigo){
		this.titulo = titulo;
		this.artista = artista;
		this.duracaoEmSeg = duracaoEmSeg;
		this.genero = genero;
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getArtista() {
		return artista;
	}
	public int getDuracaoEmSeg() {
		return duracaoEmSeg;
	}
	public String getGenero() {
		return genero;
	}
	public int getCodigo() {
		return codigo;
	}
	
	public String toString() {
	    return codigo + " - " + titulo + " - " + artista + " - " + duracaoEmSeg + "s - " + genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		return codigo == other.codigo;
	}
}
