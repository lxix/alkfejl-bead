import { Component } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {Http} from "./services/http-client";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'client';
  constructor(
    private http: Http
  ) {
  }

  loggedIn(): boolean {
    return this.http.loggedIn()
  }

  logout(): void {
    this.http.logout();
  }
}
