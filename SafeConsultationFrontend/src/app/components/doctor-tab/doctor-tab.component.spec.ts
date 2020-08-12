import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorTabComponent } from './doctor-tab.component';

describe('DoctorTabComponent', () => {
  let component: DoctorTabComponent;
  let fixture: ComponentFixture<DoctorTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
