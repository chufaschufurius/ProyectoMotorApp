package com.motorapp.proyectodam.proyectomotorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Fragmento principal
 */
public class MainFragment extends Fragment {

    private ListView lista;


//    String[] tasks = {};

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Button nueva= (Button) v.findViewById(R.id.nueva);
        lista = (ListView) v.findViewById(R.id.lista);

//        ArrayList<String> taskList= new ArrayList<String>();
        final ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1);
        final ListView listaTareas=(ListView) v.findViewById(R.id.lista);
        listaTareas.setAdapter(listAdapter);

        // Datos de la lista
        final String[] data = {"tarea1","tarea2"};
//
        final ArrayAdapter adaptador = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item,
                R.id.list_item_textview,
                data
        );

        Spinner spinner = (Spinner) v.findViewById(R.id.spiner_trabajadores);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.trabajadores, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        lista.setAdapter(adaptador);

        nueva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), IntroMatricula.class);
                startActivity(intent);
            }
        });

//        final ParseQuery<ParseObject> query = ParseQuery.getQuery("cars");
//        query.whereEqualTo("owner", "puesto1");
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List objects, ParseException e) {
//                if (e == null) {
//                    int len = objects.size();
//                    for (int i = 0; i < len; i++) {
//                        ParseObject p = (ParseObject) objects.get(i);
//                        String task = p.getList("task");
//                    }
//                } else {
//                    Log.d("cars", "Error: " + e.getMessage());
//                }
//            }
//        });



//        String worker=String.valueOf(spinner.getSelectedItem());
//        Toast.makeText(getContext(), worker, Toast.LENGTH_LONG).show();



        // Asignar acciones
//        lista.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        // Obtención del manejador de fragmentos
//                        FragmentManager fragmentManager = getFragmentManager();
//
//                        switch (position) {
//                            case 0:
//                                new SimpleDialog().show(fragmentManager, "SimpleDialog");
//                                break;
//                            case 1:
//                                new SimpleListDialog().show(fragmentManager, "SimpleListDialog");
//                                break;
//                            case 2:
//                                new ListRadioDialog().show(fragmentManager, "ListRadioDialog");
//                                break;
//                            case 3:
//                                new ListCheckboxDialog().show(fragmentManager, "ListCheckboxDialog");
//                                break;
//                            case 4:
//                                new LoginDialog().show(fragmentManager, "LoginDialog");
//                                break;
//                            case 5:
//                                new DateDialog().show(fragmentManager, "DatePickerFragment");
//                                break;
//                            case 6:
//                                new TimeDialog().show(fragmentManager, "TimePickerFragment");
//                                break;
//                            case 7:
//                                startActivity(new Intent(getActivity(), DetailActivity.class));
//                                break;
//                        }
//                    }
//                }
//        );

        return v;
    }
}
