package com.example.demo.tripsapi.test.domain

import com.example.demo.tripbookingapi.domain.Country
import com.example.demo.tripbookingapi.domain.Trip
import com.example.demo.tripbookingapi.domain.TripTranslation
import com.example.demo.tripbookingapi.domain.enumeration.Language

final class Trips {

  static Trip _1() {
    def trip = new Trip(
        id: 1L,
        rating: 4.8F,
        country: new Country(id: 1L)
    )
    trip.setTripTranslations([
        Language.EN: new TripTranslation(
            name: 'Trip to Japan',
            description: 'The journey of your life',
            specification: 'A detailed description of the trip to Japan',
            cuisine: 'A short description of the japanese cuisine',
            trip: trip)
    ])
    trip
  }
}
