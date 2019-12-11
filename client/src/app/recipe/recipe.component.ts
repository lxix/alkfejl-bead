import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-recipe',
  templateUrl: './recipe.component.html',
  styleUrls: ['./recipe.component.scss']
})
export class RecipeComponent implements OnInit {

  recipeUrl = 'http://localhost:4200/api/recipe';
  recipe;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'Basic YWRtaW46cGFzc3dvcmQ=' // TODO: ezt a routet publicra állítani
    })
  };

  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit() {

    const id = this.route.snapshot.paramMap.get('id');

    this.http.get(this.recipeUrl + '/' + id, this.httpOptions).subscribe((data: any[]) => {
      // TODO id alapjan lekerni
      this.recipe = data;
    });
  }

  deleteRecipe(id) {
    return this.http.delete(this.recipeUrl + '/' + id, {headers: this.httpOptions.headers})
      .toPromise()
      .then(() => null)
      .catch((e) => {
        console.log(e);
      });
  }

}
