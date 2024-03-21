import { Component, OnInit } from '@angular/core';
import { UsuarioVo } from '../../models/users.model';
import { UsuarioService } from '../../services/user.service';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {

  usuario: UsuarioVo | undefined;
  id: number | null = null;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    const idString = localStorage.getItem('id');
    if (idString) {
      this.id = parseInt(idString);
      this.obtenerUsuario(this.id);
    }
  }

  obtenerUsuario(id: number): void {
    this.usuarioService.obtenerUsuario(id)
      .subscribe(usuario => this.usuario = usuario);
  }

  actualizarUsuario(): void {
    if (this.usuario) {
      const rut = parseInt(this.usuario.rut) !== null ? parseInt(this.usuario.rut) : 0; // Valor predeterminado de 0 si this.nuevoRut es null
      this.usuarioService.actualizarUsuario(this.usuario.id, this.usuario.nombre, this.usuario.apellido, rut, this.usuario.rutDV)
        .subscribe(resultado => {
          console.log(resultado);
          // Puedes agregar lógica adicional aquí, como redirigir a otra página o mostrar un mensaje de éxito
        });
    }
  }

}


