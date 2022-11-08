package kamya.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class LoginActivity extends  Activity  {
	
	private final Timer _timer = new Timer();

	private boolean login_mode_ = false;
	private String fontName = "";
	private final String typeace = "";
	private boolean forgot_pass_ = false;
	private boolean password_reset = false;
	private final String login = "";
	private final String phone = "";
	private final String code = "";
	private final String codeSent = "";
	private String action = "";
	private double timer = 0;
	private boolean pass_boolean = false;
	private final boolean emailVerified = false;
	private final String user_email = "";
	private HashMap<String, Object> map = new HashMap<>();
	
	private final ArrayList<HashMap<String, Object>> user_list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout bg;
	private LinearLayout linear5;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private LinearLayout background2;
	private LinearLayout bg_;
	private LinearLayout linear7;
	private LinearLayout input_layout;
	private LinearLayout otp_layout;
	private ProgressBar progressbar;
	private LinearLayout action_btn;
	private LinearLayout linear13;
	private RelativeLayout RelativeTop;
	private TextView title;
	private TextView title_desc;
	private LinearLayout linear17;
	private ImageView img;
	private LinearLayout user_name_layout;
	private LinearLayout email_id_layout;
	private LinearLayout phone_layout;
	private LinearLayout linear14;
	private LinearLayout password_layout;
	private TextView forgot_pass;
	private LinearLayout confirm_password_layout;
	private ImageView imageview2;
	private EditText name;
	private ImageView imageview3;
	private EditText email;
	private ImageView imageview4;
	private TextView textview7;
	private EditText phone_no;
	private ImageView imageview9;
	private EditText refer_code;
	private ImageView imageview5;
	private EditText pass;
	private ImageView imageview7;
	private ImageView imageview6;
	private EditText c_pass;
	private ImageView imageview8;
	private EditText otp_text;
	private TextView resend_otp;
	private TextView action_text;
	private TextView bottom_desc;
	private TextView login_txt;
	
	private final Intent in = new Intent();

	private TimerTask otp_timer;
	private AlertDialog.Builder email_dialog;
	private SharedPreferences sh;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;

	private CoordinatorLayout coordinatorLayout;

	private HashMap<String, Object> api_map = new HashMap<>();


	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);

		initializeLogic();



	}
	
	private void initialize(Bundle _savedInstanceState) {

		coordinatorLayout = findViewById(R.id.coordinatorLayout);
		linear1 = findViewById(R.id.linear1);
		bg = findViewById(R.id.bg);
		linear5 = findViewById(R.id.linear5);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		background2 = findViewById(R.id.background2);
		bg_ = findViewById(R.id.bg_);
		linear7 = findViewById(R.id.linear7);
		input_layout = findViewById(R.id.input_layout);
		otp_layout = findViewById(R.id.otp_layout);
		progressbar = findViewById(R.id.progressbar);
		action_btn = findViewById(R.id.action_btn);
		linear13 = findViewById(R.id.linear13);
		RelativeTop = findViewById(R.id.RelativeTop);
		title = findViewById(R.id.title);
		title_desc = findViewById(R.id.title_desc);
		linear17 = findViewById(R.id.linear17);
		img = findViewById(R.id.img);
		user_name_layout = findViewById(R.id.user_name_layout);
		email_id_layout = findViewById(R.id.email_id_layout);
		phone_layout = findViewById(R.id.phone_layout);
		linear14 = findViewById(R.id.linear14);
		password_layout = findViewById(R.id.password_layout);
		forgot_pass = findViewById(R.id.forgot_pass);
		confirm_password_layout = findViewById(R.id.confirm_password_layout);
		imageview2 = findViewById(R.id.imageview2);
		name = findViewById(R.id.name);
		imageview3 = findViewById(R.id.imageview3);
		email = findViewById(R.id.email);
		imageview4 = findViewById(R.id.imageview4);
		textview7 = findViewById(R.id.textview7);
		phone_no = findViewById(R.id.phone_no);
		imageview9 = findViewById(R.id.imageview9);
		refer_code = findViewById(R.id.refer_code);
		imageview5 = findViewById(R.id.imageview5);
		pass = findViewById(R.id.pass);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		c_pass = findViewById(R.id.c_pass);
		imageview8 = findViewById(R.id.imageview8);
		otp_text = findViewById(R.id.otp_text);
		resend_otp = findViewById(R.id.resend_otp);
		action_text = findViewById(R.id.action_text);
		bottom_desc = findViewById(R.id.bottom_desc);
		login_txt = findViewById(R.id.login_txt);
		//fauth = FirebaseAuth.getInstance();
		email_dialog = new AlertDialog.Builder(this);
		sh = getSharedPreferences("sh", Activity.MODE_PRIVATE);
		net = new RequestNetwork(this);









		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {

				if(action.equals("") || action.equals("signup"))
				{
					finishAffinity();

				}else {
					login_txt.performClick();
					//this is for back function
				}

			}
		});
		
		action_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				progressbar.setVisibility(View.VISIBLE);
				_clickAnimation(action_btn);
				_transition_Animation();
				_input_login();
			}
		});

		user_name_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_UI();
				_on_click_cornor(user_name_layout, 2, 30);
			}
		});
		
		email_id_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_UI();
				_on_click_cornor(email_id_layout, 2, 30);
			}
		});
		
		phone_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_UI();
				_on_click_cornor(phone_layout, 2, 30);
			}
		});
		
		password_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_UI();
				_on_click_cornor(password_layout, 2, 30);
			}
		});
		
		forgot_pass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transition_Animation();

				linear13.setVisibility(View.VISIBLE);
				login_mode_ = false;
				login_txt.setText("Login account");


				if (forgot_pass_) {
					forgot_pass_ = false;

					action="login";

					title.setText("Welcome back!");
					title_desc.setText("Login to continue");
					forgot_pass.setText("Forgot Password ?");
					action_text.setText("Login now");
					login_txt.performClick();

					password_layout.setVisibility(View.VISIBLE);
					//linear13.setVisibility(View.VISIBLE);
					email_id_layout.setVisibility(View.VISIBLE);

					phone_layout.setVisibility(View.GONE);
				}
				else {
					forgot_pass_ = true;

					action="forgot_password";

					forgot_pass.setText("Go back to login >>");
					action_text.setText("Get OTP now");
					title.setText("Password recovery");
					title_desc.setText("Enter your phone no here");


					phone_layout.setVisibility(View.VISIBLE); // phone no

					password_layout.setVisibility(View.GONE);   // password
					//linear13.setVisibility(View.GONE);  // bottom switch buttom login + sign up
					email_id_layout.setVisibility(View.GONE);   // email
				}
			}
		});
		
		confirm_password_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_UI();
				_on_click_cornor(confirm_password_layout, 2, 30);
			}
		});
		
		name.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				user_name_layout.performClick();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		email.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();

				email_id_layout.performClick();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		phone_no.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				phone_layout.performClick();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		pass.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				password_layout.performClick();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pass_boolean) {
					_extra_bottom();
					pass_boolean = false;
				}
				else {
					_extra_top();
					pass_boolean = true;
				}
			}
		});
		
		c_pass.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.equals(pass.getText().toString().trim())) {
					c_pass.setTextColor(0xFF43A047);
					c_pass.setTextSize(16);
				}
				else {
					c_pass.setTextColor(0xFFF44336);
					c_pass.setTextSize(14);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (pass_boolean) {
					_extra_top();
					pass_boolean = false;
				}
				else {
					_extra_bottom();
					pass_boolean = true;
				}
			}
		});
		
		otp_text.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		resend_otp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				timer = 60;
				resend_otp.setEnabled(false);
				resend_otp.setAlpha((float)(0.6d));
				if(otp_timer!=null){
					otp_timer.cancel();
				}
				otp_timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								resend_otp.setText("Next OTP Resend on ".concat(String.valueOf((long)(timer - 1))));
								if (timer < 1) {

									resend_otp.setText("Resend OTP");
									resend_otp.setEnabled(true);
									resend_otp.setAlpha((float)(1));
									otp_timer.cancel();
								}

								timer--;
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(otp_timer, 0, 1000);
			}
		});
		
		bottom_desc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		login_txt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_transition_Animation();
				if (login_mode_) {
					login_mode_ = false;
					forgot_pass_ = true;
					forgot_pass.setText("Go back to login >>");

					_login_mode();
				}
				else {
					login_mode_ = true;
					forgot_pass_ = false;
					forgot_pass.setText("Forgot Password ?");

					_signin_mode();
				}
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};


