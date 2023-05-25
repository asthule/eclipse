import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { SignupComponent } from './signup/signup.component'
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { AddFruitComponent } from './admin/add-fruit/add-fruit.component';
import { AdminFruitsComponent } from './admin/admin-fruits/admin-fruits.component';
import { AdminOrdersComponent } from './admin-orders/admin-orders.component';
import { CartOrderComponent } from './cart-order/cart-order.component';
import { UserOrdersComponent } from './user-orders/user-orders.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SignupComponent,
    LoginComponent,
    AdminComponent,
    HomeComponent,
    AddFruitComponent,
    AdminFruitsComponent,
    AdminOrdersComponent,
    CartOrderComponent,
    UserOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
