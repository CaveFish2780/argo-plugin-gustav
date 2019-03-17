import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import http.server.response.HttpResponse;
import http.server.serviceloader.ARGOPlugin;
import http.server.serviceloader.PluginType;

@PluginType("/v1/calculator")
public class PluginMain implements ARGOPlugin{
	
	private static String[] tasks = {"add", "sub", "mult", "div", "sqr"};
	Calculator calculator = new Calculator();
	
    public HttpResponse doSomething(String doThis, Map<String, List<String>> params) {
    	System.out.println("Hello world");
    	System.out.println();
    	String task = params.get("task").get(0);
    	double num = 0;
    	double num2 = 0;
    	System.out.println(params.entrySet());
		
			try {	
				num = Double.parseDouble(params.get("num").get(0));
				num2 = Double.parseDouble(params.get("num2").get(0));
			}catch(IndexOutOfBoundsException ie){
				ie.printStackTrace();
			}catch(NumberFormatException ne) {
				ne.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
    	
			System.out.println("task = " + task);
			System.out.println("num = " + num);
			System.out.println("num2 = " + num2);
    	
			switch(task) {
    	
    		case "add":
    			System.out.println("add");
    			return new HttpResponse(calculator.add(num, num2).toString());
    		case "sub":
    			return new HttpResponse(calculator.subtract(num, num2).toString());
    		case "mult":
    			return new HttpResponse(calculator.multiply(num, num2).toString());
    		case "div":
    			return new HttpResponse(calculator.divide(num, num2).toString());
    		case "sqr":
    			return new HttpResponse(calculator.square(num).toString());
    		default:
    			System.out.println("invalid task");
    			return new HttpResponse("Invalid task");    			
    	}

}
}
