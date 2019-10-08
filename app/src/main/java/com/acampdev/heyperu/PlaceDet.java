package com.acampdev.heyperu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class PlaceDet extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView name_det,ubigeo_det,description_det;
    ImageView img_det;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_det);
        getSupportActionBar();
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapsPlaceID);
        assert mapFragment != null;
        mapFragment.getMapAsync(this);
        // recibir data
        String name= Objects.requireNonNull(getIntent().getExtras()).getString("name");
        String ubigeo= getIntent().getExtras().getString("ubigeo");
        String img=getIntent().getExtras().getString("img");
        String description= getIntent().getExtras().getString("description");

        // init views
        collapsingToolbarLayout= findViewById(R.id.colToolBarLayoutID);
        collapsingToolbarLayout.setTitleEnabled(true);

        name_det=findViewById(R.id.txtTitleID);
        ubigeo_det=findViewById(R.id.txtubigeoID);
        description_det=findViewById(R.id.txtDescriptionID);
        img_det=findViewById(R.id.imgPlaceDetID);

        name_det.setText(name);
        ubigeo_det.setText(ubigeo);
        description_det.setText(description);
        Picasso.get().load(img).into(img_det);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //LatLng place = new LatLng(-8.07912161787263, -79.12103927617704);
        LatLng place = new LatLng(-8.109685023968837, -79.07433744562267);
        LatLng place2= new LatLng(-8.07912161787263,-79.12103927617704);
        LatLng place3= new LatLng(-8.110448855647121,-79.0264265768053);
        mMap.addMarker(new MarkerOptions().position(place).title("Chan Chan"));
        mMap.addMarker(new MarkerOptions().position(place2).title("Huanchaco"));
        mMap.addMarker(new MarkerOptions().position(place3).title("Casa de la Emancipación"));
        CameraPosition cameraPosition=CameraPosition.builder().target(place).zoom(12).bearing(0).tilt(45).build();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
