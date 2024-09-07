import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-local-storage',
  templateUrl: './local-storage.page.html',
  styleUrls: ['./local-storage.page.scss'],
})
export class LocalStoragePage implements OnInit {

  protected tituloSave: string = "";
  protected anolancamentoSave = "";
  protected tituloSaved: string = "";
  protected anolancamentoSaved = "";
  constructor(public nav:NavController) { }

  public localStoreSave(titulo:string, anolancamento:string){
    window.localStorage.setItem("titulo", titulo)
    window.localStorage.setItem("anolancamento", anolancamento)
    
    console.log("salvando dados no local storage")
    this.tituloSave = ""
    this.anolancamentoSave = ""
  }

  public localStoreLoad(){
    this.nav.navigateForward("movie-data");
    //this.tituloSaved = window.localStorage.getItem("titulo")!!
    //this.anolancamentoSaved = window.localStorage.getItem("anolancamento")!!
    
    console.log("lendo dados do local storage")
  }

  ngOnInit() {
  }

}
