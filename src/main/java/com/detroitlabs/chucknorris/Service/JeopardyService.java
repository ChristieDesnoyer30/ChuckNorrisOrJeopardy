package com.detroitlabs.chucknorris.Service;

import com.detroitlabs.chucknorris.Model.JeopardyFacts;
import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Component
public class JeopardyService {

    public JeopardyListOfQuestions fetchAnswers(){

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject("http://jservice.io/api/clues", JeopardyListOfQuestions.class);
    }
}
