import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-label-list',
  templateUrl: './label-list.component.html',
  styleUrls: ['./label-list.component.scss']
})

export class LabelListComponent implements OnInit {

  labelsUrl = 'http://localhost:4200/api/label';

  labels = [];

  constructor(private http: HttpClient) { }


  ngOnInit() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
      })
    };

    this.http.get(this.labelsUrl, httpOptions).subscribe((data: any[]) => {
      this.labels = data;
    });
  }

}
