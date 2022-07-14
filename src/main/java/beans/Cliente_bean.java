
package beans;

import Entity.Cliente;
import Rest.RestCliente;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped


public class Cliente_bean {
    private static List<Cliente> list_clientes = new ArrayList<Cliente>();
    private static String email="";
    private static String contrasenna="";
    private static String nombre="";
    private static String direccion="";
    private static int telefono=0;
    private static Cliente cliente= new Cliente();
    private static RestCliente restCliente=new RestCliente();

    public void init(){
        list_clientes.clear();
        clean_variables();
        list_clientes=restCliente.findAllCliente();
    }

    public  List<Cliente> getList_clientes() {
        return list_clientes;
    }

    public void setList_clientes(List<Cliente> list_clientes) {
        Cliente_bean.list_clientes = list_clientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {return email;}

    public void setEmail(String email) {
        Cliente_bean.email = email;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        Cliente_bean.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        Cliente_bean.nombre = nombre;
    }




    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        Cliente_bean.telefono = telefono;
    }
    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { Cliente_bean.cliente = cliente; }

    public Cliente_bean() {}

    public void clean_variables() {
        email = "";
        contrasenna="";
        nombre = "";
        direccion = "";
        telefono = 0;
    }

    public void create_cliente(){
        Cliente cliente = new Cliente(email,contrasenna,nombre,direccion,telefono);
        Cliente cliente_finded = restCliente.findByemail(email);
        if (cliente_finded!=null){
            FacesContext.getCurrentInstance().addMessage( null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe un cliente con ese email",""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }

        if (restCliente.createCliente(cliente)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Adicionado", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existen errores en el formulario",""));
        }
        init();
        PrimeFaces.current().executeScript("PF('addClienteDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages","form:dt-cliente");
    }
    public void copyEdit(Cliente client){
        if(client != null)
            cliente = new Cliente(client.getEmail(),client.getContrasenna(),client.getNombre(),client.getDireccion(),client.getTelefono());

    }

    public void edit(){

        Cliente cliente_finded = restCliente.findByemail(cliente.getEmail());
        if (cliente_finded == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el cliente", "Cliente Inexistente"));
        }
        else{if (cliente.getContrasenna().equals("")){
            cliente.setContrasenna(cliente_finded.getContrasenna());
        }
            if (!restCliente.updateCliente(cliente)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el cliente", "Error en el formulario"));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente actualizado", ""));
            }
        }
        init();
        PrimeFaces.current().executeScript("PF('editClienteDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-cliente");
    }

    public void delete(){
        if(cliente != null && restCliente.deleteCliente(cliente.getEmail())){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente eliminado", ""));
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar el cliente", ""));
        }
        init();
        PrimeFaces.current().ajax().update("form:messages", "form:dt-cliente");
    }



}
