package Rest;
import Entity.Cliente;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class RestCliente {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/Cliente/";


    //encontrar todos//
    public  List<Cliente> findAllCliente() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Cliente> list_cliente = null;
        try {
            list_cliente = JSONUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<Cliente>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_cliente;
    }
    //encontrar por//
    public  Cliente findByemail(String email){
        Cliente cliente = null;
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "find/"+email)).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Cliente> list_cliente = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    cliente = JSONUtils.covertFromJsonToObject(response.get().body(),Cliente.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return cliente;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return cliente;
    }
    //crear//
    public  boolean createCliente (Cliente cliente){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(cliente);
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
        }catch (ExecutionException e){
            e.printStackTrace();
            return false;
        } return true;

    }
    //editar//
    public  boolean updateCliente (Cliente cliente){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(cliente);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            }else {
                cliente= JSONUtils.covertFromJsonToObject(response.get().body(), Cliente.class);
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
    public  boolean deleteCliente (String email){
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"delete/"+email)).DELETE().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            } else {
                Cliente cliente =JSONUtils.covertFromJsonToObject(response.get().body(),Cliente.class);
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

