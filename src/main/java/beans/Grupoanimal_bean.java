package beans;

import Entity.Grupoanimal;
import Rest.RestGrupoanimal;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Grupoanimal_bean {
    private static List<Grupoanimal> listGrupoanimal = new ArrayList <Grupoanimal> ();
    private static Integer id_grupo_animal = 0;
    private static String nombregrupoanimal = "";
    private static Grupoanimal grupoanimal= new Grupoanimal();
    private static RestGrupoanimal restGrupoanimal = new RestGrupoanimal();

    public void init(){
        listGrupoanimal.clear();
         cleanVariables();
        listGrupoanimal = restGrupoanimal.findAllGrupoanimals();
    }

    public static List<Grupoanimal> getListGrupoanimal() {
        return listGrupoanimal;
    }

    public static void setListGrupoanimal(List<Grupoanimal> listGrupoanimal) {
        Grupoanimal_bean.listGrupoanimal = listGrupoanimal;
    }

    public static Integer getId_grupo_animal() {
        return id_grupo_animal;
    }

    public static void setId_grupo_animal(Integer id_grupo_animal) {
        Grupoanimal_bean.id_grupo_animal = id_grupo_animal;
    }

    public static String getNombregrupoanimal() {
        return nombregrupoanimal;
    }

    public static void setNombregrupoanimal(String nombregrupoanimal) {
        Grupoanimal_bean.nombregrupoanimal = nombregrupoanimal;
    }

    public static Grupoanimal getGrupoanimal() {
        return grupoanimal;
    }

    public static void setGrupoanimal(Grupoanimal grupoanimal) {
        Grupoanimal_bean.grupoanimal = grupoanimal;
    }

    public static RestGrupoanimal getRestGrupoanimal() {
        return restGrupoanimal;
    }

    public static void setRestGrupoanimal(RestGrupoanimal restGrupoanimal) {
        Grupoanimal_bean.restGrupoanimal = restGrupoanimal;
    }
    public Grupoanimal_bean(){}

    public void cleanVariables(){
        id_grupo_animal= 0;
        nombregrupoanimal= "";
    }
    public void createGrupoanimal(){
        Grupoanimal grupoanimal = new Grupoanimal(id_grupo_animal,nombregrupoanimal);
        Grupoanimal grupoanimal1_finded = restGrupoanimal.findByid_grupo_animal(id_grupo_animal);
        if (grupoanimal1_finded!=null){
            FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe un grupo animal con ese id",""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }

        if (restGrupoanimal.createGrupoanimal(grupoanimal)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo animal Adicionado", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existen errores en el formulario",""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addGrupoanimalDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages","form:dt-grupoanimal");
    }
    public void copyEdit(Grupoanimal grupoanimal1){
        if(grupoanimal1 != null)
            grupoanimal = new Grupoanimal(grupoanimal1.getIdGrupoAnimal(),grupoanimal1.getNombregrupoanimal());

    }

    public void edit(){

        Grupoanimal grupoanimal_finded = restGrupoanimal.findByid_grupo_animal(id_grupo_animal);
        if (grupoanimal_finded == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el grupo animal", "Grupo animal Inexistente"));
        }
        else{if (grupoanimal.getIdGrupoAnimal().equals("")){
            grupoanimal.setIdGrupoAnimal(grupoanimal_finded.getIdGrupoAnimal());
        }
            if (!restGrupoanimal.updateGrupoanimal(grupoanimal)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el grupo animal", "Error en el formulario"));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo animal actualizado", ""));
            }
        }
        init();
        PrimeFaces.current().executeScript("PF('editGrupoanimalDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-grupoanimal");
    }

    public void delete(){
        if(grupoanimal != null && restGrupoanimal.deleteGrupoanimal(grupoanimal.getIdGrupoAnimal())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Grupo animal eliminado", ""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar el grupo animal", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-grupoanimal");
    }

}
