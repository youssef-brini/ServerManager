import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Serveur } from '../interface/serveur';

@Injectable({
  providedIn: 'root'
})

export class ServeurService {
  URL: string = "http://localhost:8080/";
  constructor(private http: HttpClient) {

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
    return this.http.post(this.URL + "serveur", val);
  }
  deleteServeur(id: number) {
    return this.http.delete(this.URL + "serveur/" + id);
  }
  updateServeur(val: Serveur) {
    return this.http.put(this.URL + "serveur", val);
  }
}
