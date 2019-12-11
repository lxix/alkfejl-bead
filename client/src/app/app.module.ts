import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RoutingModule } from './routing/routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatToolbarModule, MatIconModule, MatButtonModule } from '@angular/material';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import { LabelListComponent } from './label-list/label-list.component';
import { RecipeComponent } from './recipe/recipe.component';
import { NewRecipeComponent } from './new-recipe/new-recipe.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RecipeListComponent,
    LabelListComponent,
    RecipeComponent,
    NewRecipeComponent
  ],
  imports: [
    NgbModule,
    RoutingModule,
    BrowserModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
