import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  refresh: EventEmitter<any> = new EventEmitter();

  constructor(private httpClient: HttpClient){}

  public loadAllEmployee(): Observable<Page> {
    return this.httpClient.get<Page>('/api/employee')
  }

  public registerEmployee(employee:Employee): Observable<Page> {
    const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

    return this.httpClient.post<Page>('/api/employee',JSON.stringify(employee),{headers:headers});
  }

  public reloadMainList(){
    return this.refresh
  }

  /*deleteEmployee(employee:Employee){
    const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
    return this.httpClient.delete('/api/employeeDelete',{headers:headers});
    //this._employeeService.deleteEmployee(this.employee.id).subscribe(response=>{
      //console.log(response);
    //});
  }*/


  deleteEmployee(id:Number){
      console.log("HIHIHI");
    this.deleteEmployee1(id).subscribe(response=>{
      console.log(response);
    });
  }


  deleteEmployee1(id:Number):Observable<any>{
    return this.httpClient.delete('api/employeeDelete?id='+id);//.pipe(map(res=>res.json()));
  }
}
