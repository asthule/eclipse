import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { AuthorizeUser } from "./model/authorizeUser";


@Injectable({
    providedIn: 'root'
})
export class AuthorizationService {

    readonly rootUrl = 'http://localhost:8084/user/'

    constructor(private http: HttpClient) {}

    getRequestData(){
        return this.http.get<AuthorizeUser[]>(this.rootUrl + '/unauthorized/all');
    }

    authorizeAccount(username: string){
        return this.http.get(this.rootUrl + username + '/authorize');
    }

    rejectRequest(username: any){
        return this.http.get(this.rootUrl + username + '/authorize/cancel');
    }
}