package beans;

import Entity.Authorities;
import Entity.Users;
import Rest.RestAuthorities;
import Rest.RestUsers;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean
@SessionScoped
public class AdminUsers_bean {

    private static List<Users> listUsers = new ArrayList<Users>();
    private static String username = "";
    private static String identificacion = "";
    private static String nombre = "";
    private static String email = "";
    private static String password = "";
    private static boolean enabled = true;
    private static String descripcion = "";
    private static Users user = new Users();
    private static RestUsers restUsers = new RestUsers();
    private static List<String> list_roles= new ArrayList<>();
    private static RestAuthorities restAuthorities=new RestAuthorities();

    public void init(){
        listUsers.clear();
        // cleanVariables();
        listUsers = restUsers.findAllUsers();
    }

    public List<String> getList_roles() {
        return list_roles;
    }

    public void setList_roles(List<String> list_roles) {
        this.list_roles = list_roles;
    }

    public static RestUsers getRestUsers() {
        return restUsers;
    }

    public static void setRestUsers(RestUsers restUsers) {
        AdminUsers_bean.restUsers = restUsers;
    }

    public List<Users> getListUsers() { return listUsers; }

    public void setListUsers(List<Users> listUsers) { AdminUsers_bean.listUsers = listUsers; }

    public String getUsername() { return username; }

    public void setUsername(String username) { AdminUsers_bean.username = username; }

    public String getIdentificacion() { return identificacion; }

    public void setIdentificacion(String identificacion) { AdminUsers_bean.identificacion = identificacion; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { AdminUsers_bean.nombre = nombre; }

    public String getEmail() { return email; }

    public void setEmail(String email) { AdminUsers_bean.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { AdminUsers_bean.password = password; }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { AdminUsers_bean.enabled = enabled; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { AdminUsers_bean.descripcion = descripcion; }

    public Users getUser() { return user; }

    public void setUser(Users user) { AdminUsers_bean.user = user; }

    public void cleanVariables(){
        username = "";
        identificacion = "";
        nombre = "";
        email = "";
        password = "";
        enabled = true;
        descripcion = "";
        list_roles.clear();
    }

    public void createUser(){
//        password= DigestUtils.shaHex(password);
        Users user = new Users(username,identificacion,nombre,email,password,enabled,descripcion);
        Users userFinded = restUsers.findUserByUsername(username);
        if (userFinded != null){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ya existe usuario con ese nombre",""));
            PrimeFaces.current().ajax().update("form:messages");
            return;
        }
        if (restUsers.createUser(user)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Adicionado", ""));
        for (String u:list_roles){
            Authorities auth = new Authorities(username,u);
            restAuthorities.createAuthority(auth);
        }
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existe error en el formulario",""));
        }
        init();
        list_roles.clear();
        listUsers = restUsers.findAllUsers();
        PrimeFaces.current().executeScript("PF('addUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-user");
    }

    public void copyEdit(Users us){
        list_roles.clear();
        if(us != null)
            user = new Users(us.getUsername(),us.getIdentificacion(),us.getNombre(),us.getEmail(),"",us.getEnabled(),us.getDescripcion());
        List<Authorities> l=restAuthorities.findAuthorityByUsername(us.getUsername());
        for (Authorities lr: l){
            list_roles.add(lr.getAuthoritiesPK().getAuthority());
        }
    }

    public void edit(){
        Users userFinded = restUsers.findUserByUsername(user.getUsername());
        if (userFinded == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el usuario", "Usuario Inexistente"));
        }
        else{
            if (user.getPassword().equals("")){
                user.setPassword(userFinded.getPassword());
            } else {
                user.setPassword(user.getPassword());
            }
            if (!restUsers.updateUser(user)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al editar el usuario", "Error en el formulario"));
            }
            else{
                List<Authorities> la = restAuthorities.findAuthorityByUsername(user.getUsername());
                for (Authorities a:la){
                    restAuthorities.deleteAuthority(a.getAuthoritiesPK());
                }
                for (String s:list_roles){
                    restAuthorities.createAuthority(new Authorities(user.getUsername(),s));
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario actualizado", ""));
            }
        }
        init();
        list_roles.clear();
        listUsers = restUsers.findAllUsers();
        PrimeFaces.current().executeScript("PF('editUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-user");
    }

    public void delete(){
            if (user == null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Existen errores al eliminar el usuario", ""));
            }else {
                List<Authorities> la = restAuthorities.findAuthorityByUsername(user.getUsername());
                for (Authorities a:la){
                    restAuthorities.deleteAuthority(a.getAuthoritiesPK());
                }
                for (String s: list_roles){
                restAuthorities.createAuthority(new Authorities(username,s));
                }
                if( restUsers.deleteUser(user.getUsername())){
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario eliminado", ""));
                }
             init();
            PrimeFaces.current().ajax().update("form:messages", "form:dt-user");
        }
    }

    public String translateEstado(boolean text){

        return (text)? "habilitado" : "deshabilitado";
    }

    public String translateColorEstado(boolean text){
        return (text)? "green" : "red";
    }
}
