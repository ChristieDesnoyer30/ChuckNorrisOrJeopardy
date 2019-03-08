package com.detroitlabs.chucknorris.Controller;

import com.detroitlabs.chucknorris.Model.ChuckNorrisFacts;
import com.detroitlabs.chucknorris.Model.Gif;
import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
import com.detroitlabs.chucknorris.Service.ChuckNorrisService;
import com.detroitlabs.chucknorris.Service.GIFService;
import com.detroitlabs.chucknorris.Service.JeopardyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.Random;


@Controller
public class JeopardyController {
    @Autowired
    JeopardyService jeopardyService;

    @Autowired
    ChuckNorrisService chuckNorrisService;

    @Autowired
    GIFService gifService;



    @ResponseBody
    @RequestMapping("jeopardy")
    public ModelAndView displayCQuestion() {
        ModelAndView mv = new ModelAndView("jeopardy");
        JeopardyListOfQuestions jeopardyListOfQuestions = jeopardyService.fetchAnswers();
        mv.addObject("question", jeopardyListOfQuestions.get(0).getQuestion());
        mv.addObject("answer", jeopardyListOfQuestions.get(0).getAnswer());
        mv.addObject("dollars", jeopardyListOfQuestions.get(0).getDollarAmount());
        return mv;
    }

    @RequestMapping("jeopardyquestion")
    public ModelAndView checkAnswer(@RequestParam("actualanswer") String actualAnswer, @RequestParam("answer") String userEnteredAnswer){
        ModelAndView mv = new ModelAndView("results");
        ChuckNorrisFacts cNFact= chuckNorrisService.fetchFacts();
        Gif answerIsCorrectGif = gifService.fetchGifs();

        if(userEnteredAnswer.toLowerCase().contains(actualAnswer.toLowerCase())){
            mv.addObject("results", answerIsCorrectGif.getGifData().getEmbed_url());
        } else {
            mv.addObject("results", "You are incorrect, heres a Chuck Norris Fact. " + cNFact.getValue());
        }
        System.out.println(actualAnswer);
        System.out.println(userEnteredAnswer);

        return mv;

    }
}
