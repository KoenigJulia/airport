import { Injectable } from '@angular/core';
import {Person} from "../../shared/models/person.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  username = ""
  password = ""

  person : Person | undefined

  constructor() { }
}
