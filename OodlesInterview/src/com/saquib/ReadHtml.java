/*

1) To read HTML from any website say "http://www.google.com" ( Candidate can use any API of inbuilt APIs in Java 
like URLConnection )
2) Print on console the HTML from the url above and save it to a file ( web-content.txt) in local machine 

*/


package com.saquib;

import java.net.*;
import java.io.*;

public class ReadHtml
{
     public static void main(String[] args) throws Exception 
     {
        URL myurl = new URL("http://www.oracle.com/");
        URLConnection yc = myurl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                                    yc.getInputStream()));
        
        File file = new File("C:/Users/saquib/Desktop/web-content.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
        BufferedWriter bw = new BufferedWriter(fw); 
        
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
        {
            System.out.println(inputLine);
            bw.write(inputLine);
        }
        in.close();
        bw.close();
    }
}

