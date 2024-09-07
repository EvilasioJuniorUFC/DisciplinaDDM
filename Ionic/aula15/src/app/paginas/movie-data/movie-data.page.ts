import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-movie-data',
  templateUrl: './movie-data.page.html',
  styleUrls: ['./movie-data.page.scss'],
})
export class MovieDataPage implements OnInit {

  protected titulo = window.localStorage.getItem("titulo")
  protected anolancamento = window.localStorage.getItem("anolancamento")
  constructor(public nav: NavController) { }
  public back(){
    this.nav.navigateForward("local-storage")
  }


  ngOnInit() {
  }

}
