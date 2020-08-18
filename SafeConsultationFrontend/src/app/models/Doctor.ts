import { Appointment } from '../models/Appointment';

export class Doctor{
    did:number;
    username:string;
    password:string;
    specialty:string;
    appointments:Array<Appointment>;

    constructor(did:number, username:string, password:string, specialty:string, appointments:Array<Appointment>){
        this.did = did;
        this.username = username;
        this.password = password;
        this.specialty = specialty;
        this.appointments = appointments;
    }
}