import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http} from "../services/http-client";

@Component({
  selector: 'app-label-list',
  templateUrl: './label-list.component.html',
  styleUrls: ['./label-list.component.scss']
})

export class LabelListComponent implements OnInit {

  labelsUrl = 'http://localhost:4200/api/label';

  labels = [];
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
    })
  };

  constructor(private http: HttpClient, private log: Http) { }


  ngOnInit() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
      })
    };

    this.http.get(this.labelsUrl, this.httpOptions).subscribe((data: any[]) => {
      this.labels = data;
    });
  }

  deleteLabel(id) {
    return this.http.delete(this.labelsUrl + '/' + id, {headers: this.httpOptions.headers})
      .toPromise()
      .then(() => {
        location.reload();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  loggedIn() {
    return this.log.loggedIn()
  }

}
