import { Component, OnInit } from '@angular/core';
import {AddUserComponent} from "../add-user/add-user.component";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {Router} from "@angular/router";
import {AuthService} from "../services/auth-service/auth.service";
import {PermissionsComponent} from "../permissions/permissions.component";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private dialog: MatDialog,
              private router: Router,
              private authService: AuthService) { }

  private dialogConfig;

  ngOnInit() {
    this.dialogConfig = new MatDialogConfig();
  }

}