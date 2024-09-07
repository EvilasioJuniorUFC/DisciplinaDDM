import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'folder/Inbox',
    pathMatch: 'full'
  },
  {
    path: 'folder/:id',
    loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./paginas/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'botao',
    loadChildren: () => import('./paginas/botao/botao.module').then( m => m.BotaoPageModule)
  },
  {
    path: 'lista',
    loadChildren: () => import('./paginas/lista/lista.module').then( m => m.ListaPageModule)
  },
  {
    path: 'alertas',
    loadChildren: () => import('./paginas/alertas/alertas.module').then( m => m.AlertasPageModule)
  },
  {
    path: 'local-storage',
    loadChildren: () => import('./paginas/local-storage/local-storage.module').then( m => m.LocalStoragePageModule)
  },
  {
    path: 'movie-data',
    loadChildren: () => import('./paginas/movie-data/movie-data.module').then( m => m.MovieDataPageModule)
  },
  {
    path: 'ionic-storage',
    loadChildren: () => import('./paginas/ionic-storage/ionic-storage.module').then( m => m.IonicStoragePageModule)
  },
  {
    path: 'ionic-firebase',
    loadChildren: () => import('./paginas/ionic-firebase/ionic-firebase.module').then( m => m.IonicFirebasePageModule)
  },
  {
    path: 'camera',
    loadChildren: () => import('./paginas/camera/camera.module').then( m => m.CameraPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
