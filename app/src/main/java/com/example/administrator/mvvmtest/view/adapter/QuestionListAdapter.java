package com.example.administrator.mvvmtest.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.mvvmtest.R;
import com.example.administrator.mvvmtest.databinding.ItemQuestionListBinding;
import com.example.data.BR;
import com.example.data.entity.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */

public class QuestionListAdapter extends RecyclerView.Adapter<QuestionListAdapter.QuestionViewHolder>{

    private LayoutInflater layoutInflater;
    ItemQuestionListBinding questionListItemBinding;
    private List<Question> mData = new ArrayList<>();
    private int lastPosition = -1;

    public QuestionListAdapter(Context context, List<Question> list) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mData.addAll(list);
    }

    public void addDatas(List<Question> list) {
        this.mData.addAll(list);
        notifyItemRangeInserted(mData.size() - list.size(),list.size());
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        questionListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_question_list, parent, false);
        QuestionViewHolder questionViewHolder = new QuestionViewHolder(questionListItemBinding);
        return questionViewHolder;
    }

    @Override
    public void onBindViewHolder(QuestionViewHolder holder, int position) {
        Question question = mData.get(position);
        holder.textContent.setText(question.getContent());
        holder.textFrom.setText("来自  "+question.getAskName()+"的问题");
        holder.textPrice.setText("￥"+question.getPrice());
//        holder.binding.setVariable(com.example.administrator.mvvmtest.BR.question, question);
        setAnimation(holder.binding.getRoot(),position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return this.mData != null ? this.mData.size() : 0;
    }

    static class QuestionViewHolder extends RecyclerView.ViewHolder {
        ItemQuestionListBinding binding;
        TextView textFrom;
        TextView textPrice;
        TextView textContent;
        public QuestionViewHolder(ItemQuestionListBinding questionListItemBinding) {
            super(questionListItemBinding.getRoot());
            binding = questionListItemBinding;
            textFrom = questionListItemBinding.textFrom;
            textPrice = questionListItemBinding.textPrice;
            textContent = questionListItemBinding.textContent;
        }
    }

}
