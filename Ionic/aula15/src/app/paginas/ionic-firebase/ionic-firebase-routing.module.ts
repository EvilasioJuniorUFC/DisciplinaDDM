import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IonicFirebasePage } from './ionic-firebase.page';

const routes: Routes = [
  {
    path: '',
    component: IonicFirebasePage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class IonicFirebasePageRoutingModule {}
