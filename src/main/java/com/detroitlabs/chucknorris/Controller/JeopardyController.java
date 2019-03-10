package com.detroitlabs.chucknorris.Controller;

import com.detroitlabs.chucknorris.Model.Gif;
import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
import com.detroitlabs.chucknorris.Service.GIFService;
import com.detroitlabs.chucknorris.Service.JeopardyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class JeopardyController {
    @Autowired
    JeopardyService jeopardyService;

    @Autowired
    GIFService gifService;


    @RequestMapping("/")
    public ModelAndView displayHomePage() {
        ModelAndView mv = new ModelAndView("home");

        return mv;

    }

    @ResponseBody
    @RequestMapping("jeopardy")
    public ModelAndView displayCQuestion() {
        ModelAndView mv = new ModelAndView("jeopardy");
        JeopardyListOfQuestions jeopardyListOfQuestions = jeopardyService.fetchAnswers();
        mv.addObject("category", jeopardyListOfQuestions.get(0).getCategory().getTitle());
        mv.addObject("question", jeopardyListOfQuestions.get(0).getQuestion());
        mv.addObject("answer", jeopardyListOfQuestions.get(0).getAnswer());
        mv.addObject("dollars", jeopardyListOfQuestions.get(0).getDollarAmount());
        return mv;
    }

    @RequestMapping("jeopardyquestion")
    public ModelAndView checkAnswer(@RequestParam("actualanswer") String actualAnswer, @RequestParam("answer") String userEnteredAnswer){
        ModelAndView mv = new ModelAndView("results");


        if(userEnteredAnswer.toLowerCase().contains(actualAnswer.toLowerCase())){
            Gif answerIsCorrectGif = gifService.fetchGifs(userEnteredAnswer);

            mv.addObject("results", true);
            mv.addObject("correctAnswer", answerIsCorrectGif.getGifData().getImage_url());


        } else{
            Gif answerIsNotCorrectGif = gifService.fetchGifs("wrong");
            mv.addObject("results", false);
            mv.addObject("incorrectAnswer", answerIsNotCorrectGif.getGifData().getImage_url());
        }

        System.out.println(actualAnswer);
        System.out.println(userEnteredAnswer);

        return mv;

    }
}
