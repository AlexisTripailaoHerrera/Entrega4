package cl.amisoft.entrega4backend.controller;

import cl.amisoft.entrega4backend.dto.UsuarioActualizarRequest;
import cl.amisoft.entrega4backend.dto.UsuarioCrearRequest;
import cl.amisoft.entrega4backend.dto.UsuarioEliminarRequest;
import cl.amisoft.entrega4backend.model.Usuario;
import cl.amisoft.entrega4backend.service.UsuarioService;
import cl.amisoft.entrega4backend.vo.UsuarioVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/{id}", produces = "application/json")
    public UsuarioVo obtenerUsuario(@PathVariable(name = "id") Long id){
        return usuarioService.obtenerUsuario(id);
    }


    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> actualizarUsuario(@RequestBody UsuarioActualizarRequest request) {
        Usuario user = usuarioService.actualizarUsuario(request.getId(), request.getNuevoNombre(), request.getNuevoApellido(), request.getNuevoRut(), request.getNuevoDv());

        if (user != null) {
            return ResponseEntity.ok().body("{\"message\": \"Usuario actualizado correctamente\"}");
        } else {
            return ResponseEntity.notFound().build();
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
