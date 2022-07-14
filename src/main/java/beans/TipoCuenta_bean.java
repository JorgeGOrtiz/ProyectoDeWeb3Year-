
package beans;

import Entity.TipoCuenta;
import Rest.RestTipoCuenta;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped


public class TipoCuenta_bean {
    private static List<TipoCuenta> list_tipoCuenta = new ArrayList<TipoCuenta>();
    private static int idTipoCuenta=0;
    private static String nombre="";
    private static int interes=0;
    private static float fondoMinimo=0f;
    private static TipoCuenta tipoCuenta= new TipoCuenta();
    private static RestTipoCuenta restTipoCuenta=new RestTipoCuenta();

    public void init(){
        list_tipoCuenta.clear();
        clean_variables();
        list_tipoCuenta=restTipoCuenta.findAllTipoCuenta();
    }

    public  List<TipoCuenta> getList_tipoCuenta() {
        return list_tipoCuenta;
    }

    public void setList_tipoCuenta(List<TipoCuenta> list_tipoCuenta) {
        TipoCuenta_bean.list_tipoCuenta = list_tipoCuenta;
    }

    public int getIdTipoCuenta() {return idTipoCuenta;}

    public void setIdTipoCuenta(int idTipoCuenta) {
        TipoCuenta_bean.idTipoCuenta = idTipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        TipoCuenta_bean.nombre = nombre;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        TipoCuenta_bean.interes = interes;
    }

    public float getFondoMinimo() {
        return fondoMinimo;
    }

    public void setFondoMinimo(float fondoMinimo) {
        this.fondoMinimo = fondoMinimo;
    }

    public RestTipoCuenta getRestTipoCuenta() {
        return restTipoCuenta;
    }

    public void setRestTipoCuenta(RestTipoCuenta restTipoCuenta) {
        this.restTipoCuenta = restTipoCuenta;
    }

    public TipoCuenta getTipoCuenta() { return tipoCuenta; }

    public void setTipoCuenta(TipoCuenta tipoCuenta) { TipoCuenta_bean.tipoCuenta = tipoCuenta; }

    public TipoCuenta_bean() {}

    public void clean_variables() {
        idTipoCuenta = 0;
        nombre = "";
        interes = 0;
        fondoMinimo = 0f;
    }

    public void createTipoCuenta(){
        TipoCuenta tipoCuenta = new TipoCuenta(idTipoCuenta,nombre,interes,fondoMinimo);
        TipoCuenta tipoCuenta_finded = restTipoCuenta.findById(idTipoCuenta);
        if (tipoCuenta_finded!=null){
            FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe un tipo de cuenta con ese id",""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }

        if (restTipoCuenta.createTipoCuenta(tipoCuenta)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de Cuenta Adicionada", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existen errores en el formulario",""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addTipoCuentaDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages","form:dt-tipoCuenta");
    }
    public void copyEdit(TipoCuenta tipoCuent){
        if(tipoCuent != null)
            tipoCuenta = new TipoCuenta(tipoCuent.getIdTipoCuenta(),tipoCuent.getNombre(),tipoCuent.getInteres(),tipoCuent.getFondoMinimo());}

    public void edit(){

        TipoCuenta tipoCuenta_finded = restTipoCuenta.findById(tipoCuenta.getIdTipoCuenta());
        if (tipoCuenta_finded == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el tipo de cuenta", "Tipo de Cuenta Inexistente"));
        }
        else{
            if (!restTipoCuenta.updateTipoCuenta(tipoCuenta)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el tipo de cuenta", "Error en el formulario"));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de cuenta actualizada", ""));
            }
        }
        init();
        PrimeFaces.current().executeScript("PF('editTipoCuentaDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-tipoCuenta");
    }

    public void delete(){
        if(tipoCuenta != null && restTipoCuenta.deleteTipoCuenta(tipoCuenta.getIdTipoCuenta())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo de cuenta eliminada", ""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar el tipo de cuenta", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-tipoCuenta");
    }



}
