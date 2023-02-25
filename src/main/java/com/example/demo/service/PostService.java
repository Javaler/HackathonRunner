package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ResponseBody;
import com.example.demo.entity.Post;
import com.example.demo.form.QuestionForm;
import com.example.demo.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private static final String API_REQUEST_URL = "https://hackathonrunner-analysis-api.azurewebsites.net/api/hello?code=IthH2RAQ_z3DRtzglmAVSnPPI5p8NER2vJFZN3ucy0NpAzFuzYtrmw%3D%3D";

    @Value("${azure.functions.master-key}")
    private String MASTER_KEY;

    public List<Post> createRecommendPostList(QuestionForm questionForm) {

        int[] recommendPostIds = callAPI(questionForm);
        int[] recommendPostIdsTop5 = Arrays.copyOf(recommendPostIds, 5);
        List<Integer> recommmendPostIdList = Arrays.stream(recommendPostIdsTop5).boxed().collect(Collectors.toList());;
        List<Post> recommendPostList = postRepository.findAllById(recommmendPostIdList);

        return recommendPostList;
    }

    private int[] callAPI(QuestionForm questionForm) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-functions-key", MASTER_KEY);

        HttpEntity<QuestionForm> entity = new HttpEntity<>(questionForm, headers);

        // リクエストの送信
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseBody> responseEntity = restTemplate.exchange(API_REQUEST_URL, HttpMethod.POST, entity, ResponseBody.class);

        // 結果の取得
        HttpStatus status = responseEntity.getStatusCode();
        System.out.println(status);

        ResponseBody responseBody = responseEntity.getBody();

        if (responseBody == null) {
            return null;
        } else {
            return responseBody.getRecom_res();
        }
    }

}
