export interface UsuarioVo {
    id: number;
    nombre: string;
    apellido: string;
    rut: string;
    rutDV: string;
    fechaCreacion: Date;
    fechaModificacion: Date;
}

export interface UsuarioEliminado {
    id:number;
    nombreEliminado: string;
    apellidoEliminado: string;
    rutEliminado: number;
    rutDvEliminado: string;
    fechaEliminacion: Date;
}
