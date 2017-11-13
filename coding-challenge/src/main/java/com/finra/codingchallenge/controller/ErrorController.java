package com.finra.codingchallenge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
@RequestMapping(Constants.UAS_ACTION_ERROR)
public class ErrorController {

	private static final Logger LOG = LoggerFactory.getLogger(ErrorController.class);

	private static final String RETURN_ERROR_400 = "400", RETURN_ERROR_500 = "500";

	@RequestMapping(method = RequestMethod.GET)
	public String handleError(Model model, HttpServletRequest request, HttpServletResponse response) {

		LOG.debug("Inside handleError.");
		String error = request.getParameter(Constants.URL_PARAM_ERROR_CODE);
		LOG.debug("error = " + error);

		if (StringUtils.isBlank(error)) {
			return Constants.ERROR_PAGE;
		}

		switch (error.toLowerCase()) {
		case RETURN_ERROR_400:
			response.setStatus(400);
			return Constants.ERROR_PAGE;
		case RETURN_ERROR_500:
			response.setStatus(500);
			return Constants.ERROR_PAGE;
		default:
			return Constants.ERROR_PAGE;
		}
	}
}
