package com.itk.hday.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class RuneWarsGLActivity extends Activity {

	private GLSurfaceView mGLView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create a GLSurfaceView instance and set it
		// as the ContentView for this Activity
		if (hasGLES20()) {
			mGLView = new MyGLSurfaceView(this);
<<<<<<< HEAD
	//		mGLView.setPreserveEGLContextOnPause(true);

=======
			// mGLView.setPreserveEGLContextOnPause(true);
			setContentView(mGLView);
			
			 
			
>>>>>>> 25835b8e90a222a485b108244dead0bdaf2b6b22
		} else {
			// Time to get a new phone, OpenGL ES 2.0 not
			// supported.
			new AlertDialog.Builder(this)
					.setTitle("OpenGL ES 2.0")
					.setMessage("OpenGL ES 2.0 Not Supported")
					.setNeutralButton("Ok",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									// continue with delete
								}
							}).show();
		}


	}

	private boolean hasGLES20() {
		ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		ConfigurationInfo info = am.getDeviceConfigurationInfo();
		return info.reqGlEsVersion >= 0x20000;
	}

	@Override
	protected void onPause() {
		super.onPause();
		// The following call pauses the rendering thread.
		// If your OpenGL application is memory intensive,
		// you should consider de-allocating objects that
		// consume significant memory here.
		if (mGLView!= null)
		mGLView.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		// The following call resumes a paused rendering thread.
		// If you de-allocated graphic objects for onPause()
		// this is a good place to re-allocate them.
		if (mGLView!= null)
		mGLView.onResume();
	}
}

class MyGLSurfaceView extends GLSurfaceView {

	private final RuneWarsGLRenderer mRenderer;

	public MyGLSurfaceView(Context context) {
		super(context);

		// Create an OpenGL ES 2.0 context.
		setEGLContextClientVersion(2);

		// Set the Renderer for drawing on the GLSurfaceView
		mRenderer = new RuneWarsGLRenderer();
		setRenderer(mRenderer);

		// Render the view only when there is a change in the drawing data
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}

	private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	private float mPreviousX;
	private float mPreviousY;

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		// MotionEvent reports input details from the touch screen
		// and other input controls. In this case, you are only
		// interested in events where the touch position changed.

		float x = e.getX();
		float y = e.getY();

		switch (e.getAction()) {
		case MotionEvent.ACTION_MOVE:

			float dx = x - mPreviousX;
			float dy = y - mPreviousY;

			// reverse direction of rotation above the mid-line
			if (y > getHeight() / 2) {
				dx = dx * -1;
			}

			// reverse direction of rotation to left of the mid-line
			if (x < getWidth() / 2) {
				dy = dy * -1;
			}

			mRenderer.mAngle += (dx + dy) * TOUCH_SCALE_FACTOR; // = 180.0f /
																// 320
			requestRender();
		}

		mPreviousX = x;
		mPreviousY = y;
		return true;
	}

}
