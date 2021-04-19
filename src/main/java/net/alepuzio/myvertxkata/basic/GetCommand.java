package net.alepuzio.myvertxkata.basic;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
/**
 * @overview: GET request
 * */
public class GetCommand {
	
	private String url;
	private Router router ;
	
	public GetCommand( Router router, String url) {
		super();
		this.url = url;
		this.router = router;
	}
	
	
	/**
	 * @return route
	 * */
	public Route route() {
		return router
				.get(this.url)//the GET request to url is managed here 
				.handler(//append action to the current route
					routingContext -> {//context ot the routing, new to every httprequest
						String name = routingContext.request().getParam("name");//return first value <i>name</i>
						System.out.println("came to hello: " + name);//TODO put timestamp
						HttpServerResponse response = routingContext.response();
						response.setChunked(true);//every call return a new http chunk to the body
						response.write("Hi " + name + "\n");//write the string in the body
						response.end();//write the last chunck in the current response
					}
				);
	}
}
