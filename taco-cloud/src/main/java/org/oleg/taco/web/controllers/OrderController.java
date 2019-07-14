package org.oleg.taco.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.oleg.taco.entity.Order;
import org.oleg.taco.dao.interfaces.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}
	@PostMapping
	public String processOrder(@Valid Order order, Errors errors,
								SessionStatus sessionStatus) {
		if(errors.hasErrors()) {
			return "orderForm";
		}
		orderRepository.save(order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
}
