package com.example.pttk.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.boot.reactor.DebugAgentEnvironmentPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pttk.dao.ProductDAO;
import com.example.pttk.daoImpl.CartDAOImpl;
import com.example.pttk.daoImpl.OrderDAOImpl;
import com.example.pttk.daoImpl.ProductDAOImpl;
import com.example.pttk.daoImpl.UserDAOImpl;
import com.example.pttk.model.Account;
import com.example.pttk.model.Address;
import com.example.pttk.model.Product;
import com.example.pttk.model.Shipment;
import com.example.pttk.model.Cart;
import com.example.pttk.model.Order;
import com.example.pttk.model.Payment;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoMoCController {
	ProductDAOImpl pDao = new ProductDAOImpl();
	UserDAOImpl uDao = new UserDAOImpl();
	CartDAOImpl cDao = new CartDAOImpl();
	OrderDAOImpl oDao = new OrderDAOImpl();
	@RequestMapping("/loginForm")
    public String FormLogin(@ModelAttribute("account")Account account, Model model){
        model.addAttribute("account",new Account());
        return "login";
    }
	
	@RequestMapping("/login")
    public String Login(@ModelAttribute("account")Account account, Model model, HttpSession session){
        int id = uDao.login(account.getUsername(), account.getPassword());
        if(id != -1)
        {
        	session.setAttribute("id", id);
        	return "redirect:/browse";
        }
        else {
        	model.addAttribute("account",new Account());
            model.addAttribute("error","Username or Password is incorrect");
            return "login";
		}
        
    }
	@GetMapping("/browse")
	public String getModels(Model model, HttpSession session) {
		List<Product> products = pDao.SelectAllProducts();
		int id = -1;
		if(session.getAttribute("id") != null)
			id = (int) session.getAttribute("id");
		model.addAttribute("id", id);
		System.out.println("GET PRODUCTS");
		model.addAttribute("products", products);
		return "products";
	}
	@GetMapping("/product/{id}")
	public String getModel(Model model, @PathVariable int id) {
		Product product = pDao.SelectProduct(id);
		model.addAttribute("id", id);
		System.out.println(id);
		model.addAttribute("product", product);
		System.out.println(product);
		return "product-detail";
	}
	@GetMapping("/AddCart/{id}")
	public String AddToCart(Model model, @PathVariable String id) {
		String[] s = id.split("-");
		cDao.AddProduct(Integer.valueOf(s[1]), Integer.valueOf(s[0]));
		return "redirect:/browse";
	}
	@GetMapping("/Cart/{id}")
    public String OwnCart(Model model, @PathVariable String id){
		Cart cart = cDao.GetCart(Integer.valueOf(id));
		List<Address> addresses = uDao.GetAllAddress(Integer.valueOf(id));
    	model.addAttribute("cart",cart);
    	model.addAttribute("addresses",addresses);
    	for (Address address : addresses) {
			System.out.println(address);
		}
        return "own-cart";
        
    }
	@GetMapping("/ChangeQuantity/{id}")
    public String ChangeQuantity(Model model, @PathVariable String id){
		String[] s = id.split("-");
		cDao.ChangeQuantityItems(Integer.valueOf(s[1]), Integer.valueOf(s[2]));
        return "redirect:/Cart/" + s[0];
    }
	@GetMapping("/CheckOut/{id}")
    public String CheckOut(Model model, @PathVariable String id){
		String[] s = id.split("-");
		Cart cart = cDao.GetCart(Integer.valueOf(s[3]));
		Address address =uDao.GetAddress(Integer.valueOf(s[0]));
		Shipment shipment = new Shipment(0, address, s[2]);
		Payment payment = new Payment(0, s[1], "Processing", shipment.getFee(), cart.getTotalPrice());
		System.out.println(address);
		model.addAttribute("user",uDao.SelectUser(cart.getIdCus()));
    	model.addAttribute("cart",cart);
    	model.addAttribute("shipment",shipment);
    	model.addAttribute("payment",payment);
        return "checkout";
        
    }
	@GetMapping("/SaveOrder/{id}")
    public String SaveOrder(Model model, @PathVariable String id){
		String[] s = id.split("-");
		Cart cart = cDao.GetCart(Integer.valueOf(s[3]));
		Address address =uDao.GetAddress(Integer.valueOf(s[0]));
		Shipment shipment = new Shipment(0, address, s[2]);
		Payment payment = new Payment(0, s[1], "Processing", shipment.getFee(), cart.getTotalPrice());
		oDao.saveOrder(new Order(0, cart, shipment, payment));
    	return "redirect:/browse";
        
    }
}
