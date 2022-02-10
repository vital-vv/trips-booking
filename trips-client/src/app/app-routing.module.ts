import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {TripsImportComponent} from "./components/trips-import/trips-import.component";

const routes: Routes = [
  {path: "trips-import", component: TripsImportComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
