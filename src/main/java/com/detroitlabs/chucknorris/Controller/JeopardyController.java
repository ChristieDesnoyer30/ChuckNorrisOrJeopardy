package com.detroitlabs.chucknorris.Controller;


import com.detroitlabs.chucknorris.Model.JeopardyFacts;
import com.detroitlabs.chucknorris.Model.JeopardyListOfQuestions;
import com.detroitlabs.chucknorris.Service.JeopardyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Random;

@Controller
public class JeopardyController {
    @Autowired
    JeopardyService jeopardyService;



    @ResponseBody
    @RequestMapping("jeopardy")
    public ModelAndView displayCategories() {
        ModelAndView mv = new ModelAndView("jeopardy");

       JeopardyListOfQuestions jeopardyListOfQuestions = jeopardyService.fetchAnswers();

       int random = Math.random()

       mv.addObject("question", jeopardyListOfQuestions.get(0).getQuestion());



        return mv;


    }
}
