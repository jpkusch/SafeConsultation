import {Appointment} from '../models/Appointment';

export class Patient{

    pid:number;
    username:string;
    password:string;
    age:number;
    height:number;
    weight:number;
    bloodType:string;
    appointments: Appointment[];

    constructor(pid:number, username:string, password:string, age:number,  height:number, weight:number, bloodType:string,  appointments: Appointment[]){

        this.pid = pid;
        this.username = username;
        this.password = password;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.bloodType = bloodType;
        this.appointments = appointments; 
    }

}