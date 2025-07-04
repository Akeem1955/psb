package com.prime_stack.customer_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.prime_stack.customer_info.model.Customer;
import com.prime_stack.customer_info.model.CustomerRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/psb")
public class CustomerInfo {
    @Autowired
    CustomerRepo repo;


    @GetMapping("/customer_info")
    String saveCustomerInfo(Model model, HttpServletResponse response){
        model.addAttribute("customer", new Customer());
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies
        return "customer_info";
    }

    @PostMapping("/save_customer_info")
    public String postMethodName(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
       
        if(customer != null && customer.customerId != null)
        {
            if(repo.existsById(customer.customerId)){
                customer.markAsNotNew();
                redirectAttributes.addFlashAttribute("message", "Customer ID already exists.");
                redirectAttributes.addFlashAttribute("status", "error");
                return "redirect:/psb/customer_info";
            }else{
                repo.save(customer);
                System.out.println("Customer saved: " + customer.toString());
                redirectAttributes.addFlashAttribute("message", "Customer saved successfully!");
                redirectAttributes.addFlashAttribute("status", "success");
                return "redirect:/psb/customer_info";
            }
        }
        else if (customer != null && customer.customerId == null)
        {
            redirectAttributes.addFlashAttribute("message", "Customer ID is required.");
            redirectAttributes.addFlashAttribute("status", "error");
            return "redirect:/psb/customer_info";
        }
        else
        {
            redirectAttributes.addFlashAttribute("message", "All Field Are Required...");
            redirectAttributes.addFlashAttribute("status", "error");
            return "redirect:/psb/customer_info";
        }
       
    }    
}
   