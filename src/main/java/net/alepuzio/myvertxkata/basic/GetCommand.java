package net.alepuzio.myvertxkata.basic;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class GetCommand {
	private String url;
	private Router router ;
	
	public GetCommand( Router router,String url) {
		super();
		this.url = url;
		this.router = router;
	}
	
	

	public Route route() {
		return router.get(this.url).handler(routingContext -> {
			String name = routingContext.request().getParam("name");
			System.out.println("came to hello: " + name);
			HttpServerResponse response = routingContext.response();
			response.setChunked(true);
			response.write("Hi " + name + "\n");
			response.end();
		});
	}
}
