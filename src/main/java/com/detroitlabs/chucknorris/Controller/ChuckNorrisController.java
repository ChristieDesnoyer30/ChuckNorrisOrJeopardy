package com.detroitlabs.chucknorris.Controller;

import com.detroitlabs.chucknorris.Model.ChuckNorrisFacts;
import com.detroitlabs.chucknorris.Service.ChuckNorrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ChuckNorrisController {


    @Autowired
    ChuckNorrisService chuckNorrisService;

    @ResponseBody
    @RequestMapping("/")
    public ModelAndView displayCategories() {
        ModelAndView mv = new ModelAndView("home");
        ChuckNorrisFacts chuckNorrisFacts = chuckNorrisService.fetchFacts();
        mv.addObject("image", chuckNorrisFacts.getIcon_url());
        mv.addObject("fact", chuckNorrisFacts.getValue());
        System.out.println(chuckNorrisFacts.getValue());

        return mv;

    }
}
