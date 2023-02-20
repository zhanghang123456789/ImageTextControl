package com.hang.space.widget

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hang.space.R
import com.hang.space.databinding.CustomImageTextControlLayoutBinding
import com.hang.space.utils.gone
import com.hang.space.utils.visible
import kotlin.math.roundToInt


/**
 * @Author: zhang hang
 * @Data: 2023/2/17
 * @Des: 图文控件
 */
class ImageTextControl(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {


    private val viewBinding =
        CustomImageTextControlLayoutBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val attr = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageTextControl)
        val coreIcon = attr.getResourceId(R.styleable.ImageTextControl_coreIcon, 0)
        val coreIconHeight = attr.getDimension(R.styleable.ImageTextControl_coreIconHeight, 58f)
        val coreIconWidth = attr.getDimension(R.styleable.ImageTextControl_coreIconWidth, 58f)
        val customTextSize = attr.getFloat(R.styleable.ImageTextControl_customTextSize, 18f)
        val bottomText = attr.getString(R.styleable.ImageTextControl_bottomText)
        val leftText = attr.getString(R.styleable.ImageTextControl_leftText)
        val rightText = attr.getString(R.styleable.ImageTextControl_rightText)
        val topText = attr.getString(R.styleable.ImageTextControl_topText)
        val bottomPadding = attr.getDimension(R.styleable.ImageTextControl_bottomPadding, 0f)
        val leftPadding = attr.getDimension(R.styleable.ImageTextControl_leftPadding, 0f)
        val rightPadding = attr.getDimension(R.styleable.ImageTextControl_rightPadding, 0f)
        val topPadding = attr.getDimension(R.styleable.ImageTextControl_topPadding, 0f)


        viewBinding.apply {

            customIvImgTxtLeftCore.setImageResource(coreIcon)

            val layoutParams: ViewGroup.LayoutParams = customIvImgTxtLeftCore.layoutParams
            layoutParams.width = coreIconWidth.roundToInt()
            layoutParams.height = coreIconHeight.roundToInt()
            customIvImgTxtLeftCore.layoutParams = layoutParams

            customTvImgTxtBottomChar.textSize = customTextSize
            customTvImgTxtTopChar.textSize = customTextSize
            customTvImgTxtLeftChar.textSize = customTextSize
            customTvImgTxtRightChar.textSize = customTextSize

            customTvImgTxtBottomChar.gone()
            customTvImgTxtTopChar.gone()
            customTvImgTxtLeftChar.gone()
            customTvImgTxtRightChar.gone()

            if (!TextUtils.isEmpty(bottomText)) {
                customTvImgTxtBottomChar.visible()
            }
            if (!TextUtils.isEmpty(leftText)) {
                customTvImgTxtLeftChar.visible()
            }
            if (!TextUtils.isEmpty(rightText)) {
                customTvImgTxtRightChar.visible()
            }
            if (!TextUtils.isEmpty(topText)) {
                customTvImgTxtTopChar.visible()
            }

            if (bottomPadding > 0) {
                customTvImgTxtBottomChar.setPadding(0, bottomPadding.roundToInt(), 0, 0)
            }
            if (leftPadding > 0) {
                customTvImgTxtLeftChar.setPadding(0, 0, leftPadding.roundToInt(), 0)
            }
            if (rightPadding > 0) {
                customTvImgTxtRightChar.setPadding(rightPadding.roundToInt(), 0, 0, 0)
            }
            if (topPadding > 0) {
                customTvImgTxtTopChar.setPadding(0, 0, 0, topPadding.roundToInt())
            }

        }

        attr.recycle()
    }


}