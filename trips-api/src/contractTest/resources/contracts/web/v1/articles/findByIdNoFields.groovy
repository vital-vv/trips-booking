package contracts.web.v1.articles

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/articles/1')
    headers {
      header acceptLanguage(), $(consumer(regex('en|ru')), producer('en'))
    }
  }
  response {
    status BAD_REQUEST()
    headers {
      contentType applicationJson()
      header contentLanguage(), $(producer(regex('en|ru')))
    }
    body([
        errors: [
            "Required request parameter 'fields' for method parameter type String is not present"
        ]
    ])
  }
}

