import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.page.html',
  styleUrls: ['./lista.page.scss'],
})
export class ListaPage implements OnInit {


  protected rebecaImg = "https://j3news.com/wp-content/uploads/2024/08/olimpiada-2024-rebeca_andrade-olimpiadas-ginastica-1721942005.jpg"
  protected medinaImg = "/assets/medina.jpg"

  protected personas = [
    {
      name : "Medina",
      url: this.medinaImg,
      estrelas: 5 
    },
    {
      name : "Rebeca",
      url: this.rebecaImg,
      estrelas: 5 
    }
  ]


  constructor() { }

  ngOnInit() {
  }

}
