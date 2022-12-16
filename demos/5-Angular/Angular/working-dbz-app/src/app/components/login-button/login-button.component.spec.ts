import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { UserService } from 'src/app/services/user.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { LoginButtonComponent } from './login-button.component';
import { By } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { MdbModalModule } from 'mdb-angular-ui-kit/modal';

describe('LoginButtonComponent', () => {
  let component: LoginButtonComponent;
  let fixture: ComponentFixture<LoginButtonComponent>;
  let de: DebugElement; //Using Debug element, you can query the dom for further testing
  let el: HTMLElement; //This will be used to store elements with DebugElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginButtonComponent ],
       // providers dictate how services are injected/accomplish what they're designed to do
       //providers are NOT services!
       //service is an object in your application vs. provider tells angular how to create & access an object in your application
      providers: [{
        provide: UserService,
        useClass: UserService
      }],
      imports: [
        RouterTestingModule, 
        HttpClientTestingModule,
        NgbModule,
        FormsModule,
        MdbModalModule
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  xit('should create', () => {
    expect(component).toBeTruthy();
  });

  //to tell Karma/Jasmine to wait on the component to finish processing, we must use the waitAsync function
  it('should submit as true', waitForAsync(() => {
    de = fixture.debugElement.query(By.css("form"));
    el = de.nativeElement;

    console.log("This is how many elements are in our form: " + el.children.length);

    component.onSubmit(); // WHEN this....
    expect(component.submitted).toBeTruthy();  // EXPECT THIS (comes from Jasmine (testing framework))
  }))
});
