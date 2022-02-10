import {Component} from '@angular/core';
import {AuthConfig, NullValidationHandler, OAuthService} from "angular-oauth2-oidc";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8484/auth/realms/trips',
    redirectUri: window.location.origin + "/trips-import",
    clientId: 'trips-spa',
    responseType: 'code'
  }

  constructor(private oauthService: OAuthService) {
    this.configure();
  }

  public login() {
    this.oauthService.initLoginFlow();
  }

  public logoff() {
    this.oauthService.logOut();
  }

  private configure() {
    this.oauthService.configure(this.authConfig);
    this.oauthService.tokenValidationHandler = new NullValidationHandler();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }
}
