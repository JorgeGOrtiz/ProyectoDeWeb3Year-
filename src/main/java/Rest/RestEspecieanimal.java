package Rest;


import Entity.*;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestEspecieanimal {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/especieanimal/";

    public List<Especieanimal> findAllEspecieanimal() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL+"findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req, HttpResponse.BodyHandlers.ofString());
        List<Especieanimal> list_Especieanimal = null;
        try {
            list_Especieanimal = JSONUtils.convertFromJsonToList(response.get().body(), new
                    TypeReference<List<Especieanimal>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_Especieanimal;
    }

    
    public Especieanimal findEspecieAnimalById(@RequestParam EspecieanimalPK id){
        String inputJson = JSONUtils.covertFromObjectToJson(id);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"find"))
                .header("Content-Type","application/json")
                .GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        Especieanimal especieanimal = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    especieanimal = JSONUtils.covertFromJsonToObject(response.get().body(),Especieanimal.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return especieanimal;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return especieanimal;
    }

    public boolean createEspecieanimal(Especieanimal especieanimal){
        String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(especieanimal);
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

    public boolean updateEspecieanimal(Especieanimal especieanimal){
        String inputJson= null;
        inputJson = JSONUtils.covertFromObjectToJson(especieanimal);
        HttpRequest request = HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if(response.get().statusCode() == 500){
                response.join();
                return false;
            } else {
                especieanimal = JSONUtils.covertFromJsonToObject(response.get().body(), Especieanimal.class);
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

    public boolean deleteEspecieanimal(EspecieanimalPK especieanimalPK) {
        String inputJson= null;
        inputJson = JSONUtils.covertFromObjectToJson(especieanimalPK);
        HttpRequest request = HttpRequest.newBuilder(URI.create(serviceURL+"delete"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if(response.get().statusCode() == 500) {
                response.join();
                return false;
            } else {
                Especieanimal especieanimal = JSONUtils.covertFromJsonToObject(response.get().body(), Especieanimal.class);
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

    public List<Especieanimal> findByGrupo(Grupoanimal grupoanimal){
        String inputJson = JSONUtils.covertFromObjectToJson(grupoanimal);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"findByGrupo"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        List <Especieanimal> esp = null;
        try {
            esp = JSONUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<Especieanimal>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return esp;
    }

}



