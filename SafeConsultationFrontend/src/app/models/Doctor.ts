import { Appointment } from '../models/Appointment';

export class Doctor {
  did: number;
  username: string;
  password: string;
  specialty: string;
  appointments: Appointment[];

  constructor(did: number,
              username: string,
              password: string,
              specialty: string,
              appointments: Appointment[]) {

      this.did = did;
      this.username = username;
      this.password = password;
      this.specialty = specialty;
      this.appointments = appointments;

    }

}