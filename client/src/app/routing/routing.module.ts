import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '../home/home.component';
import { RecipeListComponent } from "../recipe-list/recipe-list.component";
import { LabelListComponent} from "../label-list/label-list.component";
import { RecipeComponent } from "../recipe/recipe.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'recipes', component: RecipeListComponent },
  { path: 'recipe/:id', component: RecipeComponent },
  { path: 'labels', component: LabelListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
