package contracts.web.v1.countries

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/countries/1/relationships/caterings') {
      queryParameters {
        parameter page: $(consumer(regex('\\d+')), producer(0))
        parameter size: $(consumer(anyPositiveInt()), producer(5))
        parameter sortBy: $(consumer(optional(regex('[a-zA-Z]+'))), producer('name'))
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
            size   : 2,
            count  : 2,
            hasMore: false
        ],
        data  : [
            [id: 1, type: 'Caterings', attributes: [name: 'Sakura', imageId: '2d0bb2ef-c24d-42c7-a686-e43c2441f85b']],
            [id: 2, type: 'Caterings', attributes: [name: 'Kimonichi', imageId: '97d0d468-63e2-4d10-ad8c-6f6b47074bd8']]
        ],
        errors: null
    ])
  }
}
