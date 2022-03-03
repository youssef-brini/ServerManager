import { Component, OnInit } from '@angular/core';
import { Status } from '../enum/status.enum';
import { Serveur } from '../interface/serveur';
import { DataState } from '../enum/data-state.enum';
import { ServeurService } from '../service/serveur.service';
import { FormBuilder, FormGroup, NgForm } from '@angular/forms';

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
   serveurDetail !:FormGroup;
   serverNew !:FormGroup;
  constructor(private serverService:ServeurService, private formBuilder:FormBuilder){

  }
  ngOnInit(): void {
    this.DataState=DataState.LOADED;
    this.serveurDetail = this.formBuilder.group({
      id:[''],
      ipAddress:[''],
      name:[''],
      memory:[''],
      imgURL:[''],
      type:[''],
      status:['Server_Down']
    })
    this.serverNew = this.formBuilder.group({
      ipAddress:[''],
      name:[''],
      memory:[''],
      type:[''],
      status:['Server_Down']
    })
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
addServeur() {
  console.log(this.serverNew.value)
 
    this.serverService.addServeur(this.serverNew.value).subscribe(data=>{
      this.getAllServeurs();
    })
}
deleteServeur(id:number){
this.serverService.deleteServeur(id).subscribe(data=>{
  this.getAllServeurs();
})
}
editServeur(serveur:Serveur){
  this.serveurDetail.controls['id'].setValue(serveur.id);
  this.serveurDetail.controls['ipAddress'].setValue(serveur.ipAddress);
  this.serveurDetail.controls['name'].setValue(serveur.name);
  this.serveurDetail.controls['memory'].setValue(serveur.memory);
  this.serveurDetail.controls['type'].setValue(serveur.type);
  this.serveurDetail.controls['imgURL'].setValue(serveur.imgURL);
  this.serveurDetail.controls['status'].setValue(serveur.status);
}
updateServeur(){
  console.log(this.serveurDetail.value)
  this.serverService.updateServeur(this.serveurDetail.value).subscribe(data=>{
    this.getAllServeurs();
  })
}

}
