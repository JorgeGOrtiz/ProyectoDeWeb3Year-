package Rest;

import Entity.Especieanimal;
import Entity.EspecieanimalPK;
import Entity.Reproduccion;
import Entity.ReproduccionPK;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestReproduccion {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/reproduccion/";

    public List<Reproduccion> findAllReproduccion() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL+"findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        List<Reproduccion> list_Reproduccion = null;
        try {
            list_Reproduccion = JSONUtils.convertFromJsonToList(response.get().body(), new
                    TypeReference<List<Reproduccion>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_Reproduccion;
    }


    public Reproduccion findReproduccionById(ReproduccionPK id){
        String inputJson = JSONUtils.covertFromObjectToJson(id);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"find"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        Reproduccion reproduccion = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    reproduccion = JSONUtils.covertFromJsonToObject(response.get().body(),Reproduccion.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return reproduccion;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return reproduccion;
    }

    public boolean createReproduccion(Reproduccion reproduccion){
        String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(reproduccion);
        HttpRequest request = HttpRequest.newBuilder(URI.create(serviceURL+"create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if(response.get().statusCode() == 500){
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateReproduccion(Reproduccion reproduccion){
        String inputJson= null;
        inputJson = JSONUtils.covertFromObjectToJson(reproduccion);
        HttpRequest request = HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if(response.get().statusCode() == 500){
                response.join();
                return false;
            } else {
                reproduccion = JSONUtils.covertFromJsonToObject(response.get().body(), Reproduccion.class);
                response.join();
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteReproduccion(ReproduccionPK reproduccionPK)
    {
        String inputJson= null;
        inputJson = JSONUtils.covertFromObjectToJson(reproduccionPK);
        HttpRequest request = HttpRequest.newBuilder(URI.create(serviceURL+"delete/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if(response.get().statusCode() == 500) {
                response.join();
                return false;
            } else {
                Reproduccion reproduccion = JSONUtils.covertFromJsonToObject(response.get().body(), Reproduccion.class);
                response.join();
                return true;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}



