package edu.escuelaing.arep.app;

import static spark.Spark.*;

import java.io.IOException;
import java.net.MalformedURLException;

import spark.Request;
import spark.Response;
import org.json.*;

import calculadoraTrig.Calculadora;
import calculadoraTrig.CalculadoraImpl;


/**
 * App
 * @author andre
 *
 */	
public class App {
    public static void main( String[] args ) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));   
    }
    
    /**
	 * Funcion que imprime formulario y lo evalua
	 * @param req
	 * @param res
	 * @return
	 */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>BIENVENIDO A SERVICIO</h2>"
                + "<form action=\"/results\">"
                + "  Ingrese los valores a calcular como cos, sin, tan seguidos de '=' y el numero para realizar la operacion<br>"
                + "  <input type=\"text\" name=\"numero\" >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    
    
    /**
	 * Funcion encargada de responder el json correspondiente
	 * @param req
	 * @param res
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
  
    private static JSONObject resultsPage(Request req, Response res) {
    	
        String[] listar= req.queryParams("numero").split("=");
        double number = Double.parseDouble(listar[1]);
          
        
        double resultado = 0;
        Calculadora calcular = new CalculadoraImpl();
        if (listar[0].equals("cos") )resultado = calcular.cos(number);
        if (listar[0].equals("sin") )resultado = calcular.sin(number);
        if (listar[0].equals("tan") )resultado = calcular.tan(number);
        
        
        res.header("Content-Type","application/json");        

        JSONObject conversion = new JSONObject();
        conversion.put("El resultado de su operacion es", resultado);
        
        return conversion;
    }
    
    /**
	 * Funcion que se encarga de gestionar el puerto correspondiente
	 * @return
	 */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }        
           
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
    }
}