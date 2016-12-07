package org.loader.shoplib;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.loader.router.Router;
import org.loader.router.rule.ActivityRule;
import org.loader.utilslib.Application;
import org.loader.utilslib.Logger;
import org.loader.utilslib.UseContext;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("shop");
        TextView tv = new TextView(this);
        tv.setTextSize(50);
        tv.setText("SHOP!!!");
        setContentView(tv);

        Logger.dump("TAG", "Hei! I am shop!!!");
        UseContext.use(Application.get());

        String data = getIntent().getStringExtra("data");
        tv.append(data);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = Router.invoke(ShopActivity.this, ActivityRule.ACTIVITY_SCHEME + "bbs.main");
                startActivity(it);
            }
        });
    }
}
