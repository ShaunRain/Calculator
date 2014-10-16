package com.Rain.mycalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button btn_0;
	Button btn_1;
	Button btn_2;
	Button btn_3;
	Button btn_4;
	Button btn_5;
	Button btn_6;
	Button btn_7;
	Button btn_8;
	Button btn_9;
	
	Button btn_add;
	Button btn_minus;
	Button btn_multiply;
	Button btn_divide;
	
	Button btn_dot;
	Button btn_equal;
	
	Button btn_clear;
	Button btn_delete;
	
	EditText et_input;
	boolean needClear;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_0 = (Button)findViewById(R.id.btn_0);
		btn_1 = (Button)findViewById(R.id.btn_1);
		btn_2= (Button)findViewById(R.id.btn_2);
		btn_3 = (Button)findViewById(R.id.btn_3);
		btn_4 = (Button)findViewById(R.id.btn_4);
		btn_5 = (Button)findViewById(R.id.btn_5);
		btn_6 = (Button)findViewById(R.id.btn_6);
		btn_7 = (Button)findViewById(R.id.btn_7);
		btn_8 = (Button)findViewById(R.id.btn_8);
		btn_9 = (Button)findViewById(R.id.btn_9);
		btn_add = (Button)findViewById(R.id.btn_add);
		btn_minus = (Button)findViewById(R.id.btn_minus);
		btn_multiply = (Button)findViewById(R.id.btn_multiply);
		btn_divide = (Button)findViewById(R.id.btn_divide);
		btn_dot = (Button)findViewById(R.id.btn_dot);
		btn_equal = (Button)findViewById(R.id.btn_equal);
		
		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_delete = (Button) findViewById(R.id.btn_delete);
		et_input = (EditText) findViewById(R.id.et_input);
		
		
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_dot.setOnClickListener(this);
		
		btn_add.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		
		btn_clear.setOnClickListener(this);
		btn_delete.setOnClickListener(this);
		btn_equal.setOnClickListener(this);
	}


	public void onClick(View v) {
		String str = et_input.getText().toString();
		switch(v.getId()) {
			case R.id.btn_0:
			case R.id.btn_1:
			case R.id.btn_2:
			case R.id.btn_3:
			case R.id.btn_4:
			case R.id.btn_5:
			case R.id.btn_6:
			case R.id.btn_7:
			case R.id.btn_8:
			case R.id.btn_9:
			case R.id.btn_dot:
				if(needClear) {
					str = "";
					et_input.setText("");
				}
				et_input.setText(str + ((Button)v).getText() );
				break;
			case R.id.btn_add:
			case R.id.btn_minus:
			case R.id.btn_multiply:
			case R.id.btn_divide:
				if(needClear) {
					et_input.setText("");
				}
				et_input.setText(str +" "+((Button)v).getText()+" ");
				break;
			case R.id.btn_equal:
				if(str != null && !str.equals("")){
					if(str.equals("+")||str.equals("-")||str.equals("¡Á")||str.equals("¡Â")){
					Toast.makeText(this, "²»ÒªÂÒµã", Toast.LENGTH_SHORT).show();
					et_input.setText("");
					}else
						getResult();
				}else
					et_input.setText("");
				break;
			case R.id.btn_delete:
				if(str != null && !str.equals("")) {
					et_input.setText(str.substring(0,str.length()-1));
				}
				break;
			case R.id.btn_clear:
				et_input.setText("");
				break;
		}
		
	}


	private void getResult() {
		//needClear = true;
		String exp = et_input.getText().toString();
		double r = 0;
		int space = exp.indexOf(' ');
		String num1 = exp.substring(0,space);
		String op = exp.substring(space+1,space+2);
		String num2 = exp.substring(space+3);
		double arg1 = Double.parseDouble(num1);
		double arg2 = Double.parseDouble(num2);
		if(op.equals("+")){
			r = arg1 +arg2;
		}else if(op.equals("-")){
			r = arg1 -arg2;
		}else if(op.equals("¡Á")){
			r = arg1*arg2;
		}else if(op.equals("¡Â")){
			if(arg2==0){
				r = 0;
			}else{
				r = arg1/arg2;
			}
		}
		if(r == (int)r){
			int result = (int)r;
			et_input.setText(result+"");
		}else{
			et_input.setText(r+"");
		}
	}


}
