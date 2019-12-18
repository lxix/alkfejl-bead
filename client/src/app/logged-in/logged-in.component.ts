import { Component, OnInit } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {Router} from "@angular/router";
import {Http} from "../services/http-client";

@Component({
  selector: 'app-logged-in',
  templateUrl: './logged-in.component.html',
  styleUrls: ['./logged-in.component.scss']
})
export class LoggedInComponent implements OnInit {

  constructor(private http: Http) { }

  ngOnInit() {
    this.http.guard()
  }

}
