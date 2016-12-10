package com.company;
import java.io.*;
import java.lang.reflect.Executable;
import java.net.URL;
import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;


public class Main{

    //private static final String FileName="kurteshi_tv_Program.xml";
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    public static String path="C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\kurteshi_tv_Program.xml";

    public static void main(String[] args) {
      //File file=new File(path);


      try {
          //String s = file.toString();
          FileReader fileReader=new FileReader(path);

          BufferedReader bufferedReader=new BufferedReader(fileReader);

          StringBuilder builder = new StringBuilder();
          StringBuilder builderAppend=new StringBuilder();
          String line;


          while((line=bufferedReader.readLine())!= null)
          {
             // builderAppend=builder.append(line);
              System.out.println(line);
          }
          JSONObject jsonObject = XML.toJSONObject(builderAppend.toString());
          String jsonPString = jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);
          /*while ((line = bufferedReader.readLine()) != null) {
              builder.append(line);
              //JSONObject jsonObject = XML.toJSONObject(builder.toString());


          }*/
          //JSONObject jsonObject = XML.toJSONObject(builderAppend.toString());
          //String jsonPString = jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);
          System.out.println(jsonPString);
          /*try (FileWriter file = new FileWriter("C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\file.txt")) {
              file.write(jsonPString);
              System.out.println("Successfully Copied JSON Object to File...");
              System.out.println("\nJSON Object: " + jsonObject);
          }
          catch(Exception e){
              e.printStackTrace();
          }*/
       }
      catch(Exception e){
          e.printStackTrace();
      }
    }
}