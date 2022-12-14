import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appColorDirective]'
})
export class ColorDirectiveDirective {

  /**
   * This is an example of a custom attribute directive 
   *  In this case I'm defining a functino that will trigger over an event, mouseenter
   */

  // @HostListener('mouseenter') 
  // onMouseEnter(){
  //   this.element.nativeElement.style.color = "ForestGreen";
  // }


  //Angular will create this directive, provide the dependencies we need by looking at the construtor. 
  constructor(private element: ElementRef) { 

    this.element.nativeElement.style.color = "ForestGreen"

  }

}
