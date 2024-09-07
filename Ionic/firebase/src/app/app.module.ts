import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }, 
      provideFirestore(() => getFirestore()), provideFirebaseApp(() => initializeApp({"projectId":"crudionic-b36bb","appId":"1:904523130568:web:26e0f4ea9a7ef99ede67fd","databaseURL":"https://crudionic-b36bb-default-rtdb.firebaseio.com","storageBucket":"crudionic-b36bb.appspot.com","apiKey":"AIzaSyAlMvplCkxOtwy0eqkZLp6UHKlU39J5VKg","authDomain":"crudionic-b36bb.firebaseapp.com","messagingSenderId":"904523130568"}))],
  bootstrap: [AppComponent],
})
export class AppModule {}
