import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GrandchildComponentComponent } from './grandchild-component.component';

describe('GrandchildComponentComponent', () => {
  let component: GrandchildComponentComponent;
  let fixture: ComponentFixture<GrandchildComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GrandchildComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GrandchildComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
