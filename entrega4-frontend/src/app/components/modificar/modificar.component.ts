import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../services/user.service';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrl: './modificar.component.css'
})
export class ModificarComponent implements OnInit{
  id = localStorage.getItem('id');

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    
  }
}
