package beans;

import Entity.*;
import Entity.Especieanimal;
import Entity.EspecieanimalPK;
import Entity.Grupoanimal;
import Rest.RestEspecieanimal;
import Rest.RestGrupoanimal;
import Rest.RestReproduccion;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Reproduccion_bean {
    private static List<Reproduccion> listreproduccion = new ArrayList<>();
    private static int idReproduccion=0;
    private static String etapaDeApareamiento = "";
    private static String duracionEtapaDeApareamiento = "";
    private static String duracionPeriodoDeGestaion = "";
    private static RestGrupoanimal restGrupoanimal = new RestGrupoanimal();
    private static RestEspecieanimal restEspecieanimal = new RestEspecieanimal();
    private static Reproduccion reproduccion = new Reproduccion();
    private static RestReproduccion restReproduccion = new RestReproduccion();
    private static List<Grupoanimal> list_grupoanimal = new ArrayList<Grupoanimal>();
    private static List<Especieanimal> listespecieanimal = new ArrayList<Especieanimal>();
    private static String grupoAdd;
    private static String especieAdd;
    private static Grupoanimal grupoanimal;
    private  static Especieanimal especieanimal;

    public void init(){
        listreproduccion.clear();
        cleanVariables();
        listreproduccion = restReproduccion.findAllReproduccion();

    }

    public List<Reproduccion> getListreproduccion() {
        return listreproduccion;
    }

    public void setListreproduccion(List<Reproduccion> listreproduccion) {
        this.listreproduccion = listreproduccion;
    }

    public int getIdReproduccion() {
        return idReproduccion;
    }

    public void setIdReproduccion(int idReproduccion) {
        this.idReproduccion = idReproduccion;
    }

    public String getEtapaDeApareamiento() {
        return etapaDeApareamiento;
    }

    public void setEtapaDeApareamiento(String etapaDeApareamiento) {
        this.etapaDeApareamiento = etapaDeApareamiento;
    }

    public String getDuracionEtapaDeApareamiento() {
        return duracionEtapaDeApareamiento;
    }

    public void setDuracionEtapaDeApareamiento(String duracionEtapaDeApareamiento) {
        this.duracionEtapaDeApareamiento = duracionEtapaDeApareamiento;
    }

    public String getDuracionPeriodoDeGestaion() {
        return duracionPeriodoDeGestaion;
    }

    public void setDuracionPeriodoDeGestaion(String duracionPeriodoDeGestaion) {
        this.duracionPeriodoDeGestaion = duracionPeriodoDeGestaion;
    }

    public RestGrupoanimal getRestGrupoanimal() {
        return restGrupoanimal;
    }

    public void setRestGrupoanimal(RestGrupoanimal restGrupoanimal) {
        this.restGrupoanimal = restGrupoanimal;
    }

    public RestEspecieanimal getRestEspecieanimal() {
        return restEspecieanimal;
    }

    public void setRestEspecieanimal(RestEspecieanimal restEspecieanimal) {
        this.restEspecieanimal = restEspecieanimal;
    }

    public Reproduccion getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(Reproduccion reproduccion) {
        this.reproduccion = reproduccion;
    }

    public RestReproduccion getRestReproduccion() {
        return restReproduccion;
    }

    public void setRestReproduccion(RestReproduccion restReproduccion) {
        this.restReproduccion = restReproduccion;
    }

    public List<Grupoanimal> getList_grupoanimal() {
        return list_grupoanimal;
    }

    public void setList_grupoanimal(List<Grupoanimal> list_grupoanimal) {
        this.list_grupoanimal = list_grupoanimal;
    }

    public List<Especieanimal> getListespecieanimal() {
        return listespecieanimal;
    }

    public void setListespecieanimal(List<Especieanimal> listespecieanimal) {
        this.listespecieanimal = listespecieanimal;
    }

    public String getGrupoAdd() {
        return grupoAdd;
    }

    public void setGrupoAdd(String grupoAdd) {
        this.grupoAdd = grupoAdd;
    }

    public String getEspecieAdd() {
        return especieAdd;
    }

    public void setEspecieAdd(String especieAdd) {
        this.especieAdd = especieAdd;
    }

    public Grupoanimal getGrupoanimal() {
        return grupoanimal;
    }

    public void setGrupoanimal(Grupoanimal grupoanimal) {
        this.grupoanimal = grupoanimal;
    }

    public Especieanimal getEspecieanimal() {
        return especieanimal;
    }

    public void setEspecieanimal(Especieanimal especieanimal) {
        this.especieanimal = especieanimal;
    }

    public Reproduccion_bean() {
    }

    public void cleanVariables(){
        idReproduccion= 0;
        etapaDeApareamiento = "";
        duracionEtapaDeApareamiento="";
        duracionPeriodoDeGestaion="";

    }

    public void createReproduccion(){
//        Especieanimal especieanimal = new Especieanimal(especieanimalPK,nombreEspecieAnimal);
//        Especieanimal especieanimal_finded = restEspecieanimal.findEspecieanimalByid(especieanimalPK);
        if (grupoAdd.equals("-1")  || especieAdd.equals("-1") ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar un grupo y una especie animal disponible", ""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }
        Especieanimal especieanimal = new Especieanimal(Integer.parseInt(especieAdd), grupoanimal.getIdGrupoAnimal());
        ReproduccionPK reproduccionPK = new ReproduccionPK(idReproduccion,especieanimal.getEspecieanimalPK().getIdEspecieAnimal(),especieanimal.getEspecieanimalPK().getGrupoanimalidGrupoAnimal());
        Reproduccion reproduccion = new Reproduccion(reproduccionPK, etapaDeApareamiento,duracionEtapaDeApareamiento,duracionPeriodoDeGestaion);
        Reproduccion reproduccion_finded = restReproduccion.findReproduccionById(reproduccionPK);
        if (reproduccion_finded != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ya existe una reproduccion animal con ese id", ""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }
        if (restReproduccion.createReproduccion(reproduccion)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reproduccion animal Adicionada", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores en el formulario", ""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addReproduccionDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reproduccion");
    }

    public void copyEdit(Reproduccion r) {
        cleanVariables();
        reproduccion = r;
        etapaDeApareamiento=r.getEtepaDeApareamiento();
        duracionEtapaDeApareamiento=r.getEtepaDeApareamiento();
        duracionPeriodoDeGestaion = r.getDuracionPeriodoDeGestaion();

    }

    public void edit() {
        Reproduccion reproduccion_finded = restReproduccion.findReproduccionById(reproduccion.getReproduccionPK());
        if(!reproduccion_finded.getEtepaDeApareamiento().equals(etapaDeApareamiento)) {
            reproduccion_finded.setEtepaDeApareamiento(etapaDeApareamiento);
        }
        if(!reproduccion_finded.getDuracionEtepaDeApareamiento().equals(duracionEtapaDeApareamiento)) {
            reproduccion_finded.setDuracionEtepaDeApareamiento(duracionEtapaDeApareamiento);
        }
        if(!reproduccion_finded.getDuracionPeriodoDeGestaion().equals(duracionPeriodoDeGestaion)) {
            reproduccion_finded.setDuracionPeriodoDeGestaion(duracionPeriodoDeGestaion);
        }

        if (!restReproduccion.updateReproduccion(reproduccion_finded)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar la reproduccion animal", "Error en el formulario"));
            init();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reproduccion animal actualizada", ""));
        }
        PrimeFaces.current().executeScript("PF('editReproduccionDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reproduccion");
    }

    public void info(Reproduccion r) {
        cleanVariables();
        reproduccion = r;
    }
    public void delete() {
        if (!restReproduccion.deleteReproduccion(reproduccion.getReproduccionPK())) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar la reproduccion animal", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reproduccion animal eliminada", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-reproduccion");
    }

    public void cargarGrupoAnimal(){
        cleanVariables();
        list_grupoanimal=restGrupoanimal.findAllGrupoanimals();
    }

    public void cargarEspecieAnimal(ValueChangeEvent even) {
        grupoAdd = (String) even.getNewValue();
        if (!grupoAdd.equals("-1")) {
            grupoanimal = restGrupoanimal.findByid_grupo_animal(Integer.parseInt(grupoAdd));
            listespecieanimal = restEspecieanimal.findByGrupo(grupoanimal);
            PrimeFaces.current().ajax().update("form:add_especieanimal");
        }
    }

//    public void cargarEspecieAnimal1(ValueChangeEvent even) {
//        especieAdd = (String) even.getNewValue();
//        if (!especieAdd.equals("-1")) {
//            especieanimal = restEspecieanimal.findEspecieAnimalById(Integer.parseInt(especieAdd));
//            listreproduccion = restReproduccion.findReproduccionById(especieanimal);
//            PrimeFaces.current().ajax().update("form:add_especieanimal1");
//        }
//    }

}
