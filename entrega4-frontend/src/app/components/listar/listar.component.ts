import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/user.service';
import { UsuarioVo } from '../../models/users.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrl: './listar.component.css'
})
export class ListarComponent implements OnInit {

  usuarios: UsuarioVo[] = [];

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  ngOnInit(): void {
    this.obtenerUsuarios();
  }

  obtenerUsuarios(): void {
    this.usuarioService.obtenerUsuarios()
      .subscribe(usuarios => this.usuarios = usuarios);
  }

  borrarUsuario(id: any, index: any) {
    this.usuarioService.borrarUsuario(id).subscribe({
      next: (response) => {
        this.usuarios.splice(index, 1);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  goToEdit(id: any) {
    localStorage.setItem('id', id);
    this.router.navigate(['ModificarUsuario']);
  }
}
