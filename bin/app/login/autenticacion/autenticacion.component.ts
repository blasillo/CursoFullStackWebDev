import { Component, OnInit } from '@angular/core';
import { AutenticacionService } from '../autenticacion.service';

import { Observable } from "rxjs/Observable";

@Component({
  selector: 'login',
  templateUrl: './autenticacion.component.html',
  styleUrls: ['./autenticacion.component.css']
})
export class AutenticacionComponent implements OnInit {
        
    usuario: string = 'TORGARBL';
    
    sesion : boolean;
    
    errores: string = 'sin errores';

  constructor(public autenticacionSrv: AutenticacionService) { }

  ngOnInit() {
     // this.tieneSesion = this.autenticacionSrv.tieneSesion ( this.usuario) ;
  }
    
  login ( usuario: string , contrasena: string) {
      this.autenticacionSrv.iniciaSesion ( usuario, contrasena).subscribe (
          res => this.sesion = res ,
          err => this.errores = err
          );
  }

}
