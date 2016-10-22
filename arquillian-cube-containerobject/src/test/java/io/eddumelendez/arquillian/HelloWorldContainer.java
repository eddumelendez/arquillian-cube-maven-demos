package io.eddumelendez.arquillian;

import org.arquillian.cube.HostIp;
import org.arquillian.cube.HostPort;
import org.arquillian.cube.containerobject.CubeDockerFile;

@CubeDockerFile
public class HelloWorldContainer {

	@HostIp
	private String ip;

	@HostPort(8080)
	private int port;

	public String getIp() {
		return this.ip;
	}

	public int getPort() {
		return this.port;
	}

}
