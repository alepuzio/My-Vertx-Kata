package net.alepuzio.myvertxkata.basic;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class PostCommand {
	
	private String url;
	private Router router ;
	
	public PostCommand( Router router,String url) {
		super();
		this.url = url;
		this.router = router;
	}
	
	public Route route() {
		return router.post("/hello").consumes("*/json").handler(routingContext -> {
			System.out.println("came to post");
			HttpServerResponse response = routingContext.response();
			response.setChunked(true);
			response.write("Hi TechPrimers from post\n");
			response.end();
		});

	}

}
