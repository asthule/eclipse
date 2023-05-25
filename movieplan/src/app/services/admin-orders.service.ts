import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdminOrders } from '../models/admin-orders.model';
import { UserOrder } from '../models/user-order.model';

@Injectable({ providedIn: 'root'})

export class AdminOrdersServices {
    private hostUrl = environment.apiUrl;

    constructor(private http: HttpClient){}

    public getOrdersForAdmin(): Observable<AdminOrders[]>{
        return this.http.get<AdminOrders[]>(`${this.hostUrl}` + '/admin/orders') 
    }

}


