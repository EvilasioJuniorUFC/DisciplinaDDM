import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Home', url: '/home', icon: 'home' },
    { title: 'Botao', url: '/botao', icon: 'arrow-forward-circle' },
    { title: 'Lista', url: '/lista', icon: 'list' },
    { title: 'Alerta', url: '/alerta', icon: 'alert' },
    { title: 'Local Storage', url: '/local-storage', icon: 'analytics' },
    { title: 'Ionic Storage', url: '/ionic-storage', icon: 'analytics' },
    { title: 'Firebase', url: '/firebase', icon: 'cloud' },
    { title: 'Camera', url: '/camera', icon: 'camera' },
  ];
  public labels = ['Family', 'Friends', 'Notes', 'Work', 'Travel', 'Reminders'];
  constructor() {}
}
