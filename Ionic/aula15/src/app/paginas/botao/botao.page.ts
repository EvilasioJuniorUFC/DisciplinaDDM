import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-botao',
  templateUrl: './botao.page.html',
  styleUrls: ['./botao.page.scss'],
})
export class BotaoPage implements OnInit {

  constructor(public nav:NavController) { }

  public abrirPagina(value:string){
    this.nav.navigateForward(value); 
  }


  ngOnInit() {
  }

}
