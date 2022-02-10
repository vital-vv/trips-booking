package contracts.web.v1.hotels

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method GET()
    urlPath('/v1/hotels/1/relationships/reviews') {
      queryParameters {
        parameter page: $(consumer(regex('\\d+')), producer(0))
        parameter size: $(consumer(anyPositiveInt()), producer(5))
        parameter sortBy: $(consumer(optional(regex('[a-zA-Z]+'))), producer('rating'))
        parameter fields: $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))), producer('title,text,rating'))
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
            [id: 1, type: 'Review', attributes: [title: 'A nice hotel', text: 'This was the best hotel I have ever been to', rating: 5]]
        ],
        errors: null
    ])
  }
}

