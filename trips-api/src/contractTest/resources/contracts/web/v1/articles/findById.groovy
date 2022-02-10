package contracts.web.v1.articles

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/articles/1') {
      queryParameters {
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))),
            producer('title,text,imageId'))
      }
    }
    headers {
      header acceptLanguage(), $(consumer(regex('en|ru')), producer('en'))
    }
  }
  response {
    status OK()
    headers {
      contentType applicationJson()
      header contentLanguage(), $(producer(regex('en|ru')))
    }
    body([
        data  : [
            id        : 1,
            type      : 'Article',
            attributes: [
                title  : 'Food',
                text   : 'A text about the cuisine in the country which you visit during the trip',
                imageId: 'f0ddbcaa-8c66-4995-9da8-dc59ceca3f26'
            ]
        ],
        errors: null
    ])
  }
}
