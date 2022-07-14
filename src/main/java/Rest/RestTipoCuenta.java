package Rest;

import Entity.TipoCuenta;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestTipoCuenta {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/TipoCuenta/";


    //encontrar todos//
    public  List<TipoCuenta> findAllTipoCuenta() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <TipoCuenta> list_tipocuenta = null;
        try {
            list_tipocuenta = JSONUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<TipoCuenta>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_tipocuenta;
    }
    //encontrar por//
    public  TipoCuenta findById(int idTipoCuenta){
        TipoCuenta tipoCuenta = null;
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "find/"+idTipoCuenta)).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <TipoCuenta> list_tipoCuenta = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    tipoCuenta = JSONUtils.covertFromJsonToObject(response.get().body(),TipoCuenta.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return tipoCuenta;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return tipoCuenta;
    }
    //crear//
    public  boolean createTipoCuenta (TipoCuenta tipoCuenta){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(tipoCuenta);
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
    public  boolean updateTipoCuenta (TipoCuenta tipoCuenta){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(tipoCuenta);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            }else {
                tipoCuenta= JSONUtils.covertFromJsonToObject(response.get().body(), TipoCuenta.class);
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
    public  boolean deleteTipoCuenta (int idTipoCuenta){
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"delete/"+idTipoCuenta)).DELETE().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            } else {
                TipoCuenta tipoCuenta =JSONUtils.covertFromJsonToObject(response.get().body(),TipoCuenta.class);
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
