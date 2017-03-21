package com.apple.google;

import org.joda.time.DateTime;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.google.maps.model.TrafficModel;
import com.google.maps.model.TravelMode;

public class GoogleAPI {

	public static void main(String[] args) throws Exception {
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyBwQYUa1tlc8abz2SW7LV0zub-d9qd-9Ic");
		GeocodingResult[] results = GeocodingApi.geocode(context, "203, Avinashi Rd").await();
		for (int i = 0; i < results.length; i++) {
			//	System.out.println(results[i].formattedAddress);
		}

		LatLng origin = new LatLng(11.025250, 77.011275);
		LatLng destination = new LatLng(11.025865, 77.017657);

		//LatLng origin = new LatLng(11.025637, 77.017666);
		//LatLng destination = new LatLng(11.024805, 77.017730);

		//LatLng destination = new LatLng(11.025677, 77.017553);
		//LatLng origin = new LatLng(11.024918, 77.017644);

		DirectionsResult result = DirectionsApi.newRequest(context).origin(origin).destination(destination)
				.mode(TravelMode.DRIVING).departureTime(new DateTime()).trafficModel(TrafficModel.PESSIMISTIC).await();
		DirectionsRoute[] routes = result.routes;
		DirectionsRoute routeA = routes[0];

		DirectionsLeg leg = routeA.legs[0];
		System.out.println(leg.distance.inMeters);
		System.out.println(leg.duration.inSeconds);
		System.out.println(leg.durationInTraffic.inSeconds);
	}

}