/*		try {
			progressbar.setVisibility(View.GONE);
			if (action.equals("login")) {

			}
			else {
				if (_success) {
					fauth.getCurrentUser().sendEmailVerification() .addOnCompleteListener(new OnCompleteListener<Void>() {
						@Override
						public void onComplete(Task<Void> task) {
							if (task.isSuccessful()) {

								login_txt.performClick();
								sh.edit().putString("u_email", email.getText().toString().trim()).apply();
								sh.edit().putString("u_phone", phone_no.getText().toString().trim()).apply();
								sh.edit().putString("u_name", name.getText().toString().trim()).apply();
								sh.edit().putString("refer_code", refer_code.getText().toString().trim()).apply();
								_Sneek_Message(linear1, "Verification sent..");

								_create_user_data_on_db();

							} else {



								_Sneek_Message(linear1, "Failed to verify..");
							}
						} });
				}
				else {
					_Sneek_Message(linear1, _errorMessage);
				}
			}
		} catch(Exception e) {
			showMessage(e.toString());
		}
		*/

/*		try {
			progressbar.setVisibility(View.GONE);
			if (_success) {
				if (action.equals("login")) {
					emailVerified = fauth.getCurrentUser().isEmailVerified();
					if (emailVerified) {
						if (email.getText().toString().equals("") || pass.getText().toString().equals("")) {

						}
						else {
							if (Util.isConnected(getApplicationContext())) {

								otp_timer = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												in.setClass(getApplicationContext(), MainActivity.class);
												startActivity(in);
												otp_timer.cancel();
												finish();
											}
										});
									}
								};
								_timer.schedule(otp_timer, (int)(300));
							}
							else {
								_Sneek_Message(linear1, "No internet !");
							}
						}
					}
					else {
						email_dialog.setMessage("Please verify your email for login to your account! check your email now.\n\n** Check email on spam folder **");
						email_dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								try {


									Intent intent = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
									intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
									startActivity(intent);


								} catch(Exception e) {

								}
							}
						});
						email_dialog.setNeutralButton("Resend Verification", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								fauth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
									@Override
									public void onComplete(Task<Void> task) {

										if (task.isSuccessful()) {

											_Sneek_Message(linear1, "Verification sent.");
										} else {

											_Sneek_Message(linear1, "Failed to sent verification..");
										}


									} });
							}
						});
						email_dialog.create().show();
					}
				}
				else {

				}
			}
			else {
				_Sneek_Message(linear1, _errorMessage);
			}
		} catch(Exception e) {
			showMessage(e.toString());
		}	*/


