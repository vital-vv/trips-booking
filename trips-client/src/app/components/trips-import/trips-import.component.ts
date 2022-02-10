import {Component, OnInit} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-trips-import',
  templateUrl: './trips-import.component.html',
  styleUrls: ['./trips-import.component.scss']
})
export class TripsImportComponent implements OnInit {

  private tripsUrl: string = 'http://localhost:8080/trips-api/v1/trips';

  trips: Map<String, any> | undefined;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    this.loadTrips();
  }

  private loadTrips(): void {
    this.http
      .get<Map<String, any>>(this.tripsUrl, {params: {page: 1, size: 20, type: 'shopping', fields: 'name'}})
      .subscribe(trips => this.trips = trips);
  }
}
