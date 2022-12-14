import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnotherComponentComponent } from './another-component.component';

describe('AnotherComponentComponent', () => {
  let component: AnotherComponentComponent;
  let fixture: ComponentFixture<AnotherComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnotherComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnotherComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
