import { Component } from '@angular/core';
import { UsuarioService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrl: './crear.component.css'
})
export class CrearComponent {
  nombre: string = '';
  apellido: string = '';
  rut: number = 0;
  rutDv: string = '';
  resultado: string = '';

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  crearUsuario(): void {
    this.usuarioService.crearUsuario(this.nombre, this.apellido, this.rut, this.rutDv)
      .subscribe(
        resultado => {
          this.resultado = resultado.mensaje;
          if (resultado.mensaje === "Usuario creado exitosamente") {
            this.router.navigate(['/']);
          }
        },
        error => {
          console.error('Error al crear usuario:', error);
        }
      );
  }

  back(): void {
    this.router.navigate(['/'])
  }

}