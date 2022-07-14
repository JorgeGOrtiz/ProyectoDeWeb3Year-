package Rest;

import Entity.Cliente;
import Entity.Transaccion;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import javax.xml.crypto.Data;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestTransaccion {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/Transaccion/";

    //encontrar todos//
    public  List<Transaccion> findAllTransaccion() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Transaccion> list_transaccion = null;
        try {
            list_transaccion = JSONUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<Transaccion>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_transaccion;
    }
    //encontrar por//
    public  Transaccion findByIdTransaccion(int id_transaccion){
        Transaccion transaccion = null;
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "find/"+id_transaccion)).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Transaccion> list_transaccion = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    transaccion = JSONUtils.covertFromJsonToObject(response.get().body(),Transaccion.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return transaccion;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return transaccion;
    }
    //crear//
    public  boolean createTransaccion (Transaccion transaccion){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(transaccion);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"create"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                return false;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            return false;
        } catch (ExecutionException e){
            e.printStackTrace();
            return false;
        } return true;

    }
    //editar//
    public  boolean updateTransaccion (Transaccion transaccion){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(transaccion);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            }else {
                transaccion= JSONUtils.covertFromJsonToObject(response.get().body(), Transaccion.class);
                response.join();
                return true;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return false;

    }
    //eliminar//
    public  boolean deleteTransaccion (int id_transaccion){
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"delete/"+id_transaccion)).DELETE().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            } else {
                Transaccion transaccion =JSONUtils.covertFromJsonToObject(response.get().body(),Transaccion.class);
                response.join();
                return true;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        return false;
    }
}
