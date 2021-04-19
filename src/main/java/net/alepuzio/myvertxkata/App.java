package net.alepuzio.myvertxkata;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import net.alepuzio.myvertxkata.basic.GetCommand;
import net.alepuzio.myvertxkata.basic.PostCommand;

public class App {

	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		HttpServer httpServer = vertx.createHttpServer();
		Router router = Router.router(vertx);
		Route handler1 = new GetCommand(router, "/hello/:name").route();
		Route handler2 = new PostCommand(router, "/hello/").route();
		httpServer.requestHandler(router::accept).listen(8091);

	}

}
