import { Component, OnInit } from '@angular/core';
import { UsuarioVo } from '../../models/users.model';
import { UsuarioService } from '../../services/user.service';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css'] // Corregido 'styleUrl' a 'styleUrls'
})
export class ModificarComponent implements OnInit {

  usuario: UsuarioVo | undefined;
  id: number | null = null; // Inicializado como null

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    const idString = localStorage.getItem('id'); // Obtener el ID como una cadena
    if (idString) {
      this.id = parseInt(idString); // Convertir la cadena a número
      this.obtenerUsuario(this.id); // Aquí puedes pasar el ID del usuario que deseas obtener
    }
  }

  obtenerUsuario(id: number): void {
    this.usuarioService.obtenerUsuario(id)
      .subscribe(usuario => this.usuario = usuario);
  }

}

