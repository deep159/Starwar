package com.example.hi.starwar;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Hi on 06-04-2017.
 */

public class HitURL {
    public static String urlReader(String hit_url)
    {
        StringBuilder builder=new StringBuilder();
        try {
            URL url=new URL(hit_url);
            URLConnection conn=url.openConnection();
            InputStreamReader reader=new InputStreamReader(conn.getInputStream());
            BufferedReader buffer=new BufferedReader(reader);

            String Line=new String();
            while ((Line=buffer.readLine())!=null)
            {
                builder.append(Line+"\n");
            }
            buffer.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e(">>>",e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(">>>",e.toString());
        }

        return builder.toString();
    }
}
