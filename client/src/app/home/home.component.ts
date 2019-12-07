import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  todosUrl = 'https://jsonplaceholder.typicode.com/todos';

  todos = {};

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get(this.todosUrl).subscribe((data) => {
      this.todos = data;

      console.log(this.todos)
    });
  }

}
