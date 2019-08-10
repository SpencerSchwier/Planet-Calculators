package com.techelevator.ssg.controller;

import javax.validation.Valid;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.ssg.model.calculators.AlienCalculators;
import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;

@Controller
public class ForumController {
	
	@Autowired
	private ForumDao forumDao;
	
	@RequestMapping("/spaceForum")
	public String displaySpaceForum(ModelMap modelMap) {
		modelMap.put("forumPosts", forumDao.getAllPosts());
		return "spaceForum";
	}
	
	@RequestMapping("/postMessage")
	public String displayNewGeekPost(ModelMap modelMap) {
		
		if(modelMap.containsAttribute("newPost") == false) {
			ForumPost empty = new ForumPost();
			modelMap.put("newPost", empty);
		}
		
		return "postMessage";
	}
	
	@RequestMapping(path="/postMessageResult", method=RequestMethod.POST)
	public String processForumPost(@Valid @ModelAttribute ForumPost newPost,
									BindingResult result,
									RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			redirectAttributes.addFlashAttribute("newPost", newPost);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "newPost", result);
			return "redirect:/postMessage";
		}
		
		newPost.setDatePosted(LocalDateTime.now());
		forumDao.save(newPost);
		return "redirect:/spaceForum";
	}

}
