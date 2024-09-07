import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MovieDataPage } from './movie-data.page';

describe('MovieDataPage', () => {
  let component: MovieDataPage;
  let fixture: ComponentFixture<MovieDataPage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieDataPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
