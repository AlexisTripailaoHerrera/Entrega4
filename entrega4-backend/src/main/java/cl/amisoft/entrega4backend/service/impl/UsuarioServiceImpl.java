package cl.amisoft.entrega4backend.service.impl;

import cl.amisoft.entrega4backend.dao.UsuarioDao;
import cl.amisoft.entrega4backend.model.Usuario;
import cl.amisoft.entrega4backend.service.UsuarioService;
import cl.amisoft.entrega4backend.vo.UsuarioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioDao usuarioDao;

    @Autowired
    public UsuarioServiceImpl(UsuarioDao usuarioDao){
        this.usuarioDao = usuarioDao;
    }


    @Override
    @Transactional
    public String crearUsuario(String nombre, String apellido, Long rut, Character rutDv){
        String resultado = usuarioDao.crearUsuario(nombre, apellido, rut, rutDv);
        if (Objects.equals(resultado, "Rut ya existe")) {
            return resultado;
        }else{
            return "Usuario creado exitosamente";
        }
    }

    @Override
    public List<UsuarioVo> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
        if (!usuarios.isEmpty()) {
            return usuarios.stream().map(u -> new UsuarioVo.Builder()
                    .id(u.getId())
                    .nombre(u.getNombre())
                    .apellido(u.getApellido())
                    .rut(u.getRut())
                    .rutDV(u.getRutDv())
                    .fechaCreacion(u.getFechaCreacion())
                    .fechaModificacion(u.getFechaModificacion())
                    .build()).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public String actualizarUsuario (Long id, String nuevoNombre, String nuevoApellido, Long nuevoRut, Character nuevoDv){
        String resultado = usuarioDao.actualizarUsuario(id, nuevoNombre, nuevoApellido, nuevoRut, nuevoDv);
        if (Objects.equals(resultado, "No se encontró el usuario")) {
            return resultado;
        }else{
            return "Usuario actualizado correctamente";
        }
    }

    @Override
    @Transactional
    public String eliminarUsuario (Long id){
        String resultado = usuarioDao.eliminarUsuario(id);
        if (Objects.equals(resultado, "Usuario no existe")) {
            return resultado;
        }else{
            return "Usuario eliminado correctamente";
        }
    }

}
