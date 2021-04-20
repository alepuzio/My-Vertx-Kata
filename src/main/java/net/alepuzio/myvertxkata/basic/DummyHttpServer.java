package net.alepuzio.myvertxkata.basic;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class DummyHttpServer {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		HttpServer httpServer = vertx.createHttpServer();
		final String msg = String.format("<h2>ahahahah %s</h2>", httpServer.actualPort());
		Router router = Router.router(vertx);
		router
			.route()
			.handler( requestHandler -> { 
				HttpServerResponse response = requestHandler.response();
				response.putHeader("content-type", "text/html").end(msg);
				System.out.println(httpServer.actualPort());
			});
		httpServer
			.requestHandler(router::accept)
			.listen(8091);
	}

}
