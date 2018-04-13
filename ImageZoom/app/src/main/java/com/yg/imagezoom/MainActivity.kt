package com.yg.imagezoom
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener, View.OnClickListener,
        CompoundButton.OnCheckedChangeListener
{
    private var customDialog: Dialog? = null


    override fun onClick(v: View?) {
        if (!mShowingFragments) {

            viewPager.adapter = cardFragmentPagerAdapter
            viewPager.setPageTransformer(false, shadowTransformer2)

//            mButton.setText("Views");
//            mViewPager.setAdapter(mFragmentCardAdapter);
//            mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        } else {
            viewPager.adapter = cardPagerAdapter
            viewPager.setPageTransformer(false, shadowTransformer)

//            mButton.setText("Fragments");
//            mViewPager.setAdapter(mCardAdapter);
//            mViewPager.setPageTransformer(false, mCardShadowTransformer);
        }
        mShowingFragments = !mShowingFragments

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        shadowTransformer!!.enableScaling(isChecked)
        shadowTransformer2!!.enableScaling(isChecked)
    }

    private lateinit var cardPagerAdapter : CardPagerAdpater
    private lateinit var cardFragmentPagerAdapter : CardFragmentPagerAdapter
    private var shadowTransformer : ShadowTransformer? = null
    private var shadowTransformer2 : ShadowTransformer? = null
    private var mShowingFragments = false

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardPagerAdapter = CardPagerAdpater()
        cardPagerAdapter.addCardItem(CardItem(R.drawable.nav2))
        cardPagerAdapter.addCardItem(CardItem(R.drawable.icon5))
        cardPagerAdapter.addCardItem(CardItem(R.drawable.page_pic1))
        cardPagerAdapter.addCardItem(CardItem(R.drawable.unicon5))
        cardFragmentPagerAdapter = CardFragmentPagerAdapter(supportFragmentManager,
                dpToPixels(2,this))
//
        shadowTransformer = ShadowTransformer(viewPager, cardPagerAdapter)
        shadowTransformer2 = ShadowTransformer(viewPager, cardFragmentPagerAdapter)

        viewPager.adapter = cardPagerAdapter
        viewPager.setPageTransformer(false, shadowTransformer)
        viewPager.offscreenPageLimit = 3

//        val v = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.zoon_item, null, false)
//        val layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
//
//        val zoomView = ZoomView(this)
//        zoomView.addView(v)
//        zoomView.layoutParams = layoutParams
//        zoomView.isMiniMapEnabled = true // 좌측 상단 검은색 미니맵 설정
//        zoomView.maxZoom = 4f // 줌 Max 배율 설정  1f 로 설정하면 줌 안됩니다.
//        zoomView.miniMapCaption = "Mini Map Test" //미니 맵 내용
//        zoomView.miniMapCaptionSize = 20f // 미니 맵 내용 글씨 크기 설정
//
//        zoomView.button.setOnClickListener {
//            Log.v("zmffr", "zmffr")
//        }
//
//        container.addView(zoomView)
        //imageCor.
    }

    fun dpToPixels(dp: Int, context: Context): Float {
        return dp * context.resources.displayMetrics.density
    }



    private val deleteLeftListener = View.OnClickListener {
        customDialog!!.dismiss()
    }

//    private val deleteLeftListener = View.OnClickListener {
//        customDialog!!.dismiss()
//    }
}
