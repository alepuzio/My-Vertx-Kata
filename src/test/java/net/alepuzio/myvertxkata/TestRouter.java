package net.alepuzio.myvertxkata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class TestRouter  {

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	@Test
	public void testRoutersEqualsInSamevertx() {
		Vertx vertx = Vertx.vertx();// entry point
		final Router router1 = Router.router(vertx);// receive http request and routes to first matched <i>Route</i>
		final Router router2 = Router.router(vertx);// receive http request and routes to first matched <i>Route</i>
		Assertions.assertEquals(router1, router2);
	}
	
	@Test
	public void testRoutersEqualsMoreVertx() {
		final Router router1 = Router.router( Vertx.vertx());// receive http request and routes to first matched <i>Route</i>
		final Router router2 = Router.router( Vertx.vertx());// receive http request and routes to first matched <i>Route</i>
		Assertions.assertEquals(router1, router2);
	}

}
