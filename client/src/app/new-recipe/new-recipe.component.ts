import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from "@angular/router";


@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.scss']
})
export class NewRecipeComponent implements OnInit {

  recipeUrl = 'http://localhost:4200/api/recipe';
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
      title: event.target.title.value,
      description: event.target.description.value,
      body: event.target.body.value
    };

    return this.http
      .post(this.recipeUrl, JSON.stringify(this.data), {headers: this.httpOptions.headers})
      .toPromise()
      .then(res => console.log(res));

  }

  goHome() {
    return this.router.navigate(['/']);
  }

}
