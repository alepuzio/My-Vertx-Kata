package net.alepuzio.myvertxkata.extconf;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
/**
 * from https://github.com/marcorotondi/Vert.x/second
 * */
public class MySecondVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut/*future result of an execution that returns no value*/) {
    	final int defaultPort = 9999;
    	final String msg = "<H1>Hello By VERT.X Intre' Camp</H1>";
        vertx//vertical to deploy
        .createHttpServer()//create default http server
                .requestHandler(//handle the async requests <i>HttpServerRequest</i>
                		r -> {
			                    r
			                    .response()//returnt he response of the current http request
			                    .end(msg);//write in the response body and 	close the chunk 
			                }
                		)
                .listen(// listen in 0.0.0.0 ip (the rest of the Internet) 
                        /* Retrieve the port from the configuration,
                         default to 8080.*/
                        config()
                        .getInteger("http.port", defaultPort),//if http.port is absent, then the value will be <i>defaultPort</i>
                        result -> {//result is the event
                            if (result.succeeded()) {//if the AsyncResult succeed
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );
    }
}