import { Injectable } from '@angular/core';
import { Http , Response, Headers, RequestOptions} from '@angular/http';
import { Observable } from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class AutenticacionService {

    constructor(public http: Http) { }
    
    public iniciaSesion( usuario: string , contrasena: string): Observable<boolean> {
        console.log ('Inicio de sesion');
        let headers = new Headers({'Content-Type':'X-custom'});
        let options = new RequestOptions ({headers: headers})
        
        
        
        
        return this.http.get ('http://localhost:8080/login', options)
            .map ( (res: Response) => { return (res.json().usuario === usuario 
                                             && res.json().contrasena === contrasena); } )
            .catch ((err: any) => { console.log (err);
                                    return Observable.throw (err.statusText);
             });
        
        
    }    

}
