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

/**
 * Created by ShinwooEND on 2017-04-13.
 */

public class UserdataAdaptor extends RecyclerView.Adapter<UserdataAdaptor.BindingHolder> {
    private ObservableArrayList<User> users;
    private Presenter presenter;
    private Context root_context;

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public BindingHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }
    }

    public UserdataAdaptor(Context context, ObservableArrayList<User> users) {
        this.users = users;
        root_context = context;

        presenter = new Presenter(root_context);
        Log.d("Adaptor","UserdataAdaptor");
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int type) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_list, parent, false);
        BindingHolder holder = new BindingHolder(v);

        holder.getBinding().setVariable(BR.presenterb, presenter);

        Log.d("Adaptor","onCreateViewHolder");
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        final User aUser = users.get(position);
        holder.getBinding().setVariable(BR.user, aUser);
        holder.getBinding().executePendingBindings();
        Log.d("Adaptor","onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
