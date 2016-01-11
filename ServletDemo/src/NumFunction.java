/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saquib
 */
public class NumFunction {
    int s;
    
    public int getTable()
    {
        if(req.getParameter("s").equals("getTable"))
        {
            for (int i=1; i<=10; i++)
            {
                int s= s*i;
            }
        } 
        return 0;
    }
    public int getFactorial()
    {
         if(req.getParameter("s").equals("getFactorial"))
        long fact= 1;
        if (s<0)
            System.out.println("NO factorial of less than 1");
        else
        {
        for(int i=1;i<s; i++)
        {
            fact= fact*i;
        }
       
        }
        return 0;
    }
public int getPalindrome()
{
     if(req.getParameter("s").equals("getPalindrome"))
    int s;
    s=s%10;
    int r= r*10;
    s=s/10;
            
}
public int getSquare()
{
     if(req.getParameter("s").equals("getSquareRoot"))
    s=s*s;
        return 0;
}
   
    public static void main(String[] args) {
       
        
    }
}
