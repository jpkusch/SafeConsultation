import { Appointment } from '../models/Appointment';

export class Doctor {
  id: number;
  username: string;
  password: string;
  specialty: string;
  appointments: Appointment[];

  constructor(id: number,
              username: string,
              password: string,
              specialty: string,
              appointments: Appointment[]) {

      this.id = id;
      this.username = username;
      this.password = password;
      this.specialty = specialty;
      this.appointments = appointments;

    }

}
