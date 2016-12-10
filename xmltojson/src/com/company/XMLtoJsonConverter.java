package com.company;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.io.IOUtils;

/**
 * Created by Atdhe on 12/10/2016.
 */
public class XMLtoJsonConverter {
    private URL url = null;
    private InputStream inputStream = null;

    public void getXMLfromJson() {
        try {
            url = XMLtoJsonConverter.class.getClassLoader().getResource("kurteshi_tv_Program.xml");
            inputStream = url.openStream();
            String xml = IOUtils.toString(inputStream);
            JSON objJson = new XMLSerializer().read(xml);
            System.out.println("JSON data : " + objJson);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                url = null;
            } catch (IOException ex) {
            }
        }
    }
}
