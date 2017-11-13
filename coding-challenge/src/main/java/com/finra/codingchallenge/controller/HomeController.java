package com.finra.codingchallenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finra.codingchallenge.utils.Constants;

/**
 * @author Abhinav Akey
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String welcomePage(Model model) {
    	LOG.debug("Welcome page Controller");
        return Constants.WELCOME_VIEW;
    }
}
