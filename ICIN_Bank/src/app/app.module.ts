import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule, NgModel } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { LoginComponent } from './login/login.component';
import { CheckbookRequestsComponent } from './checkbook-requests/checkbook-requests.component';
import { HttpClientModule} from '@angular/common/http';
import { AuthorizeRegistrationComponent } from './authorize-registration/authorize-registration.component';


import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    UserAccountComponent,
    LoginComponent,
    CheckbookRequestsComponent,
    AuthorizeRegistrationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
