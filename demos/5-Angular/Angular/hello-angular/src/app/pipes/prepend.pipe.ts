import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'prepend'
})
export class PrependPipe implements PipeTransform {

  /**
   *  Why we do we use pipes: 
   *    They don't modify the underlying data, ust format the view. 
   *    Especially useful if multiple components rely on the same data
   */

  transform(param1: string, parame2: string): string {

    /**
     * Put some fancy logic here!
     */
    return parame2.concat(param1);
  }

}
