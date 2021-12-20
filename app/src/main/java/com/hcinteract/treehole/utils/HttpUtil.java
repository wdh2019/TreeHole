package com.hcinteract.treehole.utils;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// 异步 参考： https://blog.csdn.net/public_calss/article/details/83094817
// cookieStore 参考： https://www.jianshu.com/p/1873287eed87/
// 其他 参考： https://blog.csdn.net/qq_41973208/article/details/103032019

public class HttpUtil {
    private static OkHttpClient okHttpClient;
    private final static HashMap<String, List<Cookie>> cookieStore;

    static {
        cookieStore = new HashMap<>();
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .build();
    }

    public static void asyncGet(String url, final MyCall myCall) {
        // query 在 url 后拼接
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myCall.fail(call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myCall.succeed(call, response);
            }
        });
    }

    public static void asyncPost(String url, HashMap<String, Object> params, final MyCall myCall) {
        // body 为 json 格式
        MediaType JSONType = MediaType.parse("application/json; charset=utf-8");
        JSONObject content = new JSONObject();
        try {
            if (params.size() > 0) {
                for (String key: params.keySet()) {
                    content.put(key, params.get(key));
                }
            }
            RequestBody body = RequestBody.create(JSONType, content.toString());
            Request request = new Request.Builder().url(url).post(body).build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    myCall.fail(call, e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    myCall.succeed(call, response);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface MyCall {
        void succeed(Call call, Response response) throws IOException;
        void fail(Call call, IOException e);
    }
}
