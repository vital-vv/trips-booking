package contracts.web.v1.countries

import org.springframework.cloud.contract.spec.Contract

Contract.make {
  request {
    method POST()
    urlPath('/v1/countries/find')
    headers {
      contentType applicationJson()
      header acceptLanguage(), $(consumer(regex('en|ru')), producer('en'))
    }
    body([
        criteria: [name: [contains: 'Bel']],
        page    : $(consumer(regex('\\d+')), producer(0)),
        size    : $(consumer(anyPositiveInt()), producer(5)),
        sortBy  : $(consumer(optional(regex('[a-zA-Z]+'))), producer('name')),
        fields  : $(consumer(optional(regex('([a-zA-Z]+[,]?)+'))), producer('name'))
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
            size   : 2,
            count  : 2,
            hasMore: false
        ],
        data  : [
            [id: 1, type: 'Country', attributes: [name: 'Belarus']],
            [id: 2, type: 'Country', attributes: [name: 'Belgium']]
        ],
        errors: null
    ])
  }
}

