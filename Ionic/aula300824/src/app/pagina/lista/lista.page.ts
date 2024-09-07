import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.page.html',
  styleUrls: ['./lista.page.scss'],
})
export class ListaPage implements OnInit {

  imgHugo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiJEwy9nzX0OuTgR-hJCb6vY0O9Bk7Vf0uCg&s"
  imgRebeca ="/assets/rebeca.webp"

  protected personas = [
    {
      name : "Rebeca",
      img: this.imgRebeca,
      estrelas: 5 
    },
    {
      name : "Hugo",
      img: this.imgHugo,
      estrelas: 4 
    }
  ]

  constructor() { }

  ngOnInit() {
  }



}
