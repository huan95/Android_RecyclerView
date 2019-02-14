package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    //tạo arraylist chứa kiểu dữ liệu
    ArrayList<DataShop> dataShops;
    Context context;

    public ShopAdapter(ArrayList<DataShop> dataShops, Context context) {
        this.dataShops = dataShops;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //tạo layout
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        //tạo view
        View itemView = layoutInflater.inflate(R.layout.activity_item_row, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    //gán dữ liệu vào view
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtName.setText(dataShops.get(i).getName());
        viewHolder.imgPictures.setImageResource(dataShops.get(i).getPictures());

    }

    @Override
    public int getItemCount() {
        return dataShops.size();
    }

    //tạo function xoá
 public void RemoveItem(int position){
        dataShops.remove(position);
        notifyItemRemoved(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //đặt tên
        TextView txtName;
        ImageView imgPictures;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            //ánh xạ
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            imgPictures = (ImageView) itemView.findViewById(R.id.imgPictures);

            //bắt sự kiện
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    RemoveItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Remove " + txtName.getText(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
    }
}
