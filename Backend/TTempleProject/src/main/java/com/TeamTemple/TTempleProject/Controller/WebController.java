package com.TeamTemple.TTempleProject.Controller;

import org.apache.commons.math3.stat.Frequency;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TeamTemple.TTempleProject.DBService;
import com.TeamTemple.TTempleProject.Order;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WebController {
	
	public DBService dbService;
	
	public WebController(DBService dbService) {
		this.dbService = dbService;
	}
	
	// Create a new order
	@PostMapping("/create")
	public String createOrder(@RequestBody Order order) throws InterruptedException, ExecutionException {
		return dbService.createOrder(order);
	}
	
	// Get single order
	@GetMapping("/get")
	public Order getOrder(@RequestParam String documentId) throws InterruptedException, ExecutionException {
		return dbService.getOrder(documentId);
	}
	
	// Get all orders for home page
	@PutMapping("/join")
	public String joinOrder(@RequestParam String documentId,@RequestParam String namePhone, @RequestParam(value="customer") List<String> customer) throws InterruptedException, ExecutionException {
		return dbService.joinOrder(documentId, namePhone, customer);
	}
	
	// Get all orders for home page
	@GetMapping("/getAll")
	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		return dbService.getAllOrders();
	}
	
	// Get created orders for user
	@GetMapping("/getCreated")
	public List<Order> getCreatedOrders(@RequestParam String name, @RequestParam String phoneNumber) throws InterruptedException, ExecutionException {
		return dbService.getCreatedOrders(name, phoneNumber);
	}
	
	@GetMapping("/getJoined")
	public List<Order> getJoined(@RequestParam String namePhone) throws InterruptedException, ExecutionException{
		return dbService.getJoinedOrders(namePhone);
	}
	
//	@GetMapping("/getCustomers")
//	public Map<String, Object> getCustomers(@RequestParam String namePhone) throws InterruptedException, ExecutionException{
//		return dbService.getCustomers(namePhone);
//	}
	
	// Get all orders for home page
	@PutMapping("/delete")
	public String deleteOrder(@RequestParam String documentId) throws InterruptedException, ExecutionException {
		return dbService.deleteOrder(documentId);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testGetEndpoint(){
		return ResponseEntity.ok("Test is working");
	}
	
	
    
    @GetMapping("/")
    public String getString() {
        return "Welcome to the Home Page";
    }

    @GetMapping("/frequency")
    public double[] someMath() {
        double[] result = new double[2];
        Frequency f = new Frequency();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            f.addValue(rand.nextInt(21));
        }
        result[0] = f.getUniqueCount();
        result[1] = f.getCumPct(10);
        return result;
    }
    
//    @GetMapping("/order1")
//    public List<Order> order1() {
//        Order  order = new Order("Melvin Chiem-Ngoy", "123-456-7890");
//        Order  order2 = new Order("Yu Sun", "123-123-1234");
//        Order  order3 = new Order("D'Brickashaw Ferguson", "109-876-5432");
//        
//        List<Order> list = new ArrayList<Order>();
//        list.add(order);
//        list.add(order2);
//        list.add(order3);
//        
//        return list;
//    }

    @RequestMapping("/A")
    public int multiply(int a, int b) {
        return a*b;

    }
    
        @RequestMapping("/Subtraction")
    public int subtract(int a, int b) {
        return a-b;

    }
    
    @RequestMapping("/Calculator")
    public int Calculator(int a, int b) {
        return a+b;

    }
    

    @RequestMapping("/C")
    public void soup() {
        try {
            String url = "http://ocw.mit.edu/courses/aeronautics-and-astronautics/16-050-thermal-energy-fall-2002/";
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("p");
            for (Element p : paragraphs) {
                System.out.println(p.text());
            }
        } catch (IOException ex) {
            Logger.getLogger(WebController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
