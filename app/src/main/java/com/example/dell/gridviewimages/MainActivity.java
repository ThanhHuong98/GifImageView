package com.example.dell.gridviewimages;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.GridView;
import android.view.View;
import android.widget.AdapterView;
    public class MainActivity extends AppCompatActivity {

        //GUI control bound to screen1 (holding GidView)
        GridView gridview;
        //GUI controls bound to screen2 (holding single ImageView)
        TextView txtSoloMsg;
        ImageView imgSoloPhoto;
        Button btnSoloBack;
        //in case you want to use-save state values
        Bundle myOriginalMemoryBundle;

        String[] items = {"Photo-1", "Photo-2", "Photo-3", "Photo-4", "Photo-5",
                "Photo-6", "Photo-7", "Photo-8", "Photo-9", "Photo-10", "Photo-11",
                "Photo-12", "Photo-13", "Photo-14", "Photo-15",};
        Integer[] thumbnails={R.drawable.pic01_small,R.drawable.pic02_small,R.drawable.pic03_small,
                R.drawable.pic04_small,R.drawable.pic05_small,R.drawable.pic06_small,
                R.drawable.pic07_small,R.drawable.pic08_small,R.drawable.pic09_small,
                R.drawable.pic11_small,R.drawable.pic11_small,R.drawable.pic12_small,
                R.drawable.pic13_small,R.drawable.pic14_small,R.drawable.pic15_small};
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            myOriginalMemoryBundle = savedInstanceState;
            setContentView(R.layout.activity_main);
            // setup GridView with its custom adapter and listener
            gridview = (GridView) findViewById(R.id.gridview);
            gridview.setAdapter(new MyImageAdapter(this, thumbnails));
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    showBigScreen(position);
                }
            });
        }//onCreate
        private void showBigScreen(int position) {
            // show the selected picture as a single frame in the second layout
            setContentView(R.layout.solo_picture);
            // plumbing – second layout
            txtSoloMsg = (TextView) findViewById(R.id.txtSoloMsg);
            imgSoloPhoto = (ImageView) findViewById(R.id.imgSoloPhoto);
            // set caption-and-large picture
            txtSoloMsg.setText(" Position= " + position + " " + items[position]);
            //Thiết lập hình ảnh đang chọn lên ImageView mới
            imgSoloPhoto.setImageResource( thumbnails[position] );
            // set GO BACK button to return to layout1 (GridView)
            btnSoloBack = (Button) findViewById(R.id.btnSoloBack);
            btnSoloBack.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // redraw the main screen showing the GridView
                  onCreate(myOriginalMemoryBundle);
                }
            });
        }// showBigScreen
    }//Activity
