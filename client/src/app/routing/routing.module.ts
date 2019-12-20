import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from '../home/home.component';
import { RecipeListComponent } from "../recipe-list/recipe-list.component";
import { LabelListComponent} from "../label-list/label-list.component";
import { RecipeComponent } from "../recipe/recipe.component";
import { NewRecipeComponent } from "../new-recipe/new-recipe.component";
import {LoginComponent} from "../login/login.component";
import {LoggedInComponent} from "../logged-in/logged-in.component";
import {SignUpComponent} from "../sign-up/sign-up.component";
import { NewLabelComponent} from "../new-label/new-label.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'recipes', component: RecipeListComponent },
  { path: 'recipe/:id', component: RecipeComponent },
  { path: 'new-recipe', component: NewRecipeComponent },
  { path: 'labels', component: LabelListComponent },
  { path: 'new-label', component: NewLabelComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logged-in', component: LoggedInComponent },
  { path: 'register', component: SignUpComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
