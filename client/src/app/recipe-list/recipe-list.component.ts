import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http} from "../services/http-client";

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.scss']
})
export class RecipeListComponent implements OnInit {

  recipesUrl = 'http://localhost:4200/api/recipe';

  recipes = [];

  constructor(private http: HttpClient, private log: Http) { }

  ngOnInit() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
      })
    };

    this.http.get(this.recipesUrl, httpOptions).subscribe((data: any[]) => {
      this.recipes = data;
    });
  }

  loggedIn() {
    return this.log.loggedIn()
  }

}
