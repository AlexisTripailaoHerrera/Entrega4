import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioEliminado, UsuarioVo } from '../models/users.model';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private baseUrl = 'http://localhost:8080/usuario';

  constructor(private http: HttpClient) { }

  obtenerUsuarios(): Observable<UsuarioVo[]> {
    return this.http.get<UsuarioVo[]>(this.baseUrl);
  }

  crearUsuario(nombre: string, apellido: string, rut: number, rutDv: string): Observable<any> {
    const usuarioData = {
      nombre: nombre,
      apellido: apellido,
      rut: rut,
      rutDv: rutDv
    };
    return this.http.post(`${this.baseUrl}`, usuarioData, { responseType: 'text' })
      .pipe(
        map((response: any) => {
          return { mensaje: response };
        })
      );
  }

  borrarUsuario(id: any): Observable<any> {
    return this.http.delete(this.baseUrl, {
      body: { id: id },
      responseType: 'text'
    }).pipe(
      map((response: any) => {
        return { mensaje: response };
      })
    );
  }

  obtenerUsuario(id: number): Observable<UsuarioVo> {
    return this.http.get<UsuarioVo>(`${this.baseUrl}/${id}`);
  }

  actualizarUsuario(id: number, nuevoNombre: string, nuevoApellido: string, nuevoRut: number, nuevoDv: string): Observable<string> {
    return this.http.put<string>(this.baseUrl, {
      id: id,
      nuevoNombre: nuevoNombre,
      nuevoApellido: nuevoApellido,
      nuevoRut: nuevoRut,
      nuevoDv: nuevoDv
    });
  }

  obtenerUsuariosEliminados(): Observable<UsuarioEliminado[]> {
    return this.http.get<UsuarioEliminado[]>(`${this.baseUrl}/eliminados`);
  }

}

