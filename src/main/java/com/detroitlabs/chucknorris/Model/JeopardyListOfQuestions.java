package com.detroitlabs.chucknorris.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class JeopardyListOfQuestions  extends ArrayList<JeopardyFacts> {



}
