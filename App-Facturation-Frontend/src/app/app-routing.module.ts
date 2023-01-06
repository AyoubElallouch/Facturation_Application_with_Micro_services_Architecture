import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ClientsComponent} from "./clients/clients.component";
import {ProductsComponent} from "./products/products.component";
import {FactureComponent} from "./facture/facture.component";
import {FactureDetailsComponent} from "./facture-details/facture-details.component";

const routes: Routes = [
  {path : "clients", component: ClientsComponent},
  {path : "products", component: ProductsComponent},
  {path : "factures", component: FactureComponent},
  {path : "details", component: FactureDetailsComponent},
  {path : "details/:factureId", component: FactureDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
