package com.example.edmt.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.content.res.Resources
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.edmt.R
import com.example.edmt.databinding.FragmentHomeBinding
import com.example.edmt.ui.Common
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.sothree.slidinguppanel.SlidingUpPanelLayout

class HomeFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var slidingUpPanelLayout: SlidingUpPanelLayout
    private lateinit var txt_welcome:TextView
    private lateinit var autoCompleteTextView:AutoCompleteTextView

    //Location
    private lateinit var locationRequest:LocationRequest
    private lateinit var locationCallback: LocationCallback
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var mapFragment:SupportMapFragment
    //binding
    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!


  /* override fun onResume() {
        super.onResume()
        val classes = resources.getStringArray(R.array.classes)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,classes)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

   */

    override fun onDestroy()
    {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        init()
        initViews(root)

        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    // _binding = FragmentHomeBinding.inflate(inflater, container,false)
        return root
    }

    private fun initViews(root: View?) {

            slidingUpPanelLayout = root!!.findViewById(R.id.sliding_layout) as SlidingUpPanelLayout
            txt_welcome = root!!.findViewById(R.id.txt_welcome) as TextView
        Common.setWelcomeMessage(txt_welcome)

    }

    /* override fun onDestroyView() {
         super.onDestroyView()
         _binding = null
     }

     */

    private fun init() {
        locationRequest = LocationRequest()
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        locationRequest.setFastestInterval(3000)
        locationRequest.interval = 5000
        locationRequest.setSmallestDisplacement(10f)

        locationCallback = object: LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)

                val newPos = LatLng(locationResult!!.lastLocation.latitude,locationResult!!.lastLocation.longitude)
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newPos,18f))
            }
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext())
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback,Looper.myLooper())


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap!!

        //Request permission
        Dexter.withContext(context)
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object:PermissionListener{
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {

                    // Enable Button
                    mMap.isMyLocationEnabled = true
                    mMap.uiSettings.isMyLocationButtonEnabled = true
                    mMap.setOnMyLocationClickListener {
                        if (ActivityCompat.checkSelfPermission(
                                context!!,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                                context!!,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {

                            return@setOnMyLocationClickListener
                          }
                        fusedLocationProviderClient.lastLocation
                            .addOnFailureListener { e ->

                                Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()

                            }.addOnSuccessListener { location ->
                                val userLatLng = LatLng(location.latitude,location.longitude)
                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLatLng,18f))
                            }
                        //Layout
                        val locationButton = ( mapFragment.requireView()!!
                            .findViewById<View>("1".toInt())
                            .parent!! as View).findViewById<View>("2".toInt());
                        val params = locationButton.layoutParams as RelativeLayout.LayoutParams
                        params.addRule(RelativeLayout.ALIGN_TOP,0)
                        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE)
                        params.bottomMargin = 50
                        true
                    }



                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {

                    Toast.makeText(context,"Permission "+p0!!.permissionName+"was denied",Toast.LENGTH_SHORT).show()
                }



            })
            .check()




        try {
            val success = googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(requireContext(),R.raw.uber_maps_style))
            if (!success)
                Log.e("EDMT_ERROR","Style parsing error")
        }catch (e:Resources.NotFoundException)
        {
            Log.e("EDMT_ERROR", e.message.toString())
        }


    }
}