import { Component } from '@angular/core';
import { collection, collectionData, Firestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {
  protected livros$ = collectionData(collection(this.firestore, 'Livros')) as Observable<Livro[]>
  constructor(private readonly firestore: Firestore){}

}

export interface Livro{
  titulo:string; 
 }
