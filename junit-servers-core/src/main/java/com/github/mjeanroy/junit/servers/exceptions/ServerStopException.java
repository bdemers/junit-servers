package com.github.mjeanroy.junit.servers.exceptions;

/**
 * Exception thrown when server cannot be stopped.
 */
public class ServerStopException extends AbstractEmbeddedServerException {

	public ServerStopException(Throwable throwable) {
		super(throwable);
	}
}