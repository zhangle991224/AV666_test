package com.xxoo.av666.http;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * com.example.mk_pc077.myapplication.configure
 * Description：
 * Created by zhangle on 2016/7/6.
 * qq:475166369
 */
public class HttpReqUtil {
    /**
     * get方式请求
     * @param url
     * @return 服务器返回值
     * @throws IOException
     */
    public static Response get(String url) throws IOException {
        Request request = new Request.Builder().url(url)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        if (!response.isSuccessful())
            throw new IOException("请求有错：" + response);
        return response;
    }

    /**
     * post方式请求
     *
     * @param url
     * @param params
     *            参数，已json方式传参
     * @return 服务器返回值
     * @throws IOException
     */
    public static Response post(String url, RequestBody body) throws IOException {
        Request request = new Request.Builder().url(url)
                .post(body).build();
        Response response = new OkHttpClient().newCall(request).execute();
        System.out.println(response.code()+"="+response.body().toString());
        if (!response.isSuccessful())
            throw new IOException("请求有错：" + response);
        return response;

    }
}
