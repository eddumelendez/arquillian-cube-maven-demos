package io.eddumelendez.arquillian;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;

@RunWith(Arquillian.class)
public class PokemonEndpointIT {

	@Test
	public void shouldReturnPokemons() {
		get("/pokemon-api/rest/pokemon")
				.then()
				.body(is("[\"Bulbasaur\",\"Charmander\",\"Squirtle\"]"));
	}

}
