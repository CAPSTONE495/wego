package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wego.DummyData;
import com.example.wego.R;

import java.util.List;

import entity.Ride;
import wegoconstant.WegoConstatns;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<Ride> rideList;
    Context context;
    RecyclerView recyclerView;

    public HomeAdapter(List<Ride> rideList, RecyclerView recyclerView)
    {
        this.rideList = rideList;
        this.recyclerView = recyclerView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
    {
        TextView driver_name;
        TextView from;
        TextView where;
        TextView when;
        Button btnRequest;
        Button btnCancle;

        public ViewHolder(View itemView)
        {
            super(itemView);
            this.driver_name = (TextView) itemView.findViewById(R.id.driver_name);
            this.from = (TextView)itemView.findViewById(R.id.text_from);
            this.where = (TextView)itemView.findViewById(R.id.text_where);
            this.when = (TextView)itemView.findViewById(R.id.text_when);
            this.btnRequest = (Button) itemView.findViewById(R.id.request_button);
            this.btnCancle = (Button) itemView.findViewById(R.id.cancel_button);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            System.out.println("Bingo");
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_view,parent,false);
        context = parent.getContext();
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Ride ride = rideList.get(position);
        holder.driver_name.setText(ride.getDriver());

        holder.from.setText(ride.getFrom());

        holder.where.setText(ride.getWhere());

        holder.when.setText(ride.getTime());

        holder.btnRequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    // Call API to move request button to passenger tab
                System.out.println("Click Request");
                ride.setStatus(WegoConstatns.rideStatus.PENDING);
                DummyData.myRideList.add(ride);
                DummyData.myDriveList.add(ride);
                updateView(ride, position);
            }
        });
        holder.btnCancle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Call api to move request to driver tab
                System.out.println("Click Cancel");
                DummyData.rideList.remove(ride);
                updateView(ride, position);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                // Open new intent to show ride details
                //Toast.makeText( v.getContext(),"Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rideList.size();
    }

    public void updateView(Ride ride, int position){
        rideList.remove(ride);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
        notifyDataSetChanged();
    }

}