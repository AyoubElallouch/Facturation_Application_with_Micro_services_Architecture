import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientsComponent } from './clients/clients.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { ProductsComponent } from './products/products.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FactureComponent } from './facture/facture.component';
import { FactureDetailsComponent } from './facture-details/facture-details.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent,
    ProductsComponent,
    NavbarComponent,
    FactureComponent,
    FactureDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
