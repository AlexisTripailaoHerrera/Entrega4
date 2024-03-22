import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/user.service';
import { UsuarioEliminado } from '../../models/users.model';

@Component({
  selector: 'app-listar-eliminados',
  templateUrl: './listar-eliminados.component.html',
  styleUrl: './listar-eliminados.component.css'
})
export class ListarEliminadosComponent implements OnInit {

  eliminados: UsuarioEliminado[] = [];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.obtenerUsuariosEliminados();
  }

  obtenerUsuariosEliminados(): void {
    this.usuarioService.obtenerUsuariosEliminados()
      .subscribe(eliminados => this.eliminados = eliminados);
  }

}
