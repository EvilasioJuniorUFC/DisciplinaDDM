import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'menuprincipal',
    pathMatch: 'full',
  },
  {
    path: 'folder/:id',
    loadComponent: () =>
      import('./folder/folder.page').then((m) => m.FolderPage),
  },
  {
    path: 'menuprincipal',
    loadComponent: () => import('./menuprincipal/menuprincipal.page').then( m => m.MenuprincipalPage)
  },
];
