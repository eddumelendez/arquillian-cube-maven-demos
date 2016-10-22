package io.eddumelendez.arquillian;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.arquillian.cube.containerobject.Cube;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

@RunWith(Arquillian.class)
public class HelloWorldTest {

	@Cube(value = "hello-world", portBinding = "8080->8080/tcp")
	private HelloWorldContainer helloWorldContainer;

	@Before
	public void setup() {
		RestAssured.baseURI = "http://" + this.helloWorldContainer.getIp();
		RestAssured.port = this.helloWorldContainer.getPort();
	}

	@Test
	public void shouldReturnWelcomeMessage() {
		when().get("/Eddu")
				.then()
				.statusCode(200)
				.contentType(ContentType.TEXT)
				.body(is("Hello World, Eddu!"));
	}

}
