package io.eddumelendez.arquillian;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
@Path("/pokemon")
public class PokemonEndpoint {

	@GET
	@Path("/")
	public Response all() {
		List<String> pokemons = Arrays.asList("Bulbasaur", "Charmander", "Squirtle");
		return Response.ok(pokemons).build();
	}

}
