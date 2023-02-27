package hello;

// Used as parameter for a REST call
// (mapped from JSON by the framework based on member names)

public class Content {

    private String name;

	public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
}