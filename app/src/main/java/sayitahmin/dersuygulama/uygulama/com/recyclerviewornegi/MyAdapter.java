package sayitahmin.dersuygulama.uygulama.com.recyclerviewornegi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.cardNesnesiTut>{
    private Context mContext; //context andoride ulaştık
    private List<String> mList; //listemiz için

    public MyAdapter(Context mContext, List<String> mList) { //veri alışverişi için constracor tanımladık
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public cardNesnesiTut onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { //cardviewi baglıyoruz
        View itemView=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewtasarim,viewGroup,false);


        return new cardNesnesiTut(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final cardNesnesiTut holder, final int i) { //ilk başta bütün ulkleri gösterir sonra ulkeleri tutar
        final String ulke=mList.get(i); //ulkeleri sıra sıra atıyor
        holder.ulkeText.setText(ulke);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,ulke,Toast.LENGTH_LONG);
            }
        });


        holder.menuGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(mContext,holder.menuGoster);
                MenuInflater menuInflater=popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.menuSil:
                                mList.remove(i);
                                notifyDataSetChanged();
                                return true;
                            case R.id.menuGuncelle:
                                Toast.makeText(mContext,ulke+" Güncelle",Toast.LENGTH_SHORT).show();

                                return true;
                             default:
                        }
                        return false;

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class cardNesnesiTut extends RecyclerView.ViewHolder{ //cardview ve adapteri birbirine baglıyoruz
        private CardView cardView;
        private TextView ulkeText;
        private ImageView menuGoster;

        public cardNesnesiTut(View view) {
            super(view);
            cardView=view.findViewById(R.id.cardView);
            menuGoster=view.findViewById(R.id.menuGoster);
            ulkeText=view.findViewById(R.id.ulkeText);
        }





    }

}
