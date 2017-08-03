package com.hepsiburada;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {
   
	@Test
	public void lastPoint() throws Exception{
		@SuppressWarnings("unused")
		PhoenixEngine phoenix = new PhoenixEngine();
		PhoenixEngine.location.put(PhoenixConstant.X, 1);
		PhoenixEngine.location.put(PhoenixConstant.Y, 2);
		PhoenixEngine.location.put(PhoenixConstant.DIRECTION, PhoenixConstant.NORTH);
		String result =PhoenixEngine.drivePhoenix("LMLMLMLMM");
		Assert.assertEquals("1 3 N", result);
	}

}
