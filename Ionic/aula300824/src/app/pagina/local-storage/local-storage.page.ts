import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-local-storage',
  templateUrl: './local-storage.page.html',
  styleUrls: ['./local-storage.page.scss'],
})
export class LocalStoragePage implements OnInit {

  protected tituloSave = "" 
  protected anolancamentoSave = ""

  constructor(private nav:NavController) { }

  public localStoreSave(tituloSave:string,anolancamentoSave:string){
    window.localStorage.setItem("titulo", tituloSave)
    window.localStorage.setItem("anolancamento", anolancamentoSave)
    
    console.log("salvando dados no local storage")
    this.tituloSave = ""
    this.anolancamentoSave = ""
  }

  public localStoreLoad(){
    this.nav.navigateForward("movie-data");   
    console.log("lendo dados do local storage")
  }

  ngOnInit() {
  }

}
