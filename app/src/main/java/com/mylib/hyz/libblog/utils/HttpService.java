package com.mylib.hyz.libblog.utils;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.mylib.hyz.libblog.utils.Constance.RequestMethod.GET;
import static com.mylib.hyz.libblog.utils.Constance.RequestMethod.POST;
import static com.mylib.hyz.libblog.utils.Constance.RequestMethod.PUT;
public class HttpService {
    private static final String TAG = "HttpService";
    private boolean threadIsEnd = false;
    private HttpURLConnection mConnection;
    private OutputStream outputStream;
    private String mResponse = "";

    public String requestGet(String url) throws Exception {

        return getHttpResponse(url, GET, "");
    }

    public String requestPost(String url, final String data) throws Exception {

        return getHttpResponse(url, POST, data);
    }

    public String requestPut(String url, String data) throws IOException {

        return getHttpResponse(url, PUT, data);
    }

    @NotNull
    private String getHttpResponse(String urlAddress, final String requestMethod, final String data) throws IOException {
        URL url = new URL(urlAddress);
        mConnection = (HttpURLConnection) url.openConnection();
        mConnection.setConnectTimeout(30000);
        mConnection.setRequestMethod(requestMethod);
        final byte[] bytes = data.getBytes("UTF-8");
        if (requestMethod == POST || requestMethod == PUT) {
            mConnection.setRequestProperty("Content-Type", "application/json");

            mConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
        }
        mConnection.setRequestProperty("Connection", "keep-alive");
        mConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        mConnection.setRequestProperty("Accept", "*/*");
        mResponse = "";
        threadIsEnd = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mConnection.connect();
                    if (requestMethod.equals(POST)||requestMethod.equals(PUT)) {
                        outputStream = mConnection.getOutputStream();
                        outputStream.write(bytes);
                        outputStream.flush();
//                        outputStream.close();
                    }
                    int responseCode = mConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = mConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        mResponse = bufferedReader.readLine();
                    } else {
                        mResponse = "{\"code\":" + responseCode + ",\"data\":{}}";
                    }
                    Log.d(TAG, responseCode + "");
                    threadIsEnd = true;
                } catch (Exception e) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    e.printStackTrace();
                    mResponse = "{\"code\":" + 500 + ",\"data\":{}}";
                    threadIsEnd = true;
                }

            }
        }).start();
        while (!threadIsEnd) {
            Log.d(TAG, "!threadIsEnd");
        }
        return mResponse;
    }

}
