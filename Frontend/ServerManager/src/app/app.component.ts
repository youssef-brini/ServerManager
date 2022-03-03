import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { DataState } from './enum/data-state.enum';
import { Status } from './enum/status.enum';
import { Serveur } from './interface/serveur';
import { ServeurService } from './service/serveur.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ServerManager';
  

}
