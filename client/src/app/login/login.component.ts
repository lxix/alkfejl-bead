import { Component, OnInit } from '@angular/core';
import {Http} from "../services/http-client";
import {CookieService} from "ngx-cookie-service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private http: Http,
  ) { }

  ngOnInit() {
    this.http.anonym()
  }

  onSubmit(event: any) {
    if (event.target.username.value == '' || event.target.password.value == '') {
      alert('Minden mező kitöltése kötelező');
    } else {
      return this.http.login(event.target.username.value, event.target.password.value);
    }
  }

}
