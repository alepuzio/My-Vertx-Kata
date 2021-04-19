package net.alepuzio.myvertxkata.basic;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class BasicScenario {

	private final int port ;
	
	
	public BasicScenario(int port) {
		this.port = port;
	}


	public void execute() {
		Vertx vertx = Vertx.vertx();//entry point
		HttpServer httpServer = vertx.createHttpServer();//http server with default configuration
		Router router = Router.router(vertx);//receive http request and routes to first matched <i>Route</i>
		Route handler1 = new GetCommand(router, "/hello/:name").route();
		/*Route handler2 = */new PostCommand(router, "/hello/").route();//the handlers are pointed by the current router and vertx object
		httpServer
			.requestHandler(router::accept)
			.listen(this.port);
	}
}
