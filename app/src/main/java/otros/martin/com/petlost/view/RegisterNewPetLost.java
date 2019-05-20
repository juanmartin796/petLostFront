package otros.martin.com.petlost.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mvc.imagepicker.ImagePicker;

import otros.martin.com.petlost.R;
import otros.martin.com.petlost.utils.PicassoService;

public class RegisterNewPetLost extends AppCompatActivity {
    private final int REQUEST_IMAGE = 1;
    ImageView ivAddImage, ivDeleteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_new_pet_lost);
        ivDeleteImage = findViewById(R.id.iv_delete_image);
        ivDeleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivAddImage.setImageResource(R.mipmap.ic_add_image);
                ivDeleteImage.setVisibility(View.GONE);
            }
        });

        ivAddImage = findViewById(R.id.select_image);
        ivAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*ImagePicker.Companion.with(RegisterNewPetLost.this)
                        .crop(1f, 1f)       //Crop Square image(Optional)
                        .compress(1024)   //Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080) //Final image resolution will be less than 1080 x 1080(Optional)
                        .start();*/
                //ImagePicker.setMinQuality(600, 600);
                ImagePicker.pickImage(RegisterNewPetLost.this, "Seleccione una imagen:");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
            if (requestCode == 234){
                Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
                PicassoService.getInstance().run(this, bitmap, ivAddImage);
                ivDeleteImage.setVisibility(View.VISIBLE);
            }
        }
    }
}
