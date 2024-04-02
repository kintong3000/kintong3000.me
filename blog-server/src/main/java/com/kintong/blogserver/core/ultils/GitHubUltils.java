package com.kintong.blogserver.core.ultils;

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

    public void updateRepositoryContent( String path, String contentBase64) {
        try {
            String requestUrl = "https://api.github.com/repos/" + githubName + "/" + repository + "/contents/blogs/" + path;
            String jsonBody = "{\"message\":\"" + commitMessage + "\","
                    + "\"committer\":{\"name\":\"" + githubName + "\", \"email\":\"" + committerEmail + "\"},"
                    + "\"content\":\"" + contentBase64 + "\"}";

            RequestBody body = RequestBody.create(jsonBody, JSON);
            Request request = new Request.Builder()
                    .url(requestUrl)
                    .addHeader("Accept", "application/vnd.github+json")
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("X-GitHub-Api-Version", "2022-11-28")
                    .put(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                log.info("请求github返回："+response.body().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
