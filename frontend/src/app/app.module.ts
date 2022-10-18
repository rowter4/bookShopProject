import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { WelcomeComponent } from './welcome/welcome.component';

import { SigninService } from './signin/signin.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminLandingComponent } from './admin-landing/admin-landing.component';
import { AddNewItemsComponent } from './add-new-items/add-new-items.component';
import { AddNewItemsService } from './add-new-items/add-new-items.service';
import { BooksListComponent } from './books-list/books-list.component';
import { BooksDetailComponent } from './books-detail/books-detail.component';
import { BooksDetailService } from './books-detail/books-detail.service';
import { BooksListService } from './books-list/books-list.service';

import { CommonModule, DecimalPipe } from '@angular/common';
import { CartComponent } from './cart/cart.component';
import { CartService } from './cart/cart.service';
import { SubmitOrderService } from './cart/submitorder.service';
import { PastOrderListComponent } from './past-order-list/past-order-list.component';
import { PastOrderListService } from './past-order-list/past-order-list.service';
import { PastOrderDetailComponent } from './past-order-detail/past-order-detail.component';
import { PastORderDetailService } from './past-order-detail/past-order-detail.service';
// import { BrowserModule } from '@angular/common';


const appPath: Routes = [
  { path: '', component: SigninComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'admin-landing', component: AdminLandingComponent },
  { path: 'add-item', component: AddNewItemsComponent },
  { path: 'books-list', component: BooksListComponent },
  { path: 'books-detail/:book_id', component: BooksDetailComponent },
  { path: 'cart', component: CartComponent },
  { path: 'pastorders', component: PastOrderListComponent},
  { path: 'orderdetail/:ord_id', component: PastOrderDetailComponent},


  
  { path: '**', redirectTo: '/', pathMatch: 'full' }

]

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    WelcomeComponent,
    AdminLandingComponent,
    AddNewItemsComponent,
    BooksListComponent,
    CartComponent,
    PastOrderListComponent,
    PastOrderDetailComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(appPath, { useHash: true }),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    SigninService,
    AddNewItemsService,
    BooksDetailService,
    BooksListService,
    CartService,
    DecimalPipe,
    SubmitOrderService,
    PastOrderListService,
    PastORderDetailService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
