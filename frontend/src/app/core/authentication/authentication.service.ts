import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  username = new BehaviorSubject<string>("");
  roles = new BehaviorSubject<string[]>([]);

  constructor() { }
}
