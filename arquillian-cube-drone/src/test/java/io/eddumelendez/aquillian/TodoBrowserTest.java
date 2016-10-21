package io.eddumelendez.aquillian;

import java.net.MalformedURLException;
import java.net.URL;

import org.arquillian.cube.HostIp;
import org.arquillian.cube.HostPort;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class TodoBrowserTest {

	@Drone
	private WebDriver webDriver;

	@HostIp
	private String ip;

	@HostPort(containerName = "helloworld", value = 80)
	private int port;

	@Test
	public void shouldShowHelloWorld() throws MalformedURLException, InterruptedException {
		URL url = new URL("http", ip, port, "/");
		this.webDriver.get(url.toString());
		final String message = this.webDriver.findElement(By.tagName("h1")).getText();
		assertThat(message, is("Hello world!"));
	}

}
