package spotify;

import java.util.ArrayList;
import java.util.HashMap;

public class SPOOfy {

	private ArrayList<Musica> musicas;
	private ArrayList<Album> albuns;
	private HashMap<String, Playlist> playlists;

	public SPOOfy() {
		this.musicas = new ArrayList<>();
		this.albuns = new ArrayList<>();
		this.playlists = new HashMap<>();
	}

	// =================== MÚSICAS ===================

	public boolean cadastrarMusica(String titulo, String artista, int duracaoEmSegundos, String genero, int codigo) {

		for (int i = 0; i < musicas.size(); i++) {
			if (musicas.get(i).getCodigo() == codigo) {
				return false;
			}
		}

		Musica musica = new Musica(titulo, artista, duracaoEmSegundos, genero, codigo);
		musicas.add(musica);
		return true;
	}

	public int contarMusicas() {
		return musicas.size();
	}

	public String exibirMusicas() {

		String resultado = "";

		for (int i = 0; i < musicas.size(); i++) {

			resultado += musicas.get(i);

			if (i != musicas.size() - 1) {
				resultado += "\n";
			}
		}

		return resultado;
	}

	// =================== ÁLBUNS ===================

	public boolean cadastrarAlbum(String titulo, String artistaPrincipal, int anoLancamento) {

		Album album = new Album(titulo, artistaPrincipal, anoLancamento);

		for (int i = 0; i < albuns.size(); i++) {
			if (albuns.get(i).equals(album)) {
				return false;
			}
		}

		albuns.add(album);
		return true;
	}

	public int contarAlbuns() {
		return albuns.size();
	}

	public String exibirAlbuns() {

		String resultado = "";

		for (int i = 0; i < albuns.size(); i++) {

			resultado += albuns.get(i);

			if (i != albuns.size() - 1) {
				resultado += "\n";
			}
		}

		return resultado;
	}

	public boolean adicionarMusicaNoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento,
			int codigoMusica) {

		Album album = new Album(tituloAlbum, artistaPrincipal, anoLancamento);

		for (int i = 0; i < albuns.size(); i++) {

			if (albuns.get(i).equals(album)) {

				for (int j = 0; j < musicas.size(); j++) {

					if (musicas.get(j).getCodigo() == codigoMusica) {

						return albuns.get(i).adicionarMusica(musicas.get(j));

					}
				}
			}
		}

		return false;
	}

	public int contarMusicasDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {

		Album album = new Album(tituloAlbum, artistaPrincipal, anoLancamento);

		for (int i = 0; i < albuns.size(); i++) {

			if (albuns.get(i).equals(album)) {
				return albuns.get(i).contarMusicas();
			}
		}

		return 0;
	}

	public String exibirMusicasDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {

		Album album = new Album(tituloAlbum, artistaPrincipal, anoLancamento);

		for (int i = 0; i < albuns.size(); i++) {

			if (albuns.get(i).equals(album)) {
				return albuns.get(i).exibirMusicas();
			}
		}

		return "";
	}

	public int calcularTempoTotalDoAlbum(String tituloAlbum, String artistaPrincipal, int anoLancamento) {

		Album album = new Album(tituloAlbum, artistaPrincipal, anoLancamento);

		for (int i = 0; i < albuns.size(); i++) {

			if (albuns.get(i).equals(album)) {
				return albuns.get(i).calcularTempoTotalDoAlbum();
			}
		}

		return 0;
	}

	// =================== PLAYLISTS ===================

	public boolean criarPlaylist(String nome, String descricao, String criador) {

		if (playlists.containsKey(nome)) {
			return false;
		}

		Playlist playlist = new Playlist(nome, descricao, criador);

		playlists.put(nome, playlist);

		return true;
	}

	public int contarPlaylists() {
		return playlists.size();
	}

	public String exibirPlaylist(String nome) {

		if (playlists.containsKey(nome)) {
			return playlists.get(nome).toString();
		}

		return "";
	}

	public boolean adicionarMusicaNaPlaylist(String nomePlaylist, int codigoMusica) {

		if (!playlists.containsKey(nomePlaylist)) {
			return false;
		}

		for (int i = 0; i < musicas.size(); i++) {

			if (musicas.get(i).getCodigo() == codigoMusica) {

				return playlists.get(nomePlaylist).adicionarMusica(musicas.get(i));

			}
		}

		return false;
	}

	public int contarMusicasDaPlaylist(String nomePlaylist) {

		if (!playlists.containsKey(nomePlaylist)) {
			return 0;
		}

		return playlists.get(nomePlaylist).contarMusicas();
	}

	public String exibirMusicasDaPlaylist(String nomePlaylist) {

		if (!playlists.containsKey(nomePlaylist)) {
			return "";
		}

		return playlists.get(nomePlaylist).exibirMusicas();
	}

}
