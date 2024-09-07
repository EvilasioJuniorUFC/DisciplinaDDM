import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';
import { provideFirestore, getFirestore } from '@angular/fire/firestore';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { IonicStorageModule } from '@ionic/storage-angular';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, IonicStorageModule.forRoot()],
  providers: [  Storage, { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }, provideFirebaseApp(() => initializeApp({"projectId":"disciplinaddm","appId":"1:306536232204:web:f9aa1748353f7bfc1a4529","storageBucket":"disciplinaddm.appspot.com","apiKey":"AIzaSyCvrXdNPqXNfw3w__IBQFnQZ3YXuh0OVu8","authDomain":"disciplinaddm.firebaseapp.com","messagingSenderId":"306536232204"})), provideFirestore(() => getFirestore())],
  bootstrap: [AppComponent],
})



export class AppModule {}
