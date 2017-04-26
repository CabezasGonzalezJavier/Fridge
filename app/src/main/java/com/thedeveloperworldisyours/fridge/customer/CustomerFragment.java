package com.thedeveloperworldisyours.fridge.customer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.thedeveloperworldisyours.fridge.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class CustomerFragment extends Fragment implements CustomerContract.View {

    @BindView(R.id.customer_fragment_kinder)
    TextView mKinderNumber;

    @BindView(R.id.customer_fragment_grab_edit_text)
    EditText mGrabNumber;

    CustomerContract.Presenter mPresenter;

    public CustomerFragment() {
        // Required empty public constructor
    }

    public static CustomerFragment newInstance() {
        return new CustomerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.customer_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showKinder(int numberKinder) {
        refreshNumberKinderLeft(numberKinder);
    }

    @Override
    public void setPresenter(@NonNull CustomerContract.Presenter presenter) {
        checkNotNull(presenter);
        mPresenter = presenter;
//        refreshNumberKinderLeft(mPresenter.getKindersLeft());
    }

    @OnClick(R.id.customer_fragment_grab_button)
    public void grabKinder(View view) {
        if (!mGrabNumber.getText().toString().isEmpty()) {
            mPresenter.openFridge(Integer.valueOf(mGrabNumber.getText().toString()));
        }
    }
    public void refreshNumberKinderLeft(int numberKinder) {

        mKinderNumber.setText(String.valueOf(numberKinder));
    }
}
