import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";

@Component({
  selector: 'app-facture',
  templateUrl: './facture.component.html',
  styleUrls: ['./facture.component.css']
})
export class FactureComponent implements OnInit {
  errorMessage: any;
  factures: any;

  constructor(private http: HttpClient, private router : Router) { }

  ngOnInit(): void {
    this.http.get(environment.backendHost + "FACTURE-SERVICE/factures").subscribe({
      next: (data)=>{
        this.factures = data;
      },
      error : (err)=>{}
    })  }

  handelNewBill() {

  }

  handleDetailBill(f: any) {
    this.router.navigateByUrl("/details/"+ f.id)
  }
}
