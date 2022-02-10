package contracts.web.v1.trips

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/trips/1') {
      queryParameters {
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))),
            producer('name,imageId,shortDescription,fullDescription,cuisine,rating,country'))
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
            type      : 'Trip',
            attributes: [
                name            : 'Trip to Japan',
                imageId         : '23b2d357-bf20-4f54-b4a7-a81c3425e0d9',
                shortDescription: 'The journey of your life',
                fullDescription : 'A detailed description of the trip to Japan',
                cuisine         : 'A short description of the japanese cuisine',
                rating          : 4.8,
                country         : 1
            ]
        ],
        errors: null
    ])
  }
}

