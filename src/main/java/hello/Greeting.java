package hello;

// Used as response entity for a REST call
// (mapped to JSON by the framework based on member names)

public class Greeting {

    private String message;

	public void setMessage(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}