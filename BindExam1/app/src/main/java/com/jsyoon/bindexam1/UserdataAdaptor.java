package com.jsyoon.bindexam1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class UserdataAdaptor extends RecyclerView.Adapter<UserdataAdaptor.BindingHolder> {
    private ObservableArrayList<User> users;
    private Presenter presenter;
    private Context root_context;


    public static class BindingHolder extends RecyclerView.ViewHolder {
        ViewDataBinding binding;

        // view를 전달 할때
        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
        //------

        // binding을 전달 할때
        public BindingHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        //public void bind(Object obj) {
        //    binding.setVariable(BR.obj, obj);
        //    binding.executePendingBindings();
        //}
        //------
    }

    public UserdataAdaptor(Context context, ObservableArrayList<User> users) {
        this.users = users;
        root_context = context;

        presenter = new Presenter(root_context);
        Log.d("Adaptor", "UserdataAdaptor");
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {

        Log.d("Adaptor", "onCreateViewHolder");

        /*
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_list, parent, false);
        BindingHolder holder = new BindingHolder(v);

        holder.getBinding().setVariable(BR.presenterb, presenter);

        Log.d("Adaptor", "onCreateViewHolder");
        return holder;
        */

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        // cardview layout
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.card_view_list, parent, false);
        binding.setVariable(BR.presenterb, presenter);

        // normal layout
        //ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.userdata_item, parent, false);

        return new BindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final User aUser = users.get(position);
        /*
        holder.getBinding().setVariable(BR.user, aUser);
        holder.getBinding().executePendingBindings();
        */
        holder.binding.setVariable(BR.user, aUser);

        Log.d("Adaptor", "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
