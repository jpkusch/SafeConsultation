import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentsTabComponent } from './appointments-tab.component';

describe('AppointmentsTabComponent', () => {
  let component: AppointmentsTabComponent;
  let fixture: ComponentFixture<AppointmentsTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AppointmentsTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AppointmentsTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
