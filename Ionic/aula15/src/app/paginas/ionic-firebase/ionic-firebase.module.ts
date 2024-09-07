import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { IonicFirebasePageRoutingModule } from './ionic-firebase-routing.module';

import { IonicFirebasePage } from './ionic-firebase.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    IonicFirebasePageRoutingModule
  ],
  declarations: [IonicFirebasePage]
})
export class IonicFirebasePageModule {}
