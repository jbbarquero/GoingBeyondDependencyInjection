package com.pivotal.springone;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pivotal.springone.security.custom.CustomUserDetails;

@Controller
public class SecuredController {
	private static final Logger logger = LoggerFactory.getLogger(SecuredController.class);

	@RequestMapping(value = "/secured", method = RequestMethod.GET)
	public String doSecured(Locale locale, Map model) {
		logger.info("You got access! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.put("serverTime", formattedDate );
		if (principal instanceof CustomUserDetails) {
			model.put("extendedUserDetails", true);
		}
		return "securedPage";
	}
}
