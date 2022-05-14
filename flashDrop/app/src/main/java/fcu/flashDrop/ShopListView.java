package fcu.flashDrop;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ListView;

public class ShopListView extends ListView {
    public ShopListView(Context context) {
        super(context);
    }

    public ShopListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShopListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >>2,MeasureSpec.AT_MOST);
        //VIEW的大小采用30位进行存储，那么我们应该给他30位的最大值，Int的最大值是32位
        super.onMeasure(widthMeasureSpec,heightSpec);
    }
}