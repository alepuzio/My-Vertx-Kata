package net.alepuzio.myvertxkata;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;


public class TestHTTPVerb  {

	protected void setUp() throws Exception {
	}

	protected void tearDown() throws Exception {
	}

	public void testGet() {
		try {
			Process get = Runtime.getRuntime().exec(command( "command-get"));
			Assertions.assertNotNull(get);
		} catch (IOException e) {
			e.printStackTrace();
			Assertions.assertFalse(true);
		}
	}

	public void testPost() {
		try {
			Process post = Runtime.getRuntime().exec(command( "command-post"));
			Assertions.assertNotNull(post);
		} catch (IOException e) {
			e.printStackTrace();
			Assertions.assertFalse(true);
		}
	}

	private String command(String bat) {
		return String.format("cmd /c start \"\" src\\main\\resources\\%s.bat", bat);
	}

}
