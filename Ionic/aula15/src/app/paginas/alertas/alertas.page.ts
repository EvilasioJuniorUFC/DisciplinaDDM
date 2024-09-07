import { Component, OnInit } from '@angular/core';
import { AlertController, NavController } from '@ionic/angular';

@Component({
  selector: 'app-alertas',
  templateUrl: './alertas.page.html',
  styleUrls: ['./alertas.page.scss'],
})
export class AlertasPage implements OnInit {

  constructor(private alertController: AlertController, public navCtrl: NavController) { }

  protected nameInput: string = "";
  protected nome = "";

  public async abrirAlerta(){
    const alert = await this.alertController.create({
      header: 'Aviso',
      subHeader: 'importante',
      message: 'Você é '+this.nameInput,
      buttons: [
        {
        text: 'Cancelar',
        role: 'cancel',
        handler: () => {
          console.log('Alert cancelado');
          }
        },
        {
          text: 'OK',
          role: 'confirm',
          handler: () => {
            this.nome = this.nameInput
            console.log('Alert confirmado');
          }
        }
      ],
    });

    await alert.present();
  }

  ngOnInit() {
  }

}
