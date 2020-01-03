import { Component, OnInit } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {Http} from "../services/http-client";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  constructor(private http: Http) { }

  ngOnInit() {
    this.http.anonym()
  }

  onSubmit(event: any) {
    if (event.target.username.value == '' || event.target.password.value == '' || event.target.again.value == '') {
      alert('Minden mező kitöltése kötelező');
    } else {
      return this.http.register(event.target.username.value, event.target.password.value, event.target.again.value);

    }
  }

}