/*

// OTP SEND

if (_success) {
			_Sneek_Message(linear1, "Password reset email sent..");
		}
		else {
			_Sneek_Message(linear1, "Failed to sent..");
		}*/


	}

	/*public void _request_api (final String _method) {
		api_map = new HashMap<>();
		api_map.put("method", _method);
		api_map.put("student_id", stu_id);
		
		net.setParams(api_map, RequestNetworkController.REQUEST_PARAM);
		net.startRequestNetwork(RequestNetworkController.GET, api, "no tag", _in_request_listener);


	}*/


	private void initializeLogic() {


		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {

				//TimeAPI.startRequestNetwork(RequestNetworkController.GET, "https://timeapi.io/api/Time/current/zone?timeZone=Asia/Kolkata", "", _TimeAPI_request_listener);

				//_Sneek_Message(linear1,"time");

				//Toast.makeText(LoginActivity.this, "TIME API WORKS ", Toast.LENGTH_SHORT).show();

				// this code will be executed after 2 seconds
			}
		}, 4000);


		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_UI();
		action_btn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFF367CF1));
		forgot_pass.setVisibility(View.GONE);
		otp_layout.setVisibility(View.GONE);
		progressbar.setVisibility(View.GONE);
		_setTransitionName(img, "p");
		_set_white_bg(name);
		_set_white_bg(phone_no);
		_set_white_bg(email);
		_set_white_bg(pass);
		_set_white_bg(c_pass);
		_set_white_bg(refer_code);

		_changeActivityFont("google_sans_medium");


