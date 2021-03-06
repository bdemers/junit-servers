/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 <mickael.jeanroy@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.mjeanroy.junit.servers.rules;

import com.github.mjeanroy.junit.servers.servers.EmbeddedServer;
import com.github.mjeanroy.junit.servers.servers.configuration.AbstractConfiguration;
import org.junit.runner.Description;

import static com.github.mjeanroy.junit.servers.commons.Preconditions.notNull;
import static com.github.mjeanroy.junit.servers.servers.utils.Servers.instantiate;

/**
 * Rule that can be used to start and stop embedded server.
 */
public class ServerRule extends AbstractRule {

	/** Embedded server that will be start and stopped. */
	private final EmbeddedServer server;

	/**
	 * Create rule with default embedded server.
	 *
	 * Embedded server implementation is chosen using
	 * classpath detection: jetty or tomcat will be instantiate
	 * if implementation is available on classpath (it means if
	 * sub-module is imported, it should be enough to instantiate
	 * embedded server !).
	 */
	public ServerRule() {
		this((AbstractConfiguration) null);
	}

	/**
	 * Create rule with embedded server configuration.
	 *
	 * Embedded server implementation is chosen using
	 * classpath detection: jetty or tomcat will be instantiate
	 * if implementation is available on classpath (it means if
	 * sub-module is imported, it should be enough to instantiate
	 * embedded server !).
	 *
	 * @param configuration Server configuration.
	 */
	public ServerRule(AbstractConfiguration configuration) {
		this(instantiate(configuration));
	}

	/**
	 * Create rule.
	 *
	 * @param server Embedded server.
	 */
	public ServerRule(EmbeddedServer server) {
		this.server = notNull(server, "server");
	}

	@Override
	protected void before(Description description) {
		start();
	}

	@Override
	protected void after(Description description) {
		stop();
	}

	/**
	 * Start embedded server.
	 *
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#start()
	 */
	public void start() {
		server.start();
	}

	/**
	 * Stop embedded server.
	 *
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#stop()
	 */
	public void stop() {
		server.stop();
	}

	/**
	 * Restart embedded server.
	 *
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#restart()
	 */
	public void restart() {
		server.restart();
	}

	/**
	 * Check if embedded server is started.
	 *
	 * @return True if embedded server is started, false otherwise.
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#isStarted()
	 */
	public boolean isStarted() {
		return server.isStarted();
	}

	/**
	 * Get port used by embedded server.
	 *
	 * @return Port.
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#getPort()
	 */
	public int getPort() {
		return server.getPort();
	}

	/**
	 * Get path defined on embedded server.
	 *
	 * @return Path.
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#getPath()
	 */
	public String getPath() {
		return server.getPath();
	}

	/**
	 * Get url used to query embedded server.
	 *
	 * @return URL.
	 * @see com.github.mjeanroy.junit.servers.servers.EmbeddedServer#getUrl()
	 */
	public String getUrl() {
		return server.getUrl();
	}

	/**
	 * Get embedded server.
	 *
	 * @return Server.
	 */
	public EmbeddedServer getServer() {
		return server;
	}
}
