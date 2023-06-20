import { Component, OnInit } from '@angular/core';
import { EnableService } from '../enable.service';
import { DisableService } from '../disable.service';
import { UsersService } from '../users.service';
import { FeaturesService } from '../features.service';
import { UserData } from '../model/userData';


@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {

  roles = [
    {name: "Deposit Access", value: 1},
    {name: "Deposit + Withdraw Access", value: 2},
    { name: "Deposit + Withdraw + Transfer Access", value: 3}
  ]

  users: any[]
  featuresService: any;

  constructor(public enableService: EnableService, public disableService: DisableService, private service: UsersService){

  }
  selectedValue: number;

  ngOnInit() {
    this.service.getAllUsers().subscribe(res=> {
      console.log(res)
      res.forEach(element => {

        console.log(element.featureStatus)
        if(element.featureStatus == 1){
          element.featureStatus = this.roles[1].name

        }
        if(element.featureStatus == 2){
          element.featureStatus = this.roles[2].name

        }

        if(element.featureStatus == 3){
          element.featureStatus = this.roles[3].name

        }


      });
      this.users = res
    });
      
  }



  filterSelected(selectedValue: any){
    this.selectedValue = selectedValue
    console.log('selected value=' +selectedValue);
  }

  enableLoginService(username: any){
    console.log(username)
    this.enableService.enableLoginService(username).subscribe(res => this.ngOnInit());

  }

  disableLoginService(username: any){
    this.disableService.disableLoginService(username).subscribe(res => this.ngOnInit());


  }

  setOption(username: any){
    
    this.featuresService.setFeatures(username, this.selectedValue).subscribe((res: any) => this.ngOnInit());
    
  }

}
