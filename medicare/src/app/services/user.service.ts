import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { SignUpUser } from "../models/signup-user.model";
import { User } from "../models/user.model";

@Injectable({ providedIn: 'root'})
export class UserServices {
    private hostUrl = environment.apiUrl;

    constructor(){}

    public createUser(
        username: string,
        emailId: string,
        password: string,
        mobileNumber: string,

    ): SignUpUser {
        let user = new SignUpUser();
        user.username = username;
        user.emailId = emailId;
        user.password = password;
        user.mobileNumber = mobileNumber;
        user.role = 'role_user';
        return user;
    }

    public addUserToLocalCache(user: User): void {
        localStorage.setItem('user', JSON.stringify(user));

    }

    public getUserFromLocalCache(): User[] {
        if (localStorage.getItem('users')){
            //@ts-ignore
            return JSON.parse(localStorage.getItem('user'));
        }
       // @ts-ignore
        return null;
    }
}