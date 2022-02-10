package contracts.web.v1.hotels

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method POST()
    urlPath('/v1/hotels/find')
    headers {
      contentType applicationJson()
      header acceptLanguage(), $(consumer(regex('en|ru')), producer('en'))
    }
    body([
        criteria: [discounts: [specified: true]],
        page    : $(consumer(regex('\\d+')), producer(0)),
        size    : $(consumer(anyPositiveInt()), producer(5)),
        sortBy  : $(consumer(optional(regex('[a-zA-Z]+'))), producer('rating')),
        fields  : $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))), producer('name,imageId'))
    ])
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
            [id: 1, type: 'Hotel', attributes: [name: 'Plaza', imageId: '9ea2fc94-51cc-4631-bb12-594a80258640']],
            [id: 2, type: 'Hotel', attributes: [name: 'Resort', imageId: '86bb690f-a59f-4636-9eb4-d552385e5e5e']],
            [id: 3, type: 'Hotel', attributes: [name: 'Paradiso', imageId: '719fc5a8-aa69-40ee-a1bb-6ba9c4cb78aa']]
        ],
        errors: null
    ])
  }
}
