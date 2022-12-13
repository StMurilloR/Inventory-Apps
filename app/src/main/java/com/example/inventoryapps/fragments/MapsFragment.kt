package com.example.inventoryapps.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import com.example.inventoryapps.R
import com.example.inventoryapps.databinding.FragmentLoggingBinding
import com.example.inventoryapps.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private lateinit var map: GoogleMap



    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_maps, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        val callback = OnMapReadyCallback { googleMap ->
            /**
             * Manipulates the map once available.
             * This callback is triggered when the map is ready to be used.
             * This is where we can add markers or lines, add listeners or move the camera.
             * In this case, we just add a marker near Sydney, Australia.
             * If Google Play services is not installed on the device, the user will be prompted to
             * install it inside the SupportMapFragment. This method will only be triggered once the
             * user has installed Google Play services and returned to the app.
             */

            val sydney = LatLng(4.6418566861470225, -74.07666320845705)
            googleMap.addMarker(MarkerOptions().position(sydney).title("Bodega Galleria"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f))
        }
        mapFragment?.getMapAsync(callback)
    }


    override fun onMapReady(p0: GoogleMap) {
        val sydney = LatLng(4.6418566861470225, -74.07666320845705)
        p0.addMarker(MarkerOptions().position(sydney).title("Bodega Galleria"))
        p0.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        p0.isMyLocationEnabled = true
        if (ActivityCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        fusedLocationProviderClient.lastLocation.addOnSuccessListener { location ->
            lastLocation = location
            val currentLatLong = LatLng(location.latitude, location.longitude)
            p0.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 13f))
        }
    }

}