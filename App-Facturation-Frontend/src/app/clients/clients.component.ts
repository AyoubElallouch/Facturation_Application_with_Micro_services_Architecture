import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  clients : any;
  errorMessage! : string;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get(environment.backendHost + "CLIENT-SERVICE/clients/").subscribe({
      next: (data)=>{
        this.clients = data;
      },
      error : (err)=>{}
    })
  }

  handelNewClient() {

  }
}
