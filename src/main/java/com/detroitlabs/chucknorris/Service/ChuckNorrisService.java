package com.detroitlabs.chucknorris.Service;

import com.detroitlabs.chucknorris.Model.ChuckNorrisFacts;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChuckNorrisService {

    public ChuckNorrisFacts fetchFacts(){

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.USER_AGENT, "Let me in!");
        headers.add("X-RapidAPI-Key", "s6Xvx7EqskmshZNrmbCvHYXk5Isfp1pqTEnjsn7Bz7z5V0WXmR"); // adding the key from the application.properties file
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        RestTemplate restTemplate = new RestTemplate();

        // Make the Request.
        ResponseEntity<ChuckNorrisFacts> response = restTemplate.exchange("https://api.chucknorris.io/jokes/random",
                HttpMethod.GET, new HttpEntity<>(headers),ChuckNorrisFacts.class);

        ChuckNorrisFacts chuckNorrisFacts = response.getBody();

            return chuckNorrisFacts;
    }


}
