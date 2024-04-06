package com.kintong.blogserver.commons.ultils;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author kintong
 */
@Slf4j
@Component
public class GitHubUltils {
//    private final String GITHUB_TOKEN = System.getenv("GITHUB_TOKEN");
//    private final String name = System.getenv("GITHUB_NAME");
//    private final String repo = System.getenv("REPO");
//    private final  String committerEmail = System.getenv("EMAIl");


    @Value("${github.token}")
    private String token;

    @Value("${github.name}")
    private String githubName;

    @Value("${github.repository}")
    private String repository;

    @Value("${github.committerEmail}")
    private String committerEmail;

    private final String commitMessage = "backup";
    private final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    public void updateRepositoryContent(String path, String contentBase64) {
        try {
            String requestUrl = "https://api.github.com/repos/" + githubName + "/" + repository + "/contents/blogs/" + path;

            // Initial GET request to check if the file exists
            Request getRequest = new Request.Builder()
                    .url(requestUrl)
                    .addHeader("Accept", "application/vnd.github+json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

            String sha = null;
            try (Response getResponse = client.newCall(getRequest).execute()) {
                // If file exists, extract the sha value
                if (getResponse.code() == 200) {
                    String jsonResponse = getResponse.body().string();
                    JSONObject jsonObject = com.alibaba.fastjson2.JSON.parseObject(jsonResponse);
                    sha = jsonObject.getString("sha");
                }
            }

            // Prepare the JSON body for the PUT request
            String jsonBody = "{\"message\":\"" + commitMessage + "\","
                    + "\"committer\":{\"name\":\"" + githubName + "\", \"email\":\"" + committerEmail + "\"},"
                    + "\"content\":\"" + contentBase64 + "\"" + (sha != null ? ",\"sha\":\"" + sha + "\"" : "") + "}";

            RequestBody body = RequestBody.create(jsonBody, JSON);
            Request putRequest = new Request.Builder()
                    .url(requestUrl)
                    .addHeader("Accept", "application/vnd.github+json")
                    .addHeader("Authorization", "Bearer " + token)
                    .put(body)
                    .build();

            // Execute the PUT request
            try (Response putResponse = client.newCall(putRequest).execute()) {
                log.info("请求github返回：" + putResponse.body().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
