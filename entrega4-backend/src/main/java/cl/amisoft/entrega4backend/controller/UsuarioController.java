package cl.amisoft.entrega4backend.controller;

import cl.amisoft.entrega4backend.dto.UsuarioActualizarRequest;
import cl.amisoft.entrega4backend.dto.UsuarioCrearRequest;
import cl.amisoft.entrega4backend.dto.UsuarioEliminarRequest;
import cl.amisoft.entrega4backend.service.UsuarioService;
import cl.amisoft.entrega4backend.vo.UsuarioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(consumes = "application/json")
    public String crearUsuario(@RequestBody UsuarioCrearRequest request){
        String resultado = usuarioService.crearUsuario(request.getNombre(), request.getApellido(), request.getRut(), request.getRutDv());
        if (Objects.equals(resultado, "Rut ya existe")) {
            return resultado;
        }else{
            return "Usuario creado exitosamente";
        }

    }


    @GetMapping(produces = "application/json")
    public List<UsuarioVo> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }


    @PutMapping(consumes = "application/json")
    public String actualizarUsuario(@RequestBody UsuarioActualizarRequest request) {
        String resultado = usuarioService.actualizarUsuario(request.getId(), request.getNuevoNombre(), request.getNuevoApellido(), request.getNuevoRut(), request.getNuevoDv());
        if (Objects.equals(resultado, "No se encontró el usuario")) {
            return resultado;
        }else{
            return "Usuario actualizado correctamente";
        }
    }

    @DeleteMapping(consumes = "application/json")
    public String eliminarUsuario (@RequestBody UsuarioEliminarRequest request){
        String resultado = usuarioService.eliminarUsuario(request.getId());
        if (Objects.equals(resultado, "Usuario no existe")) {
            return resultado;
        }else{
            return "Usuario eliminado correctamente";
        }
    }

}
