import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'teste', url: '/home', icon: 'add-circle' },
    { title: 'Home', url: '/home', icon: 'home' },
    { title: 'Botao', url: '/botao', icon: 'checkmark' },
    { title: 'Lista', url: '/lista', icon: 'list' },
    { title: 'Alertas', url: '/alertas', icon: 'alert' },
    { title: 'Local Storage', url: '/local-storage', icon: 'analytics' },
    { title: 'Movie Data', url: '/movie-data', icon: 'videocam' },
    { title: 'Ionic Storage', url: '/ionic-storage', icon: 'analytics' },
    { title: 'Camera', url: '/camera', icon: 'videocam' },
    { title: 'Firebase', url: '/ionic-firebase', icon: 'analytics' },
  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() {

  }
}
