import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarComponent } from './components/listar/listar.component';
import { CrearComponent } from './components/crear/crear.component';
import { ModificarComponent } from './components/modificar/modificar.component';

const routes: Routes = [
  {path: '', component: ListarComponent},
  {path: 'AñadirUsuario', component: CrearComponent},
  {path: 'ModificarUsuario', component: ModificarComponent},
  {path: '**', redirectTo: '/'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
