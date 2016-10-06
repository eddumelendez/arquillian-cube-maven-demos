package io.eddumelendez.arquillian;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class PokemonApplication extends ResourceConfig {

	public PokemonApplication() {
		packages("io.eddumelendez.arquillian");
	}

}
