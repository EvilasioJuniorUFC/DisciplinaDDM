import { Component, OnInit } from '@angular/core';
import { AppStorageService } from 'src/app/services/app-storage.service';

@Component({
  selector: 'app-ionic-storage',
  templateUrl: './ionic-storage.page.html',
  styleUrls: ['./ionic-storage.page.scss'],
})
export class IonicStoragePage implements OnInit {

  protected value = ""
  protected value2 = ""
  protected value3 = ""
  constructor(private AppStorageService:AppStorageService) { }

  public async setValue(){
    await this.AppStorageService.set('pais', 'brasil')
    await this.AppStorageService.set('pais2', 'Chile')
    await this.AppStorageService.set('pais3', 'Argentina')
  }
  public async getValue(){
    this.value = await this.AppStorageService.get('pais')
    this.value2 = await this.AppStorageService.get('pais2')
    this.value3 = await this.AppStorageService.get('pais3')
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
