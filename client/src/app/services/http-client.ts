import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import {Router} from "@angular/router";

@Injectable()
export class Http {

  public static readonly credentialsCookieName: string = 'recipe-book-credentials';

  constructor(
    private http: HttpClient,
    private cookieService: CookieService,
    private router: Router
  ){
  }

  register(options: object): boolean {
    return false; // TODO: impl
  }

  login(username: string, password: string) {
    const loginToken = this.getLoginToken(username, password);

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic ' + loginToken,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    this.http
      .post('http://localhost:4200/api/login', JSON.stringify({}), {headers: httpOptions.headers})
      .subscribe(next => {
      }, error => {
        if (error.status == 404) {
          this.cookieService.set( Http.credentialsCookieName, loginToken);
          this.router.navigateByUrl('logged-in');
        } else {
          alert('Nem sikerült bejelentkezni.');
        }
      });
  }

  guard(): void {
    if (! this.loggedIn()) {
      this.router.navigateByUrl('')
    }
  }

  anonym(): void {
    if (this.loggedIn()) {
      this.router.navigateByUrl('logged-in')
    }
  }

  private getLoginToken(username: string, password: string): string {
    return btoa(username + ':' + password);
  }

  loggedIn(): boolean {
    return this.cookieService.check(Http.credentialsCookieName)
      && this.cookieService.get(Http.credentialsCookieName) != '';
  }

  logout(): void {
    this.cookieService.delete(Http.credentialsCookieName);
    window.location.reload();
  }

  private createAuthorizationHeader(headers: HttpHeaders) {
    if (this.loggedIn()) {
      headers.append('Authorization', 'Basic ' + this.cookieService.get(Http.credentialsCookieName));
    }
  }

  get(url) {
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.http.get(url, {
      headers: headers
    });
  }

  post(url, data) {
    let headers = new HttpHeaders();
    this.createAuthorizationHeader(headers);
    return this.http.post(url, data, {
      headers: headers
    });
  }
}
