package com.detroitlabs.chucknorris.Controller;

import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
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



    @ResponseBody
    @RequestMapping("jeopardy")
    public ModelAndView displayCQuestion() {
        ModelAndView mv = new ModelAndView("jeopardy");
        JeopardyListOfQuestions jeopardyListOfQuestions = jeopardyService.fetchAnswers();
        Random random = new Random();
        int questionIndex = random.nextInt(100);
        int answerIndex = questionIndex;
        mv.addObject("question", jeopardyListOfQuestions.get(questionIndex).getQuestion());
        mv.addObject("answer", jeopardyListOfQuestions.get(answerIndex).getAnswer());


        return mv;
    }

    @RequestMapping("jeopardyquestion")
    public ModelAndView checkAnswer(@RequestParam("actualanswer") String actualAnswer, @RequestParam("answer") String userEnteredAnswer){
        ModelAndView mv = new ModelAndView("results");


        if(userEnteredAnswer.toLowerCase().contains(actualAnswer.toLowerCase())){
            mv.addObject("results", "you are correct!");
        } else {
            mv.addObject("results", "INCORRECT");
        }
        System.out.println(actualAnswer);
        System.out.println(userEnteredAnswer);

        return mv;

    }
}
