package com.coronasoda.coronasodaempresa.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coronasoda.coronasodaempresa.MainActivity;
import com.coronasoda.coronasodaempresa.R;
import com.coronasoda.coronasodaempresa.adaptadores.Adaptadorrecibepedidos;
import com.coronasoda.coronasodaempresa.modelos.PedidoRealmFirebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
     private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        final RecyclerView pedidos=(RecyclerView)root.findViewById(R.id.recycler);
pedidos.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();


firebaseDatabase.getReference().child("PEDIDOS").addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        ArrayList<PedidoRealmFirebase> pb = new ArrayList<PedidoRealmFirebase>();
        pb.clear();

        for(DataSnapshot snapshot:
        dataSnapshot.getChildren()){
            PedidoRealmFirebase pedidoRealmFirebase=snapshot.getValue(PedidoRealmFirebase.class);
            pb.add(pedidoRealmFirebase);

        }
        Adaptadorrecibepedidos adaptador = new Adaptadorrecibepedidos( pb, (MainActivity) getContext());
        //progressDialog.dismiss();
        pedidos.setAdapter(adaptador);

        adaptador.notifyDataSetChanged();

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});






       /* homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);





            }
        });*/
        return root;
    }

}
