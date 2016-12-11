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

    //*****References Used*****/

    //http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
    //https://www.mkyong.com/java/how-to-append-content-to-file-in-java/
    //http://stackoverflow.com/questions/26358684/converting-bufferedreader-to-jsonobject-or-map
    //http://stackoverflow.com/questions/26358684/converting-bufferedreader-to-jsonobject-or-map
    //http://crunchify.com/how-to-write-json-object-to-file-in-java/
    //http://www.cs.utexas.edu/~mitra/csSummer2012/cs312/lectures/fileIO.html
    //https://www.mkyong.com/java/json-simple-example-read-and-write-json/

    //***/

    /** Paths by default.
     *  private static final String FileName="kurteshi_tv_Program.xml";
     *  public static String path="C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\kurteshi_tv_Program.xml";
     *  public static String pathToWrite="C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\kurteshi_tv_Program.xml";
     */

    /**
     *  @PRETTY_PRINT_INDENT_FACTOR=4
     *  @String Path
     *  @String PathToWrite
     *  Currently the paths are hardcoded, need to be aware when you change the computer change also the path to your computer dir.
     */

    public static int PRETTY_PRINT_INDENT_FACTOR = 4;

    public static String path="C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\kurteshi_tv_Program.xml";
    public static String pathToWrite="C:\\Users\\Atdhe\\IdeaProjects\\xmltojson\\src\\kurteshi_tv_program.json";

    public static String xmlToJson(String path,String pathToWrite){

         try {

            /*create a fileReader and read the path and than give to the bufferReader*/

            FileReader fileReader=new FileReader(path);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            StringBuilder builder = new StringBuilder();
            StringBuilder builderAppend=new StringBuilder();
            String line;


            while((line=bufferedReader.readLine())!= null)
            {
                builderAppend=builder.append(line);
            }

            /*create a jsonObject and turn the XML toJsonObject*/

            JSONObject jsonObject = XML.toJSONObject(builderAppend.toString());
            String jsonPString = jsonObject.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPString);
            try (FileWriter file = new FileWriter(pathToWrite)) {
              file.write(jsonPString);
              System.out.println("Successfully Copied JSON Object to File...");
              System.out.println("\nJSON Object: " + jsonObject);
            }
          catch(Exception e){
              e.printStackTrace();
          }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return path;
    }
    public static void main(String[] args) {

        /**
         * XmlFileToJson Function
         * @path where to pick the XML File
         * @pathToWrite where to write the Json File in our case in src/kurteshi_tv_program.json
         * The 'path' and 'pathToWrite' files are in the 'src' directory of the project by default.
         */
        xmlToJson(path,pathToWrite);
    }
}