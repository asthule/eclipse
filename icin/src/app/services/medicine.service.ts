import { Medicine } from "../models/icin.model";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { CustomerHttpResponse } from "../models/http-response";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class MedicineServices {
    private hostUrl = environment.apiUrl;

    constructor(private http: HttpClient){}

    medicineForm: FormGroup = new FormGroup({
        id: new FormControl(0),
        name: new FormControl('', Validators.required),
        price: new FormControl(null, Validators.required),
        quantityAvailable: new FormControl(null, Validators.required),
        imageUrl: new FormControl('', Validators.required),
    });

    initializeFormGroup(){
        this.medicineForm.setValue({
            id:0,
            name: '',
            price: null,
            quantityAvailable: null,
            imageUrl: '',
        
        });

    }

    populatedEditMedicineForm(medicine: Medicine){
        this.medicineForm.setValue({
            id: medicine.id,
            name: medicine.name,
            price: medicine.price,
            quantityAvailable: medicine.quantityAvailable,
            imageUrl: medicine.imageUrl,
        });
    }

    public getMedicinesForUser(): Observable<Medicine[]>{
        return this.http.get<Medicine[]>(`${this.hostUrl}` + '/medicines');

    }

    public getMedicinesForAdmin(): Observable<Medicine[]>{
        return this.http.get<Medicine[]>(`${this.hostUrl}` + '/admin/medicines');

    }

    public addMedicine(newMedicine: Medicine): Observable<Medicine>{
        console.log(newMedicine);
        return this.http.post<Medicine>(
            `${this.hostUrl}` + '/admin/medicines/addMedicine',
            newMedicine
        );

    }

    public updateMedicine(id: number, updateMedicine: Medicine): Observable<Medicine>{
        console.log(id);
        return this.http.put<Medicine>(
            `${this.hostUrl}/admin/medicines/editMedicine/${id}`,
            updateMedicine
        );
    }

    public deleteMedicine(id: number): Observable<CustomerHttpResponse>{
        console.log(id);
        return this.http.delete<CustomerHttpResponse>(
            `${this.hostUrl}/admin/medicines/deleteMedicine/${id}`
        );
    }


}