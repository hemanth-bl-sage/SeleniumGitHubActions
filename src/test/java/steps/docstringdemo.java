package steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DocStringType;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class docstringdemo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @DocStringType
    public JsonNode json(String docString) throws IOException {
        return objectMapper.readTree(docString);
    }

    @Given("I see some information")
    public void iSeeSomeInformation(JsonNode jsonNode) {
        var name = jsonNode.get("Name");
        var comp = jsonNode.get("Company");
        System.out.println("Name: "+name+" Company: "+comp);
    }
}
