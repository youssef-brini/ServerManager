import { Status } from "../enum/status.enum";

export interface Serveur{
    id:number;
    ipAddress:string;
    name:string;
    memory:string;
    type:string;
    imgURL:string;
    status:Status;

}