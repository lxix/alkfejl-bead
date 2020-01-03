import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-label',
  templateUrl: './new-label.component.html',
  styleUrls: ['./new-label.component.scss']
})
export class NewLabelComponent implements OnInit {

  labelUrl = 'http://localhost:4200/api/label';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
    })
  };
  data;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }


  onSubmit(event: any) {

    this.data = {
      label: event.target.label.value
    };


    return this.http
      .post(this.labelUrl, JSON.stringify(this.data), {headers: this.httpOptions.headers})
      .toPromise()
      .then(res => console.log(res));

  }

  goHome() {
    return this.router.navigate(['/']);
  }

}
