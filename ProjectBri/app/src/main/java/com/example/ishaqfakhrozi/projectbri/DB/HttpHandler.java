package com.example.ishaqfakhrozi.projectbri.DB;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {

    private static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler(){}
    public String makeCall(String requrl){
        String response = null;
        try {
            URL url = new URL(requrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(con.getInputStream());
            response = convertStreamToString(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;
        try{
            while((line=reader.readLine())!=null){
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public String readFromFile(String name){
        StringBuilder sb = new StringBuilder();
        BufferedReader reader  = null;
        try {
            reader = new BufferedReader(new FileReader(name));
            String line;
            while((line = reader.readLine())!=null) {
                sb.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return sb.toString();
    }
}
