package net.alepuzio.myvertxkata;

import net.alepuzio.myvertxkata.basic.BasicScenario;


public class App {

	public static void main(String[] args) {
		App app = new App();
		app.basicScenario();
	}

	
	public void basicScenario() {
		new BasicScenario(8091).execute();
	}
}
