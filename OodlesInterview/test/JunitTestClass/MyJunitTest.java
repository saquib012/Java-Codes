/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JunitTestClass;

import com.saquib.HtmlParse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saquib
 */
public class MyJunitTest {
    
    public MyJunitTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
     public void testHtml() throws MalformedURLException, IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String url= "http://www.google.com/";
        HtmlParse hp = new  HtmlParse();
        hp.testFile(url, baos);
        assertTrue(baos.toString().contains("google"));
    }
    
    
}
