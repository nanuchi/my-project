package hello;

// The key class

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api") // prefix for all methods
@RestController
public class GreetingController {

	private String greetingMessage=new String("");

	// The base URL returns a list of endpoints available
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity helpGET() {
        ResponseEntity response = 
            new ResponseEntity(new String("Available endpoints:api(GET)/greeting(GET/POST)"),
                               HttpStatus.OK);
        return response;
    }

    // The set greeting endpoint
	// The framework converts the JSON info "name": "..." to a Content
	// object with the value passed as input in the field "name"
	@RequestMapping(value="/greeting", method = RequestMethod.POST)
    public ResponseEntity greetingPOST(@RequestBody Content content) {
		greetingMessage=new String(content.getName());
        ResponseEntity response = 
            new ResponseEntity(new String("Greeting set to " + greetingMessage), HttpStatus.OK);
        return response;
    }

    // The get greeting endpoint
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
    public ResponseEntity greetingGET() {
		Greeting greeting=new Greeting();
		if (greetingMessage.length() == 0) greeting.setMessage("Sorry, no greeting yet");
		else greeting.setMessage("Hello, " + greetingMessage + "!");
        ResponseEntity response = new ResponseEntity(greeting, HttpStatus.OK);
        return response;
    }
}