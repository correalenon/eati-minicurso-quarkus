package info.eati.quarkus.resource;

import java.util.List;

import info.eati.quarkus.dto.JogadorDTO;
import info.eati.quarkus.entity.Jogador;
import info.eati.quarkus.service.JogadorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/api/jogadores")
public class JogadorResource {

	@Inject
	JogadorService jogadorService;
	
	@Path("/")
	@GET
	public Response consultarJogadores() {
		List<Jogador> jogadores = jogadorService.consultarJogadores();
		return Response.ok().entity(jogadores).build();
	}
	
	@Path("/{id}")
	@GET
	public Response consultarJogadorPeloId(Long id) {
		Jogador jogador = jogadorService.consultarPeloId(id);
		return Response.ok().entity(jogador).build();
	}

	@Path("/{id}")
	@DELETE
	public Response deletarJogadorPeloId(Long id) {
		boolean jogador = jogadorService.deletarPeloId(id);
		if (jogador) {
			return Response.noContent().build();
		}
		return Response.notModified().build();
	}

	@Path("/criar")
	@POST
	public Response inserirJogador(JogadorDTO jogadorDTO) {
		Jogador jogador = jogadorService.inserir(jogadorDTO);
		return Response.ok(jogador).status(201).build();
	}
}