/*		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			emailVerified = Objects.requireNonNull(fauth.getCurrentUser()).isEmailVerified();
			if (emailVerified) {

				in.setClass(getApplicationContext(), LayoutActivity.class);
				startActivity(in);
				finish();
			}
			else {


				login_txt.performClick();
				email.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
				_Sneek_Message(linear1, "Verify your email : ".concat(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser().getEmail())));
			}
		}*/

	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {

		super.onActivityResult(_requestCode, _resultCode, _data);

	}
	
	@Override
	public void onBackPressed() {
		imageview1.performClick();
	}
	public void _cornor_before (final View _view, final double _stroke, final double _radius) {
		_view.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)_radius, (int)_stroke, 0xFFBDBDBD, 0xFFFAFAFA));
	}
	
	
	public void _on_click_cornor (final View _view, final double _stroke, final double _radius) {
		_view.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)_radius, (int)_stroke, 0xFF367CF1, 0xFFE3F2FD));
	}

	
	
	public void _set_white_bg (final View _view) {
		_view.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, Color.TRANSPARENT));
	}
	

	public void _transition_Animation () {
		android.transition.TransitionManager.beginDelayedTransition(bg_);
		
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		
		params.setMargins(0, 0, 0, 0);
		
		bg_.setLayoutParams(params);
		
		
	}
	
	
	public void _changeActivityFont (final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			Util.showMessage(getApplicationContext(), "Error Loading Font");
		}
	}
	
	
	public void _setTransitionName (final View _view, final String _transitionName) {
		_view.setTransitionName(_transitionName);
	}


	public void login_api_request(String email,String password)
	{
		Toast.makeText(this, "Login complete", Toast.LENGTH_SHORT).show();
	}

	public void signup_api_request(String email,String password, String name, String phone)
	{

		Toast.makeText(this, "Signup complete", Toast.LENGTH_SHORT).show();


		send_otp_api_request(phone,"otp_verify_new_user");

	}

	public void send_otp_api_request(String phone,String otp_type)
	{
		action = otp_type;
		//Toast.makeText(this, action, Toast.LENGTH_SHORT).show();
		_show_otp_layout();
		progressbar.setVisibility(View.GONE);
		if(otp_type.equals("otp_verify_new_user"))
		{
			login_mode_ = true;
			login_txt.setText("Create account");
			//send for new user
			Toast.makeText(this, "otp_verify_new_user", Toast.LENGTH_SHORT).show();

		}else{

			login_mode_ = false;
			login_txt.setText("Login account");
			// forgot password
			Toast.makeText(this, "otp_for_reset_password", Toast.LENGTH_SHORT).show();

		}

	}


	public void verify_otp_for_password_reset()
	{

		_show_password_reset_layout();
		action = "password_reset";
		// show password + confirm pass layout then > login
		Toast.makeText(this, "	Password updated", Toast.LENGTH_SHORT).show();
	}
	public void verify_otp_for_signup()
	{
		// restart the app
		finish();
		startActivity(new Intent(getApplicationContext(),MainActivity.class));
		Toast.makeText(this, "Account created", Toast.LENGTH_SHORT).show();

	}




	public void _input_login () {
		try {

			// HERE one button perform all tasks

			Toast.makeText(this, action, Toast.LENGTH_SHORT).show();

			if (Util.isConnected(getApplicationContext())) {

				switch (action)
					{
						case "login" : {

							// LOGIN BLOCK
							if (email.getText().toString().trim().equals("") || pass.getText().toString().trim().equals("")) {
								email.setError("Invalid email !");
								pass.setError("Invalid password !");
								progressbar.setVisibility(View.GONE);
							} else {
								if(Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches() || email.getText().toString().trim().length()==10 ){

									if (Util.isConnected(getApplicationContext())) {


										login_api_request(email.getText().toString().trim(),pass.getText().toString().trim());

										//fauth.signInWithEmailAndPassword(email.getText().toString().trim(), pass.getText().toString().trim()).addOnCompleteListener(LoginActivity.this, _fauth_sign_in_listener);
									}
									else {
										_Sneek_Message( "No internet !");
										progressbar.setVisibility(View.GONE);
									}

								} else{
									email.setError("Invalid email or phone no ! ");
									progressbar.setVisibility(View.GONE);
								}
							}
						}

						break;
						 case "otp_for_reset_password": {

							 // OTP BLOCK
							 if (otp_text.getText().toString().trim().equals("")) {
								 otp_text.setError("Invalid OTP !");
								 progressbar.setVisibility(View.GONE);

							 } else {

							 	if (Util.isConnected(LoginActivity.this)) {

									verify_otp_for_password_reset();

							 	}
									 else {
										 _Sneek_Message( "No internet !");
										 progressbar.setVisibility(View.GONE);
									 }


							 }
						 }


						 break;
						case "otp_verify_new_user":{

							// NEW USER OTP BLOCK
							if (otp_text.getText().toString().trim().equals("")) {
								otp_text.setError("Invalid OTP !");
								progressbar.setVisibility(View.GONE);

							} else {

								if (Util.isConnected(getApplicationContext())) {

									verify_otp_for_signup();

								}
								else {
									_Sneek_Message( "No internet !");
									progressbar.setVisibility(View.GONE);
								}


							}
						}


						break;

						case "forgot_password": {

							//FORGOT PASSWORD BLOCK

							if (phone_no.getText().toString().trim().equals("")) {
								phone_no.setError("Empty phone no !");
								//c_pass.setError("Invalid confirm password !");
								progressbar.setVisibility(View.GONE);
							}
							else {
								if (phone_no.getText().toString().trim().length()==10) {
									if (Util.isConnected(getApplicationContext())) {


										send_otp_api_request(phone_no.getText().toString().trim(),"otp_for_reset_password");

										//fauth.sendPasswordResetEmail(email.getText().toString().trim()).addOnCompleteListener(_fauth_reset_password_listener);
									}
									else {
										_Sneek_Message( "No internet !");
										progressbar.setVisibility(View.GONE);
									}
								} else{
									phone_no.setError("Invalid Phone no !");
									progressbar.setVisibility(View.GONE);
								}
							}
						}


							break;


						case "password_reset": {

							//FORGOT PASSWORD BLOCK

							if (c_pass.getText().toString().trim().equals("") || pass.getText().toString().trim().equals("")) {
								pass.setError("Invalid password !");
								c_pass.setError("Invalid confirm password !");
								progressbar.setVisibility(View.GONE);
							}
							else {
								if (c_pass.getText().toString().trim().equals(pass.getText().toString().trim())) {
									if (pass.getText().toString().trim().length() > 7 ) {

										if (pass.getText().toString().contains("@")
											|| pass.getText().toString().contains("#")
											|| pass.getText().toString().contains("$")
											|| pass.getText().toString().contains("%")
											|| pass.getText().toString().contains("&")
											|| pass.getText().toString().contains("!")
											|| pass.getText().toString().contains("*")
											|| pass.getText().toString().contains("+")
											|| pass.getText().toString().contains("=")
											|| pass.getText().toString().contains("-")
											|| pass.getText().toString().contains("+")
											|| pass.getText().toString().contains("<")
											|| pass.getText().toString().contains(".")
											|| pass.getText().toString().contains("/")
											|| pass.getText().toString().contains("?")) {


										if (Util.isConnected(LoginActivity.this)) {

											finish();

											Toast.makeText(this, "Password updated", Toast.LENGTH_SHORT).show();
											//send_otp_api_request(phone_no.getText().toString().trim());

											//fauth.sendPasswordResetEmail(email.getText().toString().trim()).addOnCompleteListener(_fauth_reset_password_listener);
										}
										else {
											_Sneek_Message( "No internet !");
											progressbar.setVisibility(View.GONE);
										}

									}else {

										pass.setError("At least 1 spl char @#$&!?");
										progressbar.setVisibility(View.GONE);
									}
									}
									else {
										progressbar.setVisibility(View.GONE);
										_Sneek_Message( "No internet !");
									}


								} else{
									//pass.setError("password not match!");
									c_pass.setError("confirm password not match!");
									progressbar.setVisibility(View.GONE);
								}
							}
						}


						break;

						default:
						{
							// THIS IS " no_login " action = SIGNUP
							{

								// SIGNUP BLOCK
								if (email.getText().toString().trim().equals("") || (pass.getText().toString().trim().equals("") || (phone_no.getText().toString().trim().equals("") || name.getText().toString().trim().equals("")))) {
									email.setError("Invalid email !");
									name.setError("Invalid user name !");
									pass.setError("Invalid password !");
									phone_no.setError("Invalid phone no !");
									progressbar.setVisibility(View.GONE);
								}
								else {
									if(Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches()){
										if (pass.getText().toString().trim().length() > 7 ) {


											       if (pass.getText().toString().contains("@")
													|| pass.getText().toString().contains("#")
													|| pass.getText().toString().contains("$")
													|| pass.getText().toString().contains("%")
													|| pass.getText().toString().contains("&")
													|| pass.getText().toString().contains("!")
													|| pass.getText().toString().contains("*")
													|| pass.getText().toString().contains("+")
													|| pass.getText().toString().contains("=")
													|| pass.getText().toString().contains("-")
													|| pass.getText().toString().contains("+")
													|| pass.getText().toString().contains("<")
													|| pass.getText().toString().contains(".")
													|| pass.getText().toString().contains("/")
													|| pass.getText().toString().contains("?")) {

											if (c_pass.getText().toString().trim().equals(pass.getText().toString().trim())) {
												if (30 > name.getText().toString().trim().length()) {
													if (phone_no.getText().toString().trim().length() == 10) {
														if (Util.isConnected(getApplicationContext())) {


															signup_api_request("","","","");
															//fauth.createUserWithEmailAndPassword(email.getText().toString().trim(), pass.getText().toString().trim()).addOnCompleteListener(LoginActivity.this, _fauth_create_user_listener);

														}
														else {
															progressbar.setVisibility(View.GONE);
															_Sneek_Message( "No internet !");
														}
													}
													else {
														phone_no.setError("Invalid Phone No ! ");
														progressbar.setVisibility(View.GONE);
													}
												}
												else {
													_Sneek_Message( "User name very big !");
												}
											}
											else {
												c_pass.setError("Different Password !");
												progressbar.setVisibility(View.GONE);
											}

											}else {

											pass.setError("At least 1 spl char @#$&!?");
											progressbar.setVisibility(View.GONE);
										}

									}
									else {
										pass.setError("Very small password !");
										progressbar.setVisibility(View.GONE);
									}

									} else{
										email.setError("Invalid email ! or blank space ");
										progressbar.setVisibility(View.GONE);
									}
								}
							}
						}

					}







			}
			else {
				_Sneek_Message( "No internet !");
				progressbar.setVisibility(View.GONE);
			}
		} catch(Exception e) {
			progressbar.setVisibility(View.GONE);
			showMessage(e.toString());
		}
	}
	


	
	public void _Sneek_Message ( final String _msg) {

		Toast.makeText(this, _msg, Toast.LENGTH_LONG).show();

		/*com.google.android.material.snackbar.Snackbar.make(coordinatorLayout, _msg, com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
			@Override
			public void onClick(View _view) {

			}
		}).show();*/

	}
	
	
	public void _clickAnimation (final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.94f, 1f, 0.94f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(200);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	

	
	public void _show_otp_layout () {
		linear13.setVisibility(View.VISIBLE);
		input_layout.setVisibility(View.GONE);
		otp_layout.setVisibility(View.VISIBLE);
		resend_otp.performClick();
		title_desc.setText("an OTP sent to +91 ".concat(phone_no.getText().toString()));
		title.setText("Verify your number");
		bottom_desc.setText("Go back to ");
		login_txt.setText("Create account"); // bottom side text
		action_text.setText("Verify OTP");
	}


	public void _login_mode () {
		_hide_otp_layout();

		action_text.setText("Create account");
		title.setText("Let's Get Started!");

		email.setHint("Email");
		title_desc.setText("Create your account to continue.");
		login_txt.setText("Login here");
		bottom_desc.setText("Already have an account? ");
		forgot_pass.setVisibility(View.GONE);
		user_name_layout.setVisibility(View.VISIBLE);
		phone_layout.setVisibility(View.VISIBLE);
		password_layout.setVisibility(View.VISIBLE);
		confirm_password_layout.setVisibility(View.VISIBLE);
		email_id_layout.setVisibility(View.VISIBLE);
		confirm_password_layout.setVisibility(View.VISIBLE);
		linear14.setVisibility(View.VISIBLE);  // refer code layout
		action = "signup";
	}


	public void _signin_mode () {

		_hide_otp_layout();

		action_text.setText("Login now");
		title.setText("Welcome back!");
		email.setHint("Enter Email or Phone no");
		title_desc.setText("Login to continue");
		email_id_layout.setVisibility(View.VISIBLE);
		password_layout.setVisibility(View.VISIBLE);
		forgot_pass.setVisibility(View.VISIBLE);
		login_txt.setText("Create account");
		bottom_desc.setText("Not have an account? ");
		user_name_layout.setVisibility(View.GONE);
		phone_layout.setVisibility(View.GONE);
		confirm_password_layout.setVisibility(View.GONE);
		linear14.setVisibility(View.GONE);   // refer code layout


		action = "login";
	}

	public void _enter_new_password_mode () {
		action_text.setText("Login now");
		title.setText("Welcome back!");
		title_desc.setText("Login to continue");
		forgot_pass.setVisibility(View.VISIBLE);
		login_txt.setText("Create one");
		bottom_desc.setText("Not have an account? ");
		user_name_layout.setVisibility(View.GONE);
		phone_layout.setVisibility(View.GONE);
		confirm_password_layout.setVisibility(View.GONE);
		linear14.setVisibility(View.GONE);
		action = "new_password";
	}


	public void _show_password_reset_layout () {

		progressbar.setVisibility(View.GONE);
		action = "password_reset";

		user_name_layout.setVisibility(View.GONE);
		phone_layout.setVisibility(View.GONE);
		email_id_layout.setVisibility(View.GONE);
		forgot_pass.setVisibility(View.GONE);
		otp_layout.setVisibility(View.GONE);

		input_layout.setVisibility(View.VISIBLE);
		password_layout.setVisibility(View.VISIBLE);
		confirm_password_layout.setVisibility(View.VISIBLE);


		title_desc.setText("Set your new password");
		title.setText("New Password");
		bottom_desc.setText("Go back to ");
		login_txt.setText("Login account"); // bottom side text
		action_text.setText("Update New Password");
	}

	public void _UI () {
		_cornor_before(user_name_layout, 2, 30);
		_cornor_before(email_id_layout, 2, 30);
		_cornor_before(phone_layout, 2, 30);
		_cornor_before(password_layout, 2, 30);
		_cornor_before(confirm_password_layout, 2, 30);
		_cornor_before(linear14, 2, 30);
	}


	public void _hide_otp_layout () {
		input_layout.setVisibility(View.VISIBLE);
		otp_layout.setVisibility(View.GONE);
	}
	
	
	public void _extra_top () {
		pass.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
		// pass.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass1, 0, 0, 0);
		c_pass.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
		//c_pass.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass1, 0, 0, 0);
	}
	
	
	public void _extra_bottom () {
		pass.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		//pass.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass2, 0, 0, 0);
		c_pass.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		//c_pass.setCompoundDrawablesWithIntrinsicBounds(R.drawable.pass2, 0, 0, 0);
	}
	
	
	public void _create_user_data_on_db () {



			map = new HashMap<>();
			if(sh.getString("u_name", "").equals("")){
				map.put("phone","");

				if(!action.equals("login")){}
				//map.put("name",FirebaseAuth.getInstance().getCurrentUser().getEmail().substring(0,7));


			}else {
				map.put("name", sh.getString("u_name", ""));
				map.put("phone", sh.getString("u_phone", ""));
			}


			//map.put("email",FirebaseAuth.getInstance().getCurrentUser().getEmail());
			map.put("rank", "");
			map.put("coin", 5500);
		    map.put("t_coin", 0);
			map.put("refer", 0);
			map.put("earned", 0);
			//map.put("t_earned", 0);
			map.put("online", true);
			map.put("withdrawal", false);
			map.put("bank_info", "");
			map.put("last_seen",sh.getString("date", ""));

			//_Sneek_Message(linear1,sh.getString("date", ""));

		map.put("redeem",""); // must be black the redeem
			map.put("t_block","f");
			map.put("request_amt","");
		   // map.put("id", FirebaseAuth.getInstance().getCurrentUser().getUid());

		   // user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
			map.clear();

	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	

	
}
