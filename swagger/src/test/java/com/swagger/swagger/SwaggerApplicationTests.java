package com.swagger.swagger;

import com.swagger.swagger.operations.operations;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SwaggerApplicationTests {

	@Test
	void contextLoads() {
	}
        
                @Test
                  public void testFormMessage() {
                    //Asserts that two Strings are equal                
                        Float expected[] = {-487.2859f,1557.0142f};
                        Float result[] = operations.GetLocation(100.0f,115.5f,142.7f);


                        Assert.assertArrayEquals(expected,result);
                        
                        
                        String  message = "este es un mensaje secreto";
                        
                        String resultMessage;
                  
                        resultMessage = operations.GetMessage(new String[][]{new String[]{"este", "", "", "mensaje", ""},
                                new String[]{"", "es", "", "", "secreto"},
                                new String[]{"este", "", "un", "", ""}});
                        
                        Assert.assertEquals(message, resultMessage);
                  } 

}
