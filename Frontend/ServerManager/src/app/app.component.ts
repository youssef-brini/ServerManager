import { Component, OnInit } from '@angular/core';
import { DataState } from './enum/data-state.enum';
import { Serveur } from './interface/serveur';
import { ServeurService } from './service/serveur.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'ServerManager';
  DataState:any = "";
  listServeurs:Serveur[] | undefined;
  constructor(private serverService:ServeurService){

  }
  ngOnInit(): void {
    this.DataState=DataState.LOADED;
    this.getAllServeurs();
  }
  getAllServeurs(){
    this.serverService.getServeurs().subscribe(data=>{
      console.log(data);
      this.listServeurs=data;
    })
  }
}
