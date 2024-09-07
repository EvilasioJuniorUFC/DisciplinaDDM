import { Component, OnInit } from '@angular/core';
import { collection, collectionData, Firestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-firebase',
  templateUrl: './firebase.page.html',
  styleUrls: ['./firebase.page.scss'],
})
export class FirebasePage implements OnInit {

  protected filmes$ = collectionData(collection(this.firestore, 'Movies')) as Observable<Filme[]>
  constructor(private readonly firestore: Firestore){
    console.log(collectionData(collection(this.firestore, 'Movies')))
  }

  ngOnInit() {
  }

}

export interface Filme{
  titulo:string
  anolancamento:string 
}
