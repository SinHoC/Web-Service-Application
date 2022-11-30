package com.TeamTemple.TTempleProject.Controller;

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

import java.util.List;
import java.util.concurrent.ExecutionException;

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
	public String joinOrder(@RequestParam String documentId,@RequestParam String phone, @RequestParam(value="customer") List<String> customer) throws InterruptedException, ExecutionException {
		return dbService.joinOrder(documentId, phone, customer);
	}
	
	// Get all orders for home page
	@GetMapping("/getAll")
	public List<Order> getAllOrders() throws InterruptedException, ExecutionException {
		return dbService.getAllOrders();
	}
	
	// Get created orders for user
	@GetMapping("/getCreated")
	public List<Order> getCreatedOrders(@RequestParam String phone) throws InterruptedException, ExecutionException {
		return dbService.getCreatedOrders(phone);
	}
	
	@GetMapping("/getJoined")
	public List<Order> getJoined(@RequestParam String phone) throws InterruptedException, ExecutionException{
		return dbService.getJoinedOrders(phone);
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
}
