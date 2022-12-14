import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestComponentComponent } from './test-component/test-component.component';
import { AnotherComponentComponent } from './another-component/another-component.component';
import { GrandchildComponentComponent } from './grandchild-component/grandchild-component.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponentComponent,
    AnotherComponentComponent,
    GrandchildComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
