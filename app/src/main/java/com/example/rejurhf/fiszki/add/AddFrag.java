package com.example.rejurhf.fiszki.add;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rejurhf.fiszki.R;
import static com.example.rejurhf.fiszki.io.FileHand.addNewFile;
import static com.example.rejurhf.fiszki.io.FileHand.getArrayOfDirs;

/**
 * Created by Rejurhf on 06.12.2017.
 */

public class AddFrag extends Fragment{
    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        final View myView = inflater.inflate(R.layout.frag_add,
                container, false);

        editText = (EditText) myView.findViewById(R.id.editTextAdd);
        listView = (ListView) myView.findViewById(R.id.listViewAdd);
        setListView();

        return myView;
    }

    private void setListView(){
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.add_file, getArrayOfDirs());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AddActivity.class);
                intent.putExtra("name", getArrayOfDirs().get(position));
                startActivity(intent);
            }
        });
    }

    public void addNewSet(){
        String fileName = editText.getText().toString();
        if(!fileName.equals("")){
            editText.setText("");
            addNewFile(fileName);
            setListView();
        }else {
            Toast.makeText(getActivity(), "Wprowadź nazwę tworzonej talii",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
