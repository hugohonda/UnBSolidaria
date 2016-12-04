package br.unb.unbsolidaria.organization;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.unb.unbsolidaria.R;

/**
 * Created by criss on 04/12/2016.
 */

public class EditProfile extends Fragment {

    public EditProfile() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_org_edit_profile, container, false);

        return parentView;
    }
}
