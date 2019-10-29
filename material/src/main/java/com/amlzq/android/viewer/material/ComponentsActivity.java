package com.amlzq.android.viewer.material;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 组件/部件
 */
public class ComponentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_material);
    }

    public void onLayout(View view) {
        startActivity(new Intent(this, LayoutActivity.class));
    }

    public void onWidget(View view) {
        startActivity(new Intent(this, WidgetActivity.class));
    }

    public void onPalette(View view) {
        Intent intent = PaletteActivity.newIntent(this,
                R.drawable.ippawards_49_1st_sunset_sreekumar_krishnan);
        startActivity(intent);
    }

    public void onChip(View view) {
        startActivity(new Intent(this, ChipActivity.class));
    }

    public void onAlertDialog(View view) {
        startActivity(new Intent(this, AlertDialogActivity.class));
    }

    public void onCollapsingToolbar(View view) {
        startActivity(new Intent(this, CollapsingToolbarActivity.class));
    }

    public void onBadge(View view) {
        startActivity(new Intent(this, BadgeActivity.class));
    }

    public void onBottomAppBar(View view) {
        startActivity(new Intent(this, BottomAppBarActivity.class));
    }

    public void onBottomNavigation(View view) {
        startActivity(new Intent(this, BottomNavigationViewActivity.class));
    }

    public void onBottomSheet(View view) {
        startActivity(new Intent(this, BottomSheetActivity.class));
    }

    public void onCheckbox(View view) {
        startActivity(new Intent(this, CheckBoxActivity.class));
    }

    public void onFloatingActionButton(View view) {
        startActivity(new Intent(this, FloatingActionButtonActivity.class));
    }

    public void onMaterialButton(View view) {
        startActivity(new Intent(this, MaterialButtonActivity.class));
    }

    public void onMaterialCard(View view) {
        startActivity(new Intent(this, CardViewActivity.class));
    }

    public void onConstraintLayout(View view) {
        startActivity(new Intent(this, ConstraintLayoutActivity.class));
    }

    public void onFlexBoxLayout(View view) {
        startActivity(new Intent(this, FlexboxLayoutActivity.class));
    }

}
