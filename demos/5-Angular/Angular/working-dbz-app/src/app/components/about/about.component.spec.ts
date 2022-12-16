import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AboutComponent } from './about.component';

//we define a test suite with the describe keyword
describe('AboutComponent', () => {
  let component: AboutComponent;
  let fixture: ComponentFixture<AboutComponent>;
  let de: DebugElement; //Using Debug element, you can query the dom for further testing
  let el: HTMLElement; //This will be used to store elements with DebugElement

  //Just like in Java, you can set up and teardown your test suite and specs by
  //using beforeEach, beforeAll, afterEach, and afterAll keywords
  beforeEach(async () => {
    await TestBed.configureTestingModule({ //this configures the environment for the class we want to test
      declarations: [ AboutComponent ],
      schemas: [ CUSTOM_ELEMENTS_SCHEMA ] //will allow this component to run its test in isolation to other components that are also rendered on the webpage at the same time (aka login-buttom, navbar, etc.)
    })
    //after set the environment, we will be loading in all components
    .compileComponents();
  });

  //after we've compiled our components, we can initialize our variables to test
  beforeEach(() => {
    fixture = TestBed.createComponent(AboutComponent);
    component = fixture.componentInstance; //AboutComponent test instance

    //because we are running our test in Karma, Angular loses some of its functionality to detect changes to the browser
    //therefore our fixure must use detectChanges to see the latest on the browser
    fixture.detectChanges();
  });

  //this is an example of a sanity test
  //Sanity test will just check that the component was created
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //to make a test case, use the it keyword
  it('should have title as "About DBZ API"', () => {
    //testing the h1 element that has class called main-title
    de = fixture.debugElement.query(By.css('.main-title'));
    el = de.nativeElement;

    console.log("This is the element content found: " + el.textContent);

    //now we can check if there is some text on that element
    expect(el?.textContent).not.toBeNull();
    //now we will check to see if the title rendered correctly
    expect(el?.textContent).toContain('About DBZ API');
  });

  //this is how you can disable a test from running by using the xit keyword
  xit('is very bad test', () => {
    expect(null).not.toBeNull();
  })
});
