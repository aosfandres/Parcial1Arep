package edu.escuelaing.arep.app;

import static spark.Spark.*;
import spark.Request;
import spark.Response;

public class App {
    public static void main( String[] args ) {
        port(getPort());
        get("/", (req, res) -> inputDataPage(req, res));
         
    }
   
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>BIENVENIDO A SERVICIO</h2>"
                + "<form action=\"/results\">"
                + "  Ingrese los valores a calcular como cos, sin, tan seguidos de '=' y el numero para realizar la operacion<br>"
                + "  <input type=\"text\" name=\"input\" >"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "</body>"
                + "</html>";
        return pageContent;
    }
    
    
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }        
           
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)    }
    }
}