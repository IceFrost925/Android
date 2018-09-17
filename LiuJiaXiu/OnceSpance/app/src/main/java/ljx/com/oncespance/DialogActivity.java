package ljx.com.oncespance;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    private Button btnComm,btnMore,btnList,btnRadio,btnChecked,btnProgress2,btnProgress,btnCustomer,btnDateDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btnComm = findViewById(R.id.btn_comm);
        btnComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommDialog();
            }
        });

        btnMore = findViewById(R.id.btn_more);
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonDialog();
            }
        });

        btnList = findViewById(R.id.btn_list);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListDialog();
            }
        });

        btnRadio = findViewById(R.id.btn_radio);
        btnRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioDialog();
            }
        });

        btnChecked = findViewById(R.id.btn_checked);
        btnChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBoxDiadio();
            }
        });

        btnProgress2 = findViewById(R.id.btn_progress2);
        btnProgress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog2();
            }
        });

        btnProgress = findViewById(R.id.btn_progress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog();
            }
        });

        btnCustomer = findViewById(R.id.btn_customer);
        btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog();
            }
        });

        btnDateDialog = findViewById(R.id.btn_date);
        btnDateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateDialog();
            }
        });
    }

    private void CommDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("普通对话框")
                .setMessage("普通对话框的内容")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void ButtonDialog(){
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("普通对话框")
                .setMessage("普通对话框的内容")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("按钮", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,"我就是个按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void ListDialog(){
        final String items[] = {"我是Item1","我是Item2","我是Item3","我是Item4",};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("列表话框")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,items[which],Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }

    private void RadioDialog(){
        final String items[] = {"我是Item1","我是Item2","我是Item3","我是Item4",};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("单选对话框")
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,items[which],Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,items[which],Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void CheckBoxDiadio(){
        final String items[] = {"我是Item1","我是Item2","我是Item3","我是Item4",};
        final boolean checkedItems[] = {true, false, true, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("多选对话框")
                .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i = 0;i<checkedItems.length;i++){
                            if(checkedItems[1]){
                                Toast.makeText(DialogActivity.this,"选择" + i ,Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void ProgressDialog(){
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("读取中对话框");
        dialog.setMessage("内容读取中");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    private void ProgressDialog2(){
        final ProgressDialog dialog2 = new ProgressDialog(this);
        dialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog2.setTitle("进度条对话框");
        dialog2.setMessage("正在加载中");
        dialog2.setMax(100);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            int progress = 0;

            @Override
            public void run() {
                dialog2.setProgress(progress += 5);
                if (progress == 100) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
        dialog2.show();
    }

    private void CustomDialog(){
        final View viewDia= LayoutInflater.from(DialogActivity.this).inflate(R.layout.customer_dialog, null);
        AlertDialog.Builder customerDialog = new AlertDialog.Builder(DialogActivity.this);

        customerDialog.setTitle("自定义对话框");
        customerDialog.setView(viewDia);
        customerDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        customerDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        customerDialog.create();
        customerDialog.show();
    }

    private void DateDialog(){
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(DialogActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(DialogActivity.this,"选择了"+year+"年"+(month+1)+"月"+dayOfMonth+"日",Toast.LENGTH_SHORT).show();
            }
        },year,month,day);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            datePickerDialog.create();
        }
        datePickerDialog.show();

    }
}
