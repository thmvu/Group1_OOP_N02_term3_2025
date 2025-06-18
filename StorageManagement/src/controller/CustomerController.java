package controller;

import model.Product;
import org.springframework.web.bind.annotation.*;
import repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/{id}/products")
    public List<Product> getProductsByCustomer(@PathVariable("id") int customerId) {
        return OrderRepository.getProductsByCustomerId(customerId);
    }
}
