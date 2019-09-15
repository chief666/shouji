package com.example.helloworld;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MessageFragment extends Fragment {
    private static MessageFragment messagef;

    public static Fragment getMessageFragment(){
        if (messagef == null){
            messagef = new MessageFragment();
        }
        return messagef;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message,container,false);
        return view;
    }
}
