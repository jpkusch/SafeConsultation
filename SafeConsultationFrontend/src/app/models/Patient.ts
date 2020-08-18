import {Appointment} from '../models/Appointment';

export class Patient{
    pid:number;
    username:string;
    password:string;
    age:number;
    weight:number;
    height:number;
    bloodType:string;
    appointments:Array<Appointment>;

    constructor(pid:number, username:string, password:string, age:number, weight:number, height:number, bloodType:string, appointments:Array<Appointment>){
      
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