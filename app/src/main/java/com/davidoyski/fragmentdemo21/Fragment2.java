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

public class Fragment2 extends Fragment implements ShowMessageInterface {

    private TextView messageTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        messageTv = view.findViewById(R.id.tvMessage);

        Button activityMessageBtn = view.findViewById(R.id.btnActivity);
        activityMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMessageInterface activity = (ShowMessageInterface) getActivity();
                if (activity != null) {
                    activity.showMessage("Привет от Fragment#2  !");
                }
            }
        });
        return view;
    }

    @Override
    public void showMessage(String message) {
        messageTv.setText(message);
    }

}
