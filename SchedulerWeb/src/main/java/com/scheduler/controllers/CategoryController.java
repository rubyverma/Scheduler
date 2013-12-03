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

import com.scheduler.models.Category;
import com.scheduler.models.Faq;
import com.scheduler.services.CategoryService;
import com.scheduler.services.FaqService;

@RequestMapping("/category")
@Controller
public class CategoryController extends SessionController {
	
	@Autowired(required = true)
	private CategoryService categoryService;
	
	@Autowired(required = true)
	private FaqService faqService;
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAll(Model model) {
		List<Category> categories = categoryService.getAllCategory();
		for (Category category:categories){
			category.setFaqs(faqService.getAllFaqByCategory(category.getCategoryId()));
		}
		model.addAttribute("category", new Category());
		model.addAttribute("faq", new Faq());
		model.addAttribute("categories",categories);
		addUserModel(model);
		return "faq/adminfaq";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCategory(Model model) {
		addUserModel(model);
		return "faq/newcategory";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("category") Category category,Model model) {
		//TODO would be fetched from the session variable;
		addUserModel(model);
		int officialId = Integer.parseInt(sessionMap.get("id"));
		category.setOfficialId(officialId);
		categoryService.addCategory(category);
		System.out.println(category.getCategoryName());
		return "redirect:/category/view";
	}
	
	@RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("categoryId")int categoryId, Model model,RedirectAttributes redirectAttributes) {
		List<Faq> faqs = faqService.getAllFaqByCategory(categoryId);
		if (faqs.size()>0){
			redirectAttributes.addFlashAttribute("result", "Category cannot be removed");
			redirectAttributes.addFlashAttribute("infotype","F");
		}
		else {
			int i = categoryService.deleteCategory(categoryId);
			redirectAttributes.addFlashAttribute("result", "Category removed successfully");
			redirectAttributes.addFlashAttribute("infotype","S");
		}
		
		System.out.println(categoryId);
		addUserModel(model);
		return "redirect:/category/view";
	}

	@RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.GET)
	public String editCategory(@PathVariable("categoryId")int categoryId, Model model) {
		Category category = categoryService.getCategory(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("categoryId", categoryId);
		addUserModel(model);
		return "faq/adminupdatecategory";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") Category category, Model model) {
		//TODO would be fetched from the session variable;
		addUserModel(model);
		int officialId = Integer.parseInt(sessionMap.get("id"));
		category.setOfficialId(officialId);
		int i = categoryService.updateCategory(category);
		System.out.println(category.getCategoryId());
		return "redirect:/category/view";
	}
}
