package net.alepuzio.myvertxkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.EventBus;


public class TestEventBus  {

	@Test
	public void testEventBusEqualsInSamevertx() {
		final Vertx vertx = Vertx.vertx();// entry point
		final EventBus eventBus1 = vertx.eventBus();
		final EventBus eventBus2 = vertx.eventBus();
		/*
		 * One <i>Vertx</i> points to the one <i>EventBus</i>
		 * */
		Assertions.assertEquals(eventBus1, eventBus2);
	}

	@Test
	public void testEventBusEqualsInDifferentVertx() {
		final EventBus eventBus1 = Vertx.vertx().eventBus();
		final EventBus eventBus2 = Vertx.vertx().eventBus();
		Assertions.assertNotEquals(eventBus1, eventBus2);
	}
	
	@Test
	public void testConsumerDifferentInEventBusEqualsInSameVertx() {
		final Vertx vertx = Vertx.vertx();// entry point
		final EventBus eventBus1 = vertx.eventBus();
		final EventBus eventBus2 = vertx.eventBus();
		/*
		 * One <i>Vertx</i> points to the one <i>EventBus</i>
		 * */
		Assertions.assertEquals(vertx.eventBus().consumer("aaa"), vertx.eventBus().consumer("aaa"));
	}

}
