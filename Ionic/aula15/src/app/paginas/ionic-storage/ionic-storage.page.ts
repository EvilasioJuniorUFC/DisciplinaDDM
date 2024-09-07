import { Component, OnInit } from '@angular/core';

import { AppStorageService } from 'src/app/services/app-storage.service';

@Component({
  selector: 'app-ionic-storage',
  templateUrl: './ionic-storage.page.html',
  styleUrls: ['./ionic-storage.page.scss'],
})
export class IonicStoragePage implements OnInit {

  protected value = ""
  constructor(private AppStorageService:AppStorageService) { }

  public async setValue(){
    await this.AppStorageService.set('pais', 'brasil')
  }
  public async getValue(){
    this.value = await this.AppStorageService.get('pais')
  }

  public async removeValue(){
    await this.AppStorageService.remove('pais')
  }

  public async clearStorage(){
    await this.AppStorageService.clear()
  }

  ngOnInit() {
  }

}
