import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {environment} from "../../environments/environment";
import {map} from "rxjs";

@Component({
  selector: 'app-facture-details',
  templateUrl: './facture-details.component.html',
  styleUrls: ['./facture-details.component.css']
})
export class FactureDetailsComponent implements OnInit {
  factureId!: number;
  facture: any;


  constructor(private http: HttpClient, private router: Router, private route: ActivatedRoute) {
    this.factureId = route.snapshot.params['factureId'];
  }

  ngOnInit(): void {
    this.http.get(environment.backendHost + "FACTURE-SERVICE/factures/" + this.factureId).subscribe({
      next: (data) => {
        this.facture = data;
      },
      error: (err) => {
      }
    })
  }

  handelAddArticle(factureId: number) {

  }

  handleDeleteArticle(id: number) {
      this.http.delete(environment.backendHost + "FACTURE-SERVICE/factures/" + this.factureId +"/article/"+id);
      console.log(this.factureId, id);
      window.location.reload();
  }
}

