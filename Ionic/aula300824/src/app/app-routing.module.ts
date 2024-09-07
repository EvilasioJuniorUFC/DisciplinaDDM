import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'folder/:id',
    loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./pagina/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'botao',
    loadChildren: () => import('./pagina/botao/botao.module').then( m => m.BotaoPageModule)
  },
  {
    path: 'lista',
    loadChildren: () => import('./pagina/lista/lista.module').then( m => m.ListaPageModule)
  },
  {
    path: 'alerta',
    loadChildren: () => import('./pagina/alerta/alerta.module').then( m => m.AlertaPageModule)
  },
  {
    path: 'local-storage',
    loadChildren: () => import('./pagina/local-storage/local-storage.module').then( m => m.LocalStoragePageModule)
  },
  {
    path: 'movie-data',
    loadChildren: () => import('./pagina/movie-data/movie-data.module').then( m => m.MovieDataPageModule)
  },
  {
    path: 'ionic-storage',
    loadChildren: () => import('./pagina/ionic-storage/ionic-storage.module').then( m => m.IonicStoragePageModule)
  },
  {
    path: 'firebase',
    loadChildren: () => import('./pagina/firebase/firebase.module').then( m => m.FirebasePageModule)
  },
  {
    path: 'camera',
    loadChildren: () => import('./pagina/camera/camera.module').then( m => m.CameraPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
