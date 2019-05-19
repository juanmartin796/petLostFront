package otros.martin.com.petlost.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

import otros.martin.com.petlost.R;

public class PicassoService {
    private static final PicassoService ourInstance = new PicassoService();
    private final Picasso picasso;

    public static PicassoService getInstance() {
        return ourInstance;
    }

    private PicassoService() {
        picasso = Picasso.get();
    }

    public void run(Context context, String urlImage, ImageView imageView){
        Picasso.get().load(urlImage)
                .placeholder(context.getDrawable(R.drawable.progress_image_animation))
                .into(imageView);
    }

    public void run(Context context, Bitmap bitmap, ImageView imageView){
        Picasso.get().load(getImageUri(context, bitmap))
                .placeholder(context.getDrawable(R.drawable.progress_image_animation))
                .into(imageView);
    }

    private Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
