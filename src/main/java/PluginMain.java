import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import http.server.response.HttpResponse;
import http.server.serviceloader.PluginType;

@PluginType("/v1/calculator")
public class PluginMain {
	
	private static String[] tasks = {"add", "sub", "mult", "div", "sqr"};
	Calculator calculator = new Calculator();
    public HttpResponse doSomething(String doThis, Map<String, List<String>> params) {
    	
    	String task = "";
    	switch(task) {
    	
    		case "add":
    			return new HttpResponse(calculator.add(1,1).toString());
    		case "sub":
    			return new HttpResponse(calculator.subtract(1,1).toString());
    		case "mult":
    			return new HttpResponse(calculator.multiply(1,1).toString());
    		case "div":
    			return new HttpResponse(calculator.divide(1,1).toString());
    		case "sqr":
    			return new HttpResponse(calculator.square(1).toString());
    		default:
    			return new HttpResponse("Invalid task");
    			
    	}
    	
    	
    	
    	
    }
}
