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
			Process get = Runtime.getRuntime().exec( String.format("cmd /c start \"\" src\\main\\resources\\%s.bat", "command-get"));
			assertNotNull(get);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

	public void testPost() {
		try {
			Process post = Runtime.getRuntime().exec(String.format("cmd /c start \"\" src\\main\\resources\\%s.bat", "command-post"));
			assertNotNull(post);
		} catch (IOException e) {
			e.printStackTrace();
			assertFalse(true);
		}
	}

}
