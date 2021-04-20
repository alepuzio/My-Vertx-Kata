package net.alepuzio.myvertxkata;

import java.io.IOException;

import junit.framework.TestCase;

public class TestHTTPVerb extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGet() {
		try {
			Process get = Runtime.getRuntime().exec(command( "command-get"));
			assertNotNull(get);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	public void testPost() {
		try {
			Process post = Runtime.getRuntime().exec(command( "command-post"));
			assertNotNull(post);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	private String command(String bat) {
		return String.format("cmd /c start \"\" src\\test\\resources\\%s.bat", bat);
	}

}
