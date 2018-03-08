import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';


import { AutenticacionComponent } from './autenticacion/autenticacion.component';

import { AutenticacionService } from './autenticacion.service';

@NgModule({
  imports: [
      CommonModule,
      HttpModule
  ],
  
  exports: [AutenticacionComponent],
  providers: [AutenticacionService],
  declarations: [AutenticacionComponent]
})
export class LoginModule { }
