import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { SigninComponent } from './signin/signin.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SigninService } from './signin/signin.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminLandingComponent } from './admin-landing/admin-landing.component';
import { AddNewItemsComponent } from './add-new-items/add-new-items.component';
import { AddNewItemsService } from './add-new-items/add-new-items.service';


const appPath: Routes = [
  { path: '', component: SigninComponent },
  { path: 'welcome', component: WelcomeComponent },
  { path: 'admin-landing', component: AdminLandingComponent },
  { path: 'add-item', component: AddNewItemsComponent },

  // { path: 'dashboard' , component: DashboardComponent },
  { path: '**', redirectTo: '/', pathMatch: 'full' }

]

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    WelcomeComponent,
    DashboardComponent,
    AdminLandingComponent,
    AddNewItemsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appPath, { useHash: true }),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    SigninService,
    AddNewItemsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
