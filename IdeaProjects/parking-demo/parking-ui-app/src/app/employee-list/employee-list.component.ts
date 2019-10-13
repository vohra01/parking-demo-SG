import { Component, OnInit, Input } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit{

  @Input() employees: Employee[];

  constructor(private httpClient: HttpClient){}

  ngOnInit(){
    console.log(this.employees);
  }


 /* deleteEmployee(id:Number){
    console.log("HIHIHI");
    this.deleteEmployee1(id).subscribe(response=>{
      console.log(response);
    });
  }


  deleteEmployee1(id:Number):Observable<any>{
    return this.httpClient.get('api/employeeDelete?id='+id);//.pipe(map(res=>res.json()));
  }*/

  deleteEmployee(id:Number):Observable<any>{
    console.log("HIHIHI");
    //return this.httpClient.delete('api/employee?id='+2);
    return this.httpClient.delete<Employee>("api/employee" + "/"+ 2);

  }

  public registerEmployee(employee:Employee): Observable<Page> {
    console.log("fnjnjkb")
    const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

    return this.httpClient.post<Page>('/api/employee',JSON.stringify(employee),{headers:headers});
  }

}
