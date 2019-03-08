package com.detroitlabs.chucknorris.Service;


import com.detroitlabs.chucknorris.Model.Gif;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class GIFService {



        public Gif fetchGifs(){

            RestTemplate restTemplate = new RestTemplate();

            return restTemplate.getForObject("https://api.giphy.com/v1/gifs/random?api_key=qMWpPY3uSRMO3cjUQ3ZtzgtlLsAvJl9U&tag=&rating=G"
                    , Gif.class);
        }

}
