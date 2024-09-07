import { Component, OnInit } from '@angular/core';
import { AlertController, NavController } from '@ionic/angular';

@Component({
  selector: 'app-alerta',
  templateUrl: './alerta.page.html',
  styleUrls: ['./alerta.page.scss'],
})
export class AlertaPage implements OnInit {

  protected nameInput: string = "";
  protected nome = "";
  constructor(private alertController: AlertController, public navCtrl: NavController) { }

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
            this.nameInput = ""
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
