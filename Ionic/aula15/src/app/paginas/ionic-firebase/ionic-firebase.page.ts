import { Component, inject, OnInit } from '@angular/core';
import { Firestore, collection, collectionData } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-ionic-firebase',
  templateUrl: './ionic-firebase.page.html',
  styleUrls: ['./ionic-firebase.page.scss'],
})
export class IonicFirebasePage implements OnInit {
  protected items: any
  protected livros$ = collectionData(collection(this.firestore, 'Livros')) as Observable<Livro[]>
  constructor(private readonly firestore: Firestore) { 
    const aCollection = collection(this.firestore, 'Livros')
    this.items = collectionData(aCollection);
  }

  

  ngOnInit() {
  }



}

export interface Livro{
  titulo:string; 
 }
