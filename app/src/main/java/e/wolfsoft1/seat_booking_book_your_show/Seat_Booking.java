package e.wolfsoft1.seat_booking_book_your_show;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Seat_Booking extends AppCompatActivity implements View.OnClickListener {
    Spinner sp_car_name1,sp_car_name2,sp_car_name3,sp_car_name4;


    ViewGroup layout;

    String seats ="__A_AAAA_A__/"
            + "_AA_AAUU_AA_/"
            + "AAA_AAUU_AAA/"
            + "UUA_UAAU_AUU/"
            + "UUA_UUAA_AAA/"
            + "____AAAA____/"
            + "AAA_AAUU_AAA/"
            + "UUA_UAAU_AUU/"
            + "UUA_UUAA_AAA/"

            + "AAA_AAUU_AAA/"

            + "UUA_UUAA_AAA/";

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 40;
    int seatGaping = 10;

    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    String selectedIds = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__booking);

        sp_car_name1 = findViewById(R.id.sp_car_name1);
        //sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);

        List<String> list = new ArrayList<String>();
        list.add("Ant Man and The Wasp");
        list.add("Jurassic World");
        list.add("Oceans 8");
        list.add("The Equalizer 2");
        list.add("Mamma Mia");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(Seat_Booking.this, R.layout.spinner_item1, R.id.spinner_text, list);
        sp_car_name1.setAdapter(dataAdapter);

        sp_car_name2 = findViewById(R.id.sp_car_name2);
        //sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);

        List<String> list1 = new ArrayList<String>();
        list1.add("FRIDAY, 12");
        list1.add("SATURDAY, 12");
        list1.add("SUNDAY, 12");
        list1.add("MONDAY, 12");
        list1.add("FRIDAY, 12");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(Seat_Booking.this, R.layout.spinner_item_time, R.id.spinner_text_time, list1);
        sp_car_name2.setAdapter(dataAdapter1);

        sp_car_name3 = findViewById(R.id.sp_car_name3);
        //sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);

        List<String> list2 = new ArrayList<String>();
        list2.add("09:30 AM");
        list2.add("10:30 AM");
        list2.add("11:30 AM");
        list2.add("12:30 AM");
        list2.add("01:30 AM");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(Seat_Booking.this, R.layout.spinner_item_day, R.id.spinner_text_time, list2);
        sp_car_name3.setAdapter(dataAdapter2);



        sp_car_name4 = findViewById(R.id.sp_car_name4);
        //sp_car_model = (Spinner)view.findViewById(R.id.sp_car_model);

        List<String> list3 = new ArrayList<String>();
        list3.add("Sathyam Cinemas: Royapettah");
        list3.add("Escape Cinemas");
        list3.add("Cineplex Movies");
        list3.add("Escape Cinemas");
        list3.add("Cineplex Movies");


        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(Seat_Booking.this, R.layout.spinner_item_theater, R.id.spinner_text1, list3);
        sp_car_name4.setAdapter(dataAdapter3);



            layout = findViewById(R.id.layoutSeat);

            seats = "/" + seats;

            LinearLayout layoutSeat = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutSeat.setOrientation(LinearLayout.VERTICAL);
            layoutSeat.setLayoutParams(params);
            layoutSeat.setPadding(10 * seatGaping, 1 * seatGaping, 10 * seatGaping, 10 * seatGaping);
            layout.addView(layoutSeat);

            LinearLayout layout = null;

            int count = 0;

            for (int index = 0; index < seats.length(); index++) {
                if (seats.charAt(index) == '/') {
                    layout = new LinearLayout(this);
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                    layoutSeat.addView(layout);
                } else if (seats.charAt(index) == 'U') {
                    count++;
                    TextView view = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                    view.setLayoutParams(layoutParams);
                    view.setPadding(0, 0, 0, 2 * seatGaping);
                    view.setId(count);
                    view.setGravity(Gravity.CENTER);
                    view.setBackgroundResource(R.drawable.black);
                    view.setTextColor(Color.WHITE);
                    view.setTag(STATUS_BOOKED);
                    view.setText(count + "");
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                    layout.addView(view);
                    seatViewList.add(view);
                    view.setOnClickListener((View.OnClickListener) this);
                } else if (seats.charAt(index) == 'A') {
                    count++;
                    TextView view = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                    view.setLayoutParams(layoutParams);
                    view.setPadding(0, 0, 0, 2 * seatGaping);
                    view.setId(count);
                    view.setGravity(Gravity.CENTER);
                    view.setBackgroundResource(R.drawable.gray);
                    view.setText(count + "");
                    view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                    view.setTextColor(Color.BLACK);
                    view.setTag(STATUS_AVAILABLE);
                    layout.addView(view);
                    seatViewList.add(view);
                    view.setOnClickListener((View.OnClickListener) this);

                } else if (seats.charAt(index) == '_') {
                    TextView view = new TextView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                    layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                    view.setLayoutParams(layoutParams);
                    view.setBackgroundColor(Color.TRANSPARENT);
                    view.setText("");
                    layout.addView(view);
                }
            }
        }

        @Override
        public void onClick(View view) {
            if ((int) view.getTag() == STATUS_AVAILABLE) {
                if (selectedIds.contains(view.getId() + ",")) {
                    selectedIds = selectedIds.replace(+view.getId() + ",", "");
                    view.setBackgroundResource(R.drawable.gray);
                }
                else {
                    selectedIds = selectedIds + view.getId() + ",";
                    view.setBackgroundResource(R.drawable.smallblue);
                }
            } else if ((int) view.getTag() == STATUS_BOOKED) {
                Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
            }
        }


    }



