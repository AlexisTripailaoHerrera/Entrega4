import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioVo } from '../models/users.model';
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
          return { mensaje: response }; // Transforma el texto simple en un objeto JSON con la propiedad "mensaje"
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



}

