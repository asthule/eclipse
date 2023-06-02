import { HttpClient, HttpResponse } from "@angular/common/http";
import { Injectable, } from "@angular/core";
import { JwtHelperService} from '@auth0/angular-jwt/';
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { CustomerApiResponse } from "../models/api-response";
import { SignUpUser } from "../models/signup-user.model";
import { User } from "../models/user.model";

@Injectable({ providedIn: 'root'})
export class AuthService {
    public hostUrl = environment.apiUrl;
   // @ts-ignore
    private token: string;
     // @ts-ignore
    private loggedInUsername: string;
    private jwtHelper = new JwtHelperService();
    currentUser: any;
    register: any;

    constructor(private http: HttpClient){}

    public login(loginData: any): Observable<HttpResponse<User>> {
        return this.http.post<User>(`${this.hostUrl}/login`, loginData, {
            observe: 'response',

        });
    }

    public logout(): void{
        this.token;
        this.loggedInUsername;
        localStorage.removeItem('user');
        localStorage.removeItem('token');
    }

    public saveToken(token: string): void {
        this.token = token;
        localStorage.setItem('token', token);
    }

    public loadToken(): void {
        this.token

       
    }

    public getToken(): string {
        return this.token;
    }

    public isUserLoggedIn(): boolean {
        this.loadToken();
        if (this.token != null && this.token !==''){
            if (this.jwtHelper.decodeToken(this.token).sub != null || ''){
                if (!this.jwtHelper.isTokenExpired(this.token)){
                    this.loggedInUsername = this.jwtHelper.decodeToken(this.token).sub;
                    return true;
                }

            }
            console.log('user is not verified');
            return false;
            
        }else {
            this.logout();
            return false;
        }
    }

}


