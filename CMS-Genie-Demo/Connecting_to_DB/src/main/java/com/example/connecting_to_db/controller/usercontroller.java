package com.example.connecting_to_db.controller;

import com.example.connecting_to_db.entity.Userdetails;
import com.example.connecting_to_db.repository.userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class usercontroller {
    @Autowired
    private userepository repo;

    @Autowired
    private BCryptPasswordEncoder bp;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", null); // Clear message when loading the page
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute Userdetails u, Model model) {
        u.setPassword(bp.encode(u.getPassword()));
        u.setRole("ROLE_USER");
        repo.save(u);
        model.addAttribute("message", "User registered successfully.");
        return "register"; // Returning the register view with the message
    }
}


//      @Controller ---->@Controller in Spring Boot handles HTTP requests and, when returning a view name (like "home"), it searches for a corresponding template (e.g., home.html) in the templates folder.
//                          For example, if you return "home", Spring Boot looks for a file named home.html in the src/main/resources/templates/ directory to render it for the user.
//                       If the view (e.g., home.html) is not found in the templates folder, Spring Boot will throw an error, typically resulting in:
//                          404 Error (Not Found): The application will fail to render the page, and the user will see a 404 - Not Found error.

//      @RestController---->If you use @RestController, it will always return data in formats like JSON or XML. It doesn't send to HTML pages.
//                          So, if there is no HTML page involved, the server will send raw data like JSON instead.

//      @Autowired-----> is a Spring annotation used for automatic dependency injection. It allows Spring to automatically inject the required dependencies (objects) into a class.

//      Model-----> In Spring, Model is an interface used to pass data between a controller and a view in a @Controller. It acts as a container for the data that needs to be displayed in the view (usually HTML).
//          Purpose:
//              Model stores data that the controller prepares and passes to the view for rendering (e.g., displaying user details or a list of items).
//          How it works:
//              In the controller method, you add data to the Model.
//              The view (usually HTML or JSP) can access that data and display it.

//      @ModelAttribute---->