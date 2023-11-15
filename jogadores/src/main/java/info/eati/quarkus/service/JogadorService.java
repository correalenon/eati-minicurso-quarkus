package info.eati.quarkus.service;

import java.util.List;

import info.eati.quarkus.dto.JogadorDTO;
import info.eati.quarkus.entity.Jogador;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class JogadorService {

	public List<Jogador> consultarJogadores() {
		return Jogador.findAll().list();
	}
	
	public Jogador consultarPeloId(Long id) {
		return (Jogador) Jogador.findByIdOptional(id).orElseThrow();
	}

	@Transactional
	public Jogador inserir(JogadorDTO jogadorDTO) {
		Jogador jogador = new Jogador();
		jogador.setNome(jogadorDTO.getNome());
		jogador.setTime(jogadorDTO.getTime());
		jogador.setCamisa(jogadorDTO.getCamisa());
		jogador.persist();
		return (Jogador) jogador;
	}

	@Transactional
	public boolean deletarPeloId(Long id) {
		return Jogador.deleteById(id);
	}
}
