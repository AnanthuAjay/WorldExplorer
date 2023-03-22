import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FavouriteComponent } from './components/favourite/favourite.component';
import { RecommendedComponent } from './components/recommended/recommended.component';
import { FeedbackComponent } from './components/feedback/feedback.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FavouriteComponent,
    RecommendedComponent,
    FeedbackComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
