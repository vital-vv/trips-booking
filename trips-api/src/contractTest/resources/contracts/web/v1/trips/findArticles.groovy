package contracts.web.v1.trips

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/trips/1/relationships/articles') {
      queryParameters {
        parameter page: $(consumer(regex('\\d+')), producer(0))
        parameter size: $(consumer(anyPositiveInt()), producer(5))
        parameter sortBy: $(consumer(optional(regex('[a-zA-Z]+'))), producer('title'))
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))), producer('title,imageId'))
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
            size   : 1,
            count  : 1,
            hasMore: false
        ],
        data  : [
            [id: 4, type: 'Article', attributes: [title: 'Food', imageId: 'f0ddbcaa-8c66-4995-9da8-dc59ceca3f26']]
        ],
        errors: null
    ])
  }
}
