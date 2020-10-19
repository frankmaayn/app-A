// Generated by view binder compiler. Do not edit!
package com.example.appa.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.appa.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBluetoothConnectAcitvityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppBarLayout appBarLayout;

  @NonNull
  public final ConstraintLayout coordinatorLayout2;

  @NonNull
  public final MaterialToolbar topAppBar;

  private ActivityBluetoothConnectAcitvityBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout coordinatorLayout2,
      @NonNull MaterialToolbar topAppBar) {
    this.rootView = rootView;
    this.appBarLayout = appBarLayout;
    this.coordinatorLayout2 = coordinatorLayout2;
    this.topAppBar = topAppBar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBluetoothConnectAcitvityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBluetoothConnectAcitvityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bluetooth_connect_acitvity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBluetoothConnectAcitvityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.appBarLayout;
      AppBarLayout appBarLayout = rootView.findViewById(id);
      if (appBarLayout == null) {
        break missingId;
      }

      ConstraintLayout coordinatorLayout2 = (ConstraintLayout) rootView;

      id = R.id.topAppBar;
      MaterialToolbar topAppBar = rootView.findViewById(id);
      if (topAppBar == null) {
        break missingId;
      }

      return new ActivityBluetoothConnectAcitvityBinding((ConstraintLayout) rootView, appBarLayout,
          coordinatorLayout2, topAppBar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
