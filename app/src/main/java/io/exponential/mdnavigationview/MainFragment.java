package io.exponential.mdnavigationview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainFragment extends Fragment {
    private static final String ARG_INPUT_FROM_ACTIVITY = "MainFragment.ARG_INPUT_FROM_ACTIVITY";
    private String inputFromActivity;

    private Callbacks callbacks;

    /**
     * Factory method to create a new instance of MainFragment.
     *
     * @param inputFromActivity Parameter passed in from Activity when creating an instance.
     * @return A new instance of fragment MainFragment.
     */
    public static MainFragment newInstance(String inputFromActivity) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_INPUT_FROM_ACTIVITY, inputFromActivity);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            inputFromActivity = getArguments().getString(ARG_INPUT_FROM_ACTIVITY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callbacks = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface Callbacks {
        public void passDataToActivity(String data);
    }

}
