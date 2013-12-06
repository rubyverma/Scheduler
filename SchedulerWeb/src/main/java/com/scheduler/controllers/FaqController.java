package com.scheduler.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scheduler.models.Appointment;
import com.scheduler.models.Category;
import com.scheduler.models.Faq;
import com.scheduler.services.CategoryService;
import com.scheduler.services.FaqService;

@RequestMapping("/faq")
@Controller
public class FaqController extends SessionController{
	
	@Autowired(required = true)
	private FaqService faqService;
	
	@Autowired(required = true)
	private CategoryService categoryService;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newFaq(Model model) {
		addUserModel(model);
		return "faq/new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFaq(@ModelAttribute("faq") Faq faq, Model model) {
		//TODO would be fetched from the session variable;
		addUserModel(model);
		faq.setOfficialId(Integer.parseInt(sessionMap.get("id")));
		faqService.addFaq(faq);
		System.out.println(faq.getCategoryId());
		System.out.println(faq.getFaqQuestion());
		System.out.println(faq.getFaqAnswer());
		return "redirect:/category/view";
	}
	
	@RequestMapping(value = "/delete/{faqId}", method = RequestMethod.GET)
	public String deleteFaq(@PathVariable("faqId") int faqId, Model model,RedirectAttributes redirectAttributes) {
		int i = faqService.deleteFaq(faqId);
		if (i>0){
			redirectAttributes.addFlashAttribute("result", "FAQ removed successfully");
			redirectAttributes.addFlashAttribute("infotype","S");
		}
		else {
			redirectAttributes.addFlashAttribute("result", "FAQ cannot be removed");
			redirectAttributes.addFlashAttribute("infotype","F");
		}
		System.out.println(i);
		return "redirect:/category/view";
	}

	@RequestMapping(value = "/edit/{faqId}", method = RequestMethod.GET)
	public String editFaq(@PathVariable("faqId") int faqId, Model model) {
		addUserModel(model);
		List<Category> categories = categoryService.getAllCategory();
		Faq faq = faqService.getFaq(faqId);
		model.addAttribute("faq", faq);
		model.addAttribute("categories", categories);
		model.addAttribute("faqId", faqId);
		return "faq/adminupdatefaq";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateFaq(@ModelAttribute("faq")Faq faq, Model model) {
		//TODO would be fetched from the session variable;
		faq.setOfficialId(Integer.parseInt(sessionMap.get("id")));
		int i = faqService.updateFaq(faq);
		System.out.println(faq.getFaqId());
		return "redirect:/category/view";
	}

}
