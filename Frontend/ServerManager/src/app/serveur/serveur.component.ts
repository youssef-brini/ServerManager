import { Component, OnInit } from '@angular/core';
import { Status } from '../enum/status.enum';
import { Serveur } from '../interface/serveur';
import { DataState } from '../enum/data-state.enum';
import { ServeurService } from '../service/serveur.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-serveur',
  templateUrl: './serveur.component.html',
  styleUrls: ['./serveur.component.css']
})
export class ServeurComponent implements OnInit {

  DataState:any = "";
  listServeurs:Serveur[] | undefined;
  readonly stat: Status = Status.SERVER_UP;
   pingState = '';
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
PingServeur(ipAddress:string){
   this.serverService.getPing(ipAddress).subscribe(data=>{
    this.getAllServeurs();
  })

}
AddServeur(serveurForm:NgForm){
  this.serverService.addServeur(serveurForm.value).subscribe(data=>{
   this.getAllServeurs();
 })

}

}
