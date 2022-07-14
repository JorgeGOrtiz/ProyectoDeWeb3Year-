package beans;

import Entity.Transaccion;
import Rest.RestTransaccion;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped


public class Transaccion_bean {
    private static List<Transaccion> list_transaccion = new ArrayList<Transaccion>();
    private static int idTransaccion=0;
    private static Date fecha=null;
    private static int montoTransaccion=0;

    private static Transaccion transaccion= new Transaccion();
    private static RestTransaccion restTransaccion=new RestTransaccion();

    public void init(){
        list_transaccion.clear();
        clean_variables();
        list_transaccion=restTransaccion.findAllTransaccion();
    }

    public  List<Transaccion> getList_transaccion() {
        return list_transaccion;
    }

    public  void setList_transaccion(List<Transaccion> list_transaccion) {
        Transaccion_bean.list_transaccion = list_transaccion;
    }

    public  int getIdTransaccion() {
        return idTransaccion;
    }

    public  void setIdTransaccion(int idTransaccion) {
        Transaccion_bean.idTransaccion = idTransaccion;
    }

    public  Date getFecha() {
        return fecha;
    }

    public  void setFecha(Date fecha) {
        Transaccion_bean.fecha = fecha;
    }

    public  int getMontoTransaccion() {
        return montoTransaccion;
    }

    public  void setMontoTransaccion(int montoTransaccion) {
        Transaccion_bean.montoTransaccion = montoTransaccion;
    }

    public  Transaccion getTransaccion() {
        return transaccion;
    }

    public  void setTransaccion(Transaccion transaccion) {
        Transaccion_bean.transaccion = transaccion;
    }

    public  RestTransaccion getRestTransaccion() {
        return restTransaccion;
    }

    public  void setRestTransaccion(RestTransaccion restTransaccion) {
        Transaccion_bean.restTransaccion = restTransaccion;
    }

    public Transaccion_bean() {
    }

    public void clean_variables() {
        idTransaccion = 0;
        fecha =null;
        montoTransaccion = 0;

    }

    public void createTransaccion(){
        Transaccion transaccion = new Transaccion(idTransaccion,fecha,montoTransaccion);
        Transaccion transaccion_finded = restTransaccion.findByIdTransaccion(idTransaccion);
        if (transaccion_finded!=null){
            FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe una transaccion con ese id",""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }

        if (restTransaccion.createTransaccion(transaccion)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Transaccion Adicionada", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existen errores en el formulario",""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addTransaccionDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages","form:dt-transaccion");
    }
    public void copyEdit(Transaccion transaccione){
        if(transaccione != null)
            transaccion = new Transaccion(transaccione.getIdTransaccion(),transaccione.getFecha(),transaccione.getMontoTransaccion());
        System.out.println();
    }

    public void edit(){

        Transaccion transaccion_finded = restTransaccion.findByIdTransaccion(transaccion.getIdTransaccion());
        if (transaccion_finded == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar la transaccion", "Transaccion Inexistente"));
        }
        else{
            if (!restTransaccion.updateTransaccion(transaccion)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar la transaccion", "Error en el formulario"));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Transaccion actualizada", ""));
            }
        }
        init();
        PrimeFaces.current().executeScript("PF('editTransaccionDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-transaccion");
    }

    public void delete(){
        if(transaccion != null && restTransaccion.deleteTransaccion(transaccion.getIdTransaccion())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Transaccion eliminada", ""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar transaccion", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-transaccion");
    }



}
