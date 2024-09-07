import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { defineCustomElements} from '@ionic/pwa-elements/loader'
import { IonicStorageModule } from '@ionic/storage-angular';
import { Drivers } from '@ionic/storage'
import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { importProvidersFrom } from '@angular/core';
import { provideRouter, RouteReuseStrategy } from '@angular/router';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.log(err));

  defineCustomElements(window);

  /*
bootstrapApplication(AppComponent, {
  providers: [
    {provide: RouteReuseStrategy, useClass: IonicRouteStrategy},
    importProvidersFrom(IonicModule.forRoot({})),
    importProvidersFrom(
      IonicStorageModule.forRoot({
        name: 'dataStorage',
        driverOrder: [Drivers.IndexedDB]
      })
    )
  ]
})*/