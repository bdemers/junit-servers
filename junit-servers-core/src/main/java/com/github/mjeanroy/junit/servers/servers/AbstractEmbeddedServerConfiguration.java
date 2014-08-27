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

package com.github.mjeanroy.junit.servers.servers;

import java.io.File;

public abstract class AbstractEmbeddedServerConfiguration<T extends AbstractEmbeddedServerConfiguration> {

	// Default classpath
	// Should be enough for most projects but can be overridden (could be necessary for sub-projects)
	public static final String DEFAULT_CLASSPATH = ".";

	/** Server Path. */
	protected String path;

	/** Webapp Path. */
	protected String webapp;

	/** Server port, default is to use a random port. */
	protected int port;

	/** Additional classpath. */
	protected String classpath;

	public AbstractEmbeddedServerConfiguration() {
		this.port = 0;
		this.path = "/";
		this.webapp = "src/main/webapp";
		this.classpath = DEFAULT_CLASSPATH;
	}

	/**
	 * Create new embedded configuration by copying existing configuration.
	 *
	 * @param configuration Configuration.
	 */
	public AbstractEmbeddedServerConfiguration(AbstractEmbeddedServerConfiguration configuration) {
		this.port = configuration.getPort();
		this.path = configuration.getPath();
		this.webapp = configuration.getWebapp();
		this.classpath = configuration.getClasspath();
	}

	public int getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public String getWebapp() {
		return webapp;
	}

	public String getClasspath() {
		return classpath;
	}

	/**
	 * Change server path.
	 *
	 * @param path New path.
	 * @return this.
	 */
	public T withPath(String path) {
		this.path = path;
		return (T) this;
	}

	/**
	 * Change server port.
	 *
	 * @param port New port.
	 * @return this.
	 */
	public T withPort(int port) {
		this.port = port;
		return (T) this;
	}

	/**
	 * Change webapp path.
	 *
	 * @param webapp New webapp path.
	 * @return this.
	 */
	public T withWebapp(String webapp) {
		this.webapp = webapp;
		return (T) this;
	}

	/**
	 * Change webapp path.
	 *
	 * @param webapp New webapp path.
	 * @return this.
	 */
	public T withWebapp(File webapp) {
		this.webapp = webapp.getAbsolutePath();
		return (T) this;
	}

	/**
	 * Change additional classpath value.
	 *
	 * @param classpath New classpath.
	 * @return this.
	 */
	public T withClasspath(String classpath) {
		this.classpath = classpath;
		return (T) this;
	}
}