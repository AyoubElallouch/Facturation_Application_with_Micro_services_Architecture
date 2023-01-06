import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  errorMessage!: String;
  products: any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get(environment.backendHost + "PRODUCT-SERVICE/products/").subscribe({
      next: (data)=>{
        this.products = data;
      },
      error : (err)=>{}
    })
  }

  handelNewProduct() {

  }
}
