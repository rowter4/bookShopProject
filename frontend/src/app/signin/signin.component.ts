import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Login } from '../model';
import { SigninService } from './signin.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css', '../../../src/signin.css']
})
export class SigninComponent implements OnInit {

  constructor(private router : Router, private fb: FormBuilder, private signInSvc: SigninService) { }

  loginForm !: FormGroup
  

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      userId: this.fb.control('', [Validators.required]),
      password: this.fb.control('', [Validators.required])
    })
  }

  login() {
    console.info(">>>> button clicked  ")

    const login = this.loginForm.value as Login

    this.signInSvc.getValidation(login)
      .then(result => {
        console.info('>>> result: ', result.username)
        sessionStorage.setItem('username', result.username) // from here, the username is able to be obtained throughout the application
        this.router.navigate(['admin-landing'])
      })
      .catch(error => {
        console.error('>>>> sign in error: ', error)
      })
    // 
  }

}
