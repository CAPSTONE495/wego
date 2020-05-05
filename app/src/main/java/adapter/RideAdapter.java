package adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import com.example.wego.DummyData;
import com.example.wego.R;
import com.example.wego.ui.RideInfo.ProfileFragment;
import com.example.wego.ui.RideInfo.RideDetails;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import entity.Ride;
import wegoconstant.WegoConstatns;


public class RideAdapter extends RecyclerView.Adapter<RideAdapter.ViewHolder> {

    List<Ride> rideList;
    Context context;
    RecyclerView recyclerView;

    public RideAdapter(List<Ride> rideList, RecyclerView recyclerView)
    {
        this.rideList = rideList;
        this.recyclerView = recyclerView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
    {
        CircleImageView profile;
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
            this.profile = (CircleImageView) itemView.findViewById(R.id.profile);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ride_view,parent,false);
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

        if(ride.getStatus().equals(WegoConstatns.rideStatus.PENDING)){
            holder.btnRequest.setText(WegoConstatns.pending);
            holder.btnRequest.setTextColor(Color.WHITE);
            holder.btnRequest.setBackgroundColor(Color.GRAY);
            holder.btnRequest.setEnabled(false);
        }else{
            holder.btnRequest.setText("Accepted");
            holder.btnRequest.setTextColor(Color.WHITE);
            holder.btnRequest.setBackgroundColor(Color.BLUE);
            holder.btnRequest.setEnabled(false);
        }
        holder.profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new ProfileFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, myFragment).addToBackStack("blah").commit();
            }
        });
        //holder.btnCancle.setVisibility(View.INVISIBLE);
        holder.btnRequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    // Call API to move request button to passenger tab
                System.out.println("Click Request");
                rideList.get(position).setStatus(WegoConstatns.rideStatus.PENDING);
                DummyData.myRideList.add(rideList.get(position));
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
            public void onClick(View v){
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment rideDetailsFragment = new RideDetails();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, rideDetailsFragment).addToBackStack("blah").commit();
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