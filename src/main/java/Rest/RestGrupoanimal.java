package Rest;

import Entity.Grupoanimal;
import Utils.JSONUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RestGrupoanimal {
    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String serviceURL = "http://localhost:8081/grupoanimal/";

    public  List<Grupoanimal> findAllGrupoanimals() {
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "findAll")).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Grupoanimal> list_Grupoanimal = null;
        try {
            list_Grupoanimal = JSONUtils.convertFromJsonToList(response.get().body(), new TypeReference<List<Grupoanimal>>() {});
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        response.join();
        return list_Grupoanimal;
    }

    public Grupoanimal findByid_grupo_animal(Integer id_grupo_animal){
        Grupoanimal grupoanimal = null;
        HttpRequest req = HttpRequest.newBuilder(URI.create(serviceURL + "find/"+id_grupo_animal)).GET().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(req,HttpResponse.BodyHandlers.ofString());
        List <Grupoanimal> list_Grupoanimal = null;
        try {
            if (response.get().statusCode() == 500){
                response.join();
                return null;
            } else {
                try {
                    grupoanimal = JSONUtils.covertFromJsonToObject(response.get().body(), Grupoanimal.class);
                } catch (ExecutionException e){
                    e.printStackTrace();
                }response.join();
                return grupoanimal;
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }
        return grupoanimal;
    }

    public  boolean createGrupoanimal (Grupoanimal grupoanimal){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(grupoanimal);
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

    public  boolean updateGrupoanimal (Grupoanimal grupoanimal){String inputJson = null;
        inputJson = JSONUtils.covertFromObjectToJson(grupoanimal);
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"update"))
                .header("Content-Type","application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(inputJson)).build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            }else {
                grupoanimal= JSONUtils.covertFromJsonToObject(response.get().body(), Grupoanimal.class);
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

    public  boolean deleteGrupoanimal (Integer id_grupo_animal){
        HttpRequest request= HttpRequest.newBuilder(URI.create(serviceURL+"delete/"+id_grupo_animal)).DELETE().build();
        CompletableFuture<HttpResponse<String>> response = client.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        try {
            if (response.get().statusCode()==500){
                response.join();
                return false;
            } else {
                Grupoanimal grupoanimal = JSONUtils.covertFromJsonToObject(response.get().body(), Grupoanimal.class);
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
