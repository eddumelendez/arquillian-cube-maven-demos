package io.eddumelendez.arquillian;

import java.io.File;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.Is.is;

@RunWith(Arquillian.class)
public class NodeServerTest {

	@Deployment(testable = false)
	public static GenericArchive createDeployment() {
		return ShrinkWrap.create(GenericArchive.class, "app.tar")
				.add(new FileAsset(new File("src/test/js/index.js")), "index.js")
				.add(new FileAsset(new File("src/test/js/package.json")), "package.json");
	}

	@Test
	public void shouldReturnMessage(@ArquillianResource URL base) {
		get(base).then().body(is("Hello World from NodeJS!"));
	}

}
