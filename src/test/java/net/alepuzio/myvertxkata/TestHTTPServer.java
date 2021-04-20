package net.alepuzio.myvertxkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

class TestHTTPServer {
	
	@Test
	public void testHttpServerEqualsInSameVertx() {
		final Vertx vertx = Vertx.vertx();
		final HttpServer server1 = vertx.createHttpServer();
		final HttpServer server2 = vertx.createHttpServer();
		Assertions.assertNotEquals(server1, server2);
	}
	
	@Test
	public void testHttpServerEqualsInDifferentVertx() {
		final HttpServer server1 = Vertx.vertx().createHttpServer();
		final HttpServer server2 = Vertx.vertx().createHttpServer();
		Assertions.assertNotEquals(server1, server2);
	}
	
}
