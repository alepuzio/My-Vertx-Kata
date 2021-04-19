package net.alepuzio.myvertxkata.basic;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class PostCommand {
	
	private String url;
	private Router router ;
	
	public PostCommand( Router router, String url) {
		super();
		this.url = url;
		this.router = router;
	}
	
	public Route route() {
		return router
				.post(this.url)//the POST request to url is managed here 
				.consumes("*/json")
				.handler(
						routingContext -> {//context ot the routing, new to every httprequest
							System.out.println("came to post");
							HttpServerResponse response = routingContext.response();
							response.setChunked(true);//every call return a new http chunk to the body
							//TODO put timestamp
							response.write("Hi TechPrimers from post\n");//write the string in the body
							response.end();//write the last chunck in the current response
							}
						);

	}

}
