import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { IonicStorageModule } from '@ionic/storage-angular';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { getFirestore, provideFirestore } from '@angular/fire/firestore';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, IonicStorageModule.forRoot()],
  providers: [Storage, { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }, provideFirebaseApp(() => initializeApp({"projectId":"crudionic-b36bb","appId":"1:904523130568:web:609f248bf56dec76de67fd","databaseURL":"https://crudionic-b36bb-default-rtdb.firebaseio.com","storageBucket":"crudionic-b36bb.appspot.com","apiKey":"AIzaSyAlMvplCkxOtwy0eqkZLp6UHKlU39J5VKg","authDomain":"crudionic-b36bb.firebaseapp.com","messagingSenderId":"904523130568"})), provideFirestore(() => getFirestore())],
  bootstrap: [AppComponent],
})
export class AppModule {}
