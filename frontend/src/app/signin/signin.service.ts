import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { lastValueFrom } from "rxjs";
import { Login } from "../model";


@Injectable() 
export class SigninService {

    constructor (private http: HttpClient) {}

    getValidation(login : Login) {
        const headers = new HttpHeaders()
        .set('Content-Type', 'application/json')
        .set('Accept', 'application/json')

      return lastValueFrom(
        this.http.post<any>('/authenticate', login, { headers })
      )
    }
}