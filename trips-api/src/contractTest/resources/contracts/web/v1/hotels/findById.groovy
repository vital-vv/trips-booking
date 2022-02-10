package contracts.web.v1.hotels

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/hotels/1') {
      queryParameters {
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))),
            producer('name,imageId,rating,description'))
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
            id        : 4,
            type      : 'Hotel',
            attributes: [
                name       : 'Transylvania hotel',
                imageId    : '6a067527-8d4c-4e9d-a3a3-58efa195473a',
                description: 'A hotel located in Rome',
                rating     : 4.7
            ]
        ],
        errors: null
    ])
  }
}

