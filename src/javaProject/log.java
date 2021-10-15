/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaProject;
import java.io.FileWriter;

/**
 *
 * @author Asus
 */

//Constructor
//Write into file named "testout"
public class log {
        log(String l){    
         try{    
           FileWriter fw=new FileWriter("C:\\Users\\Asus\\Desktop\\testout.txt");    
           fw.write(l);    
           fw.close();    
          }catch(Exception e){System.out.println(e);}    
          System.out.println("Log success!");    
     }  
}
