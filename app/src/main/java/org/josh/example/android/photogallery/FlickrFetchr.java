package org.josh.example.android.photogallery;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Josh on 9/24/2015.
 */

// creates a url object from a string. Calls openConnection to create a connection object pointed at the URL.
    //once url is created and open connection, call read repeatedly until your connection runs out of data. The inputstream
    //yields bytes as they're available.




public class FlickrFetchr {

    public byte[] getUrlBytes(String urlSepc) throws IOException{
        URL url = new URL(urlSepc);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();

        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage() + ": with " + urlSepc);
            }

            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0){
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        }finally {
            connection.disconnect();
        }
    }
    public String getUrlString(String urlSpec)throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

}
