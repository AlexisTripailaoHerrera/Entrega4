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
  mensaje: string = '';

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  crearUsuario(): void {
    if (this.nombre && this.apellido && this.rut && this.rutDv) {
      this.usuarioService.crearUsuario(this.nombre, this.apellido, this.rut, this.rutDv)
        .subscribe(
          resultado => {
            this.mensaje = resultado.mensaje;
            if (resultado.mensaje === "Usuario creado exitosamente") {
              this.router.navigate(['/']);
            }
          },
          error => {
            console.error('Error al crear usuario:', error);
          }
        );
    } else {
      this.mensaje = "Debes ingresar todos los campos";
    }
  }

  back(): void {
    this.router.navigate(['/'])
  }

  minimaLongitud(rut: number) {
    let longitudMinima: number = 8;
    let rutStr = rut.toString();
    let longitudRut = rutStr.length;

    if (longitudRut !== longitudMinima) {
      return true;
    } else {
      return false;
    }
  }

}