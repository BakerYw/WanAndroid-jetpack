package com.nyw.uikit.toolbar

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

/**
 * @author NieYuWen
 * @date 2021/9/24 4:30 下午
 * @email：992116519@qq.com
 * @desc: 自定义的 CollapsibleToolbar 和折叠的文本
 */
class CollapsibleToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,defStyleAttr: Int = 0
) : MotionLayout(context, attrs ,defStyleAttr) , AppBarLayout.OnOffsetChangedListener{
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }

}