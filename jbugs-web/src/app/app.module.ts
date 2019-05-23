import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {UserTableComponent} from "./user-table/user-table.component";

import {MatButtonModule, MatIconModule, MatTableModule} from "@angular/material";
import { MatPaginatorModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {AddUserComponent} from "./add-user/add-user.component";

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    UserTableComponent,
    AddUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
