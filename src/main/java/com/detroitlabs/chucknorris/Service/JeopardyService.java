package com.detroitlabs.chucknorris.Service;


import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class JeopardyService {

    public JeopardyListOfQuestions fetchAnswers(){

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://jservice.io/api/random", JeopardyListOfQuestions.class);
    }
}
