package com.saquib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class HtmlParse 
{
    public static void main(String args[])
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the name of your url");
    try
    {
    String url= br.readLine();
    File file= new File("C:/Users/saquib/Desktop/Web-Content1.txt");
    if(!file.exists())
    {
        file.createNewFile();
        //FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
        //BufferedWriter bw = new BufferedWriter(fw);
        FileOutputStream fw= new FileOutputStream(file);
        testFile(url, fw);
        fw.close();
    }
    else
    {
        System.out.println("File Already present");
    }
    
    }
    
    catch(MalformedURLException me)
    {
        System.out.println("Website not available");
    }
    catch(IOException io)
    {
       System.out.println("Error in getting connection..");

    }
    
    }
    public static void testFile(String url, OutputStream fw) throws MalformedURLException, IOException
    {
    URL myUrl = new URL(url); // Adding url of which we want source code
    URLConnection con= myUrl.openConnection();// getting connection from java to website
    BufferedReader br= new BufferedReader(new InputStreamReader(con.getInputStream()));
      
    int c;
        while ((c = br.read()) != -1) 
        {
            System.out.print((char) c);
            fw.write(c);
        }

    br.close();
    }



}


