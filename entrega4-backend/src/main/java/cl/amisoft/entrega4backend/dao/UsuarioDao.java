package cl.amisoft.entrega4backend.dao;

import cl.amisoft.entrega4backend.model.Usuario;
import cl.amisoft.entrega4backend.model.UsuariosEliminados;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class UsuarioDao {

    @PersistenceContext
    protected EntityManager em;

    //Crear usuarios
    public String crearUsuario(String nombre, String apellido, Long rut, Character rutDv){
        List<Usuario> resultList = em.createQuery("Select u from Usuario u where u.rut = :rut", Usuario.class).setParameter("rut", rut).getResultList();
        if(!resultList.isEmpty()){
            return "Rut ya existe";
        }else{
            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setRut(rut);
            usuario.setRutDv(rutDv);
            em.persist(usuario);
            return "Usuario creado exitosamente";
        }
    }

    //obtener todos los usuarios
    public List<Usuario> obtenerUsuarios(){
        List resultList = em.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
        if (!resultList.isEmpty()) {
            return resultList;
        }
        return Collections.emptyList();
    }

    public String actualizarUsuario (Long id, String nuevoNombre, String nuevoApellido, Long nuevoRut, Character nuevoDv){
        List<Usuario> resultList = em.createQuery("Select u from Usuario u where u.id = :id", Usuario.class).setParameter("id", id).getResultList();
        if (!resultList.isEmpty()) {
            Usuario user = em.find(Usuario.class, id);
            user.setNombre(nuevoNombre);
            user.setApellido(nuevoApellido);
            user.setRut(nuevoRut);
            user.setRutDv(nuevoDv);
            em.merge(user);
            return "Usuario actualizado correctamente";
        }else{
            return "No se encontró el usuario";
        }
    }

    public String eliminarUsuario (Long id){
        Usuario usuario = em.find(Usuario.class, id);

        UsuariosEliminados usuariosEliminados = new UsuariosEliminados();

        if (usuario != null) {
            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            Long rut = usuario.getRut();
            Character rutDv = usuario.getRutDv();

            usuariosEliminados.setNombreEliminado(nombre);
            usuariosEliminados.setApellidoEliminado(apellido);
            usuariosEliminados.setRutEliminado(rut);
            usuariosEliminados.setRutDvEliminado(rutDv);

            em.remove(usuario);
            em.persist(usuariosEliminados);

            return "Usuario eliminado correctamente";
        }else{
            return "Usuario no existe";
        }
    }
}