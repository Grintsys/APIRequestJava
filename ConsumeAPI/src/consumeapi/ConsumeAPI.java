/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumeapi;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/**
 *
 * @author sergioperalta
 */
public class ConsumeAPI {

    /**
     * @param args the command line arguments
     */
    
    //Se puede mejorar teniendo una clase que sirva para centralizar todas las llamadas.
    public static void main(String[] args) {
        // TODO code application logic here
        
        String url = "http://52.229.31.185:8091/getdevices";
        
        //httpclient es una libreria para hacer llamados a servicios
         try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            // el objetivo es extraer el json que da como respuesta el servicio que hicimos ne nodejs
            
            //El archivo device.json es un ejemplo de la respuesta a la llamada de este servicio http://52.229.31.185:8091/getdevices
            //Aqui basicamente convertimos el objeto Json a una clase que podamos utilizar.
            Gson gson = new Gson();
            List<Device> devices = gson.fromJson(json, new TypeToken<List<Device>>(){}.getType());
            //new TypeToken<List<Device>>(){}.getType() esta linea basicamente optiene el tipo de datos del archivo json
                   
            //Tambien se puede usar for while o do while pero esto es mas cool
            devices.forEach((d) -> {
                System.out.printf("Name: %s, Status: %d, UpdateDate: %s \n", d.getName(), d.getStatus(), d.getUpdateDate());
            });
            
        } catch (IOException ex) {
            System.out.println("error: "+ex.getMessage());
        }    
    }
    
}
