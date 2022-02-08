import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material/core";
import {BackendApiService} from "../../../../core/services/backend-api.service";
import {AuthenticationService} from "../../../../core/authentication/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {
  formGroup = new FormGroup({
    username: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", [Validators.required]),
  });

  matcher = new ErrorStateMatcher();

  constructor(private backendApiService: BackendApiService, private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  }

  login(): void {
    this.authenticationService.username = this.formGroup.get("username")?.value;
    this.authenticationService.password = this.formGroup.get("password")?.value;

    this.backendApiService.getPersonByEmail().subscribe(res => {
      this.authenticationService.person = res;

      this.router.navigate(["/"]);
    }, error => alert("Wrong credentials"));
  }
}
