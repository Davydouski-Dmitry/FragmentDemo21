package com.davidoyski.fragmentdemo21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment implements ShowMessageInterface {

    private static final String MSG_KEY = "MSG_KEY";

    //статический метод который возвращает экземпляр нашего фрагмента1
    public static Fragment1 newInstance(String message) {
        Fragment1 fragment1 = new Fragment1();

        Bundle arguments = new Bundle();//ячейка для хранения пары ключ-значения
        arguments.putString(MSG_KEY, message);

        fragment1.setArguments(arguments);//во фрагмент ложим наши аргументы

        return fragment1;
    }

    private TextView messageTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);//создаем view фрагмента1

        messageTv = view.findViewById(R.id.tvMessage);

        //получаем наш агрумент
        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString(MSG_KEY);
            showMessage(msg);
        }

        Button activityMessageBtn = view.findViewById(R.id.btnActivity);
        activityMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMessageInterface activity = (ShowMessageInterface) getActivity();
                if (activity != null) {
                    activity.showMessage("Привет от Fragment#1  !");
                }
            }
        });
        return view;
    }

    @Override//показывать сообщения
    public void showMessage(String message) {
        messageTv.setText(message);
    }
}

