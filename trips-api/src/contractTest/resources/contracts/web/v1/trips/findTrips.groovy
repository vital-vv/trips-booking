package contracts.web.v1.trips

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/trips') {
      queryParameters {
        parameter page: $(consumer(regex('\\d+')), producer(0))
        parameter size: $(consumer(anyPositiveInt()), producer(5))
        parameter sortBy: $(consumer(optional(regex('[a-zA-Z]+'))), producer('rating'))
        parameter type: $(consumer(regex('(ADVENTURE|RELAXATION|SHOPPING)')), producer('SHOPPING'))
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))), producer('name,imageId'))
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
        meta  : [
            page   : 1,
            size   : 3,
            count  : 3,
            hasMore: false
        ],
        data  : [
            [id: 1, type: 'Trip', attributes: [name: 'Trip to Japan', imageId: '23b2d357-bf20-4f54-b4a7-a81c3425e0d9']],
            [id: 2, type: 'Trip', attributes: [name: 'Hawaii', imageId: 'b8e674ff-6120-46c6-b035-4fe02d5f3aef']],
            [id: 3, type: 'Trip', attributes: [name: 'San Jose', imageId: '9a935272-a690-4b9d-883a-d41627e40204']]
        ],
        errors: null
    ])
  }
}
