package cl.amisoft.entrega4backend.service;

import cl.amisoft.entrega4backend.vo.UsuarioVo;

import java.util.List;

public interface UsuarioService {

    String crearUsuario(String nombre, String apellido, Long rut, Character rutDv);

    List<UsuarioVo> obtenerUsuarios();

    UsuarioVo obtenerUsuario(Long id);

    String actualizarUsuario (Long id, String nuevoNombre, String nuevoApellido, Long nuevoRut, Character nuevoDv);

    String eliminarUsuario (Long id);
}
