import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Serveur } from '../interface/serveur';
import {  throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
@Injectable({
  providedIn: 'root'
})

export class ServeurService {
  URL: string = "http://10.66.13.89:8080/";
  constructor(private http: HttpClient) {

  }
  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${"we can't add this server check if your Address has aleady included !!!"}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  getServeurs(): Observable<Serveur[]> {
    return this.http.get<any>(this.URL + "serveur")
  }
  getPing(ipAddress: string): Observable<any> {
    return this.http.get<any>(this.URL + "serveur/ping/" + ipAddress);
  }
  getServeur(id: number): Observable<any> {
    return this.http.get<any>(this.URL + "serveur/" + id);
  }
  addServeur(val: Serveur) {
      console.log(val);
    return this.http.post(this.URL + "serveur", val).pipe(catchError(this.handleError));
  }
  deleteServeur(id: number) {
    return this.http.delete(this.URL + "serveur/" + id);
  }
  updateServeur(val: Serveur) {
    return this.http.put(this.URL + "serveur", val);
  }
}
