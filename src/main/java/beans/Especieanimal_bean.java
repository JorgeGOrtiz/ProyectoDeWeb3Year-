package beans;

import Entity.*;
import Entity.Especieanimal;
import Entity.EspecieanimalPK;
import Entity.Grupoanimal;
import Rest.RestEspecieanimal;
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
public class Especieanimal_bean {
    private static List<Especieanimal> listespecieanimal = new ArrayList<>();
    private static int idEspecieanimal=0;
    private static String nombreEspecieAnimal = "";
    private static RestGrupoanimal restGrupoanimal = new RestGrupoanimal();
    private static Especieanimal especieanimal = new Especieanimal();
    private static RestEspecieanimal restEspecieanimal = new RestEspecieanimal();
    private static List<Grupoanimal> list_grupoanimal = new ArrayList<Grupoanimal>();
    private static String grupoAdd;
    private static Grupoanimal grupoanimal;

    public void init(){
        listespecieanimal.clear();
        cleanVariables();
        listespecieanimal = restEspecieanimal.findAllEspecieanimal();

    }

    public List<Especieanimal> getListespecieanimal() {
        return listespecieanimal;
    }

    public void setListespecieanimal(List<Especieanimal> listespecieanimal) {
        this.listespecieanimal = listespecieanimal;
    }

    public int getIdEspecieanimal() {
        return idEspecieanimal;
    }

    public void setIdEspecieanimal(int idEspecieanimal) {
        this.idEspecieanimal = idEspecieanimal;
    }

    public String getNombreEspecieAnimal() {
        return nombreEspecieAnimal;
    }

    public void setNombreEspecieAnimal(String nombreEspecieAnimal) {
        this.nombreEspecieAnimal = nombreEspecieAnimal;
    }

    public RestGrupoanimal getRestGrupoanimal() {
        return restGrupoanimal;
    }

    public void setRestGrupoanimal(RestGrupoanimal restGrupoanimal) {
        this.restGrupoanimal = restGrupoanimal;
    }

    public Especieanimal getEspecieanimal() {
        return especieanimal;
    }

    public void setEspecieanimal(Especieanimal especieanimal) {
        this.especieanimal = especieanimal;
    }

    public RestEspecieanimal getRestEspecieanimal() {
        return restEspecieanimal;
    }

    public void setRestEspecieanimal(RestEspecieanimal restEspecieanimal) {
        this.restEspecieanimal = restEspecieanimal;
    }

    public List<Grupoanimal> getList_grupoanimal() {
        return list_grupoanimal;
    }

    public void setList_grupoanimal(List<Grupoanimal> list_grupoanimal) {
        this.list_grupoanimal = list_grupoanimal;
    }

    public String getGrupoAdd() {
        return grupoAdd;
    }

    public void setGrupoAdd(String grupoAdd) {
        this.grupoAdd = grupoAdd;
    }

    public Grupoanimal getGrupoanimal() {
        return grupoanimal;
    }

    public void setGrupoanimal(Grupoanimal grupoanimal) {
        this.grupoanimal = grupoanimal;
    }

    public Especieanimal_bean() {
    }

    public void cleanVariables(){
        nombreEspecieAnimal= "";
        idEspecieanimal = 0;

    }

    public void createEspecieanimal(){
//        Especieanimal especieanimal = new Especieanimal(especieanimalPK,nombreEspecieAnimal);
//        Especieanimal especieanimal_finded = restEspecieanimal.findEspecieanimalByid(especieanimalPK);
        if (grupoAdd.equals("-1") ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un grupo animal disponible", ""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }
        Grupoanimal grupoanimal = new Grupoanimal(Integer.parseInt(grupoAdd));
        EspecieanimalPK especieanimalPK = new EspecieanimalPK(idEspecieanimal,grupoanimal.getIdGrupoAnimal());
        Especieanimal especieanimal = new Especieanimal(especieanimalPK, nombreEspecieAnimal);
        Especieanimal especieanimal_finded = restEspecieanimal.findEspecieAnimalById(especieanimalPK);
        if (especieanimal_finded != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una especie animal con ese id", ""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }
        if (restEspecieanimal.createEspecieanimal(especieanimal)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especie animal Adicionada", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores en el formulario", ""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addEspecieAnimalDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-especieanimal");
    }

    public void copyEdit(Especieanimal e) {
        cleanVariables();
        especieanimal = e;
        nombreEspecieAnimal = e.getNombreEspecieAnimal();

    }

    public void edit() {
        Especieanimal especieanimal_finded = restEspecieanimal.findEspecieAnimalById(especieanimal.getEspecieanimalPK());
        if(!especieanimal_finded.getNombreEspecieAnimal().equals(nombreEspecieAnimal)) {
            especieanimal_finded.setNombreEspecieAnimal(nombreEspecieAnimal);
        }

        if (!restEspecieanimal.updateEspecieanimal(especieanimal_finded)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar la especie animal", "Error en el formulario"));
            init();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especie animal actualizada", ""));
        }
        PrimeFaces.current().executeScript("PF('editEspecieAnimalDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-especieanimal");
    }

    public void info(Especieanimal e) {
        cleanVariables();
        especieanimal = e;
    }
    public void delete() {
        if (!restEspecieanimal.deleteEspecieanimal(especieanimal.getEspecieanimalPK())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar la especie animal", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Especie animal eliminada", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-especieanimal");
    }

    public void cargarGrupoAnimal(){
    cleanVariables();
    list_grupoanimal=restGrupoanimal.findAllGrupoanimals();
    }
}
