import { ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicFirebasePage } from './ionic-firebase.page';

describe('IonicFirebasePage', () => {
  let component: IonicFirebasePage;
  let fixture: ComponentFixture<IonicFirebasePage>;

  beforeEach(() => {
    fixture = TestBed.createComponent(IonicFirebasePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
