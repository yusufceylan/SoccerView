package com.ysfcyln.soccerview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.res.ResourcesCompat


class SoccerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    //region vars
    companion object {
        const val NUM_OF_GRASS_ROWS = 8
    }

    private val grassColor1 =
        ResourcesCompat.getColor(context.resources, android.R.color.holo_green_light, context.theme)
    private val grassColor2 =
        ResourcesCompat.getColor(context.resources, android.R.color.holo_green_dark, context.theme)

    private val defaultPadding = 16.ToPx
    private val halfInnerGoalWidth = 16.ToPx
    private val halfInnerGoalHeight = 12.ToPx
    private val halfGoalWidth = 52.ToPx
    private val halfGoalHeight = 32.ToPx
    private val cornerSizeRadius = 12.ToPx
    private val centerOuterCircleRadius = 24.ToPx
    private val centerInnerCircleRadius = 6.ToPx
    //endregion

    init {
        // do something here
    }

    //region Grass View
    /**
     * Create paint object for Grass
     */
    private fun createGrassPaint() : Paint {
        return Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
        }
    }

    /**
     * Draw Grass and style with [Paint] object
     */
    private fun prepareGrassRows(canvas: Canvas?) {
        // Create a paint object
        val grassPaint = createGrassPaint()
        // Calculate single row height
        val rowHeight = height / NUM_OF_GRASS_ROWS
        // Use Canvas to draw views
        canvas?.apply {
            for (i in 0..NUM_OF_GRASS_ROWS) {
                // Top value of each row
                val top = i * rowHeight
                // Create Rect for Grass Row
                val rect = Rect()
                // Set values of each Rect Object which corresponds to a Grass Row
                rect.set(0, top, width, top + rowHeight)
                // Set paint color
                grassPaint.color = if (i % 2 == 0) grassColor1 else grassColor2
                // Draw on the Canvas
                drawRect(rect, grassPaint)
            }
        }
    }
    //endregion

    //region General Borders
    /**
     * Create paint object for Grass
     */
    private fun createLinePaint() : Paint {
        return Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = 4.ToPx.toFloat()
            color = ResourcesCompat.getColor(
                context.resources,
                android.R.color.white,
                context.theme
            )
        }
    }

    /**
     * Create general border lines
     */
    private fun prepareBorders(canvas: Canvas?) {
        // Create Line Paint
        val linePaint = createLinePaint()
        // Use Canvas to draw views
        canvas?.apply {
            // Create rect
            val rect = Rect()
            // Set bounds
            rect.set(
                defaultPadding,
                defaultPadding,
                width - defaultPadding,
                height - defaultPadding
            )
            // Draw on the Canvas
            drawRect(rect, linePaint)
        }
    }
    //endregion

    //region GoalPost
    /**
     * Prepare Home - Away goal areas
     */
    private fun prepareGoalAreas(canvas: Canvas?) {
        prepareHomeGoalPost(canvas)
        prepareHomeGoalLine(canvas)
        prepareAwayGoalPost(canvas)
        prepareAwayGoalLine(canvas)
    }
    /**
     * Create Home Goal Post
     */
    private fun prepareHomeGoalPost(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = createLinePaint()
        // Create Rect object
        val rect = Rect()
        // Use Canvas to draw views
        canvas?.apply {
            rect.set(
                (width / 2) - halfInnerGoalWidth,
                defaultPadding,
                (width / 2) + halfInnerGoalWidth,
                defaultPadding + halfInnerGoalHeight
            )
            // Draw on the Canvas
            canvas.drawRect(rect, linePaint)
        }
    }

    /**
     * Prepare Home Goal Line
     */
    private fun prepareHomeGoalLine(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = createLinePaint()
        // Create Rect object
        val rect = Rect()
        // Use Canvas to Draw Views
        canvas?.apply {
            rect.set(
                (width / 2) - halfGoalWidth,
                defaultPadding,
                (width / 2) + halfGoalWidth,
                defaultPadding + halfGoalHeight
            )
            // Draw on the Canvas
            canvas.drawRect(rect, linePaint)
        }
    }

    /**
     * Create Away Goal Post
     */
    private fun prepareAwayGoalPost(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = createLinePaint()
        // Create Rect object
        val rect = Rect()
        // Use Canvas to draw views
        canvas?.apply {
            rect.set(
                (width / 2) - halfInnerGoalWidth,
                height - defaultPadding - halfInnerGoalHeight,
                (width / 2) + halfInnerGoalWidth,
                height - defaultPadding
            )
            // Draw on the Canvas
            canvas.drawRect(rect, linePaint)
        }
    }

    /**
     * Prepare Away Goal Line
     */
    private fun prepareAwayGoalLine(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = createLinePaint()
        // Create Rect object
        val rect = Rect()
        // Use Canvas to Draw Views
        canvas?.apply {
            rect.set(
                (width / 2) - halfGoalWidth,
                height - defaultPadding - halfGoalHeight,
                (width / 2) + halfGoalWidth,
                height - defaultPadding
            )
            // Draw on the Canvas
            canvas.drawRect(rect, linePaint)
        }
    }
    //endregion

    //region Corner Arc
    // Useful document for draw arc
    // https://thoughtbot.com/blog/android-canvas-drawarc-method-a-visual-guide
    /**
     * Prepare all corner arcs
     */
    private fun prepareCornerArcs(canvas: Canvas?) {
        prepareLeftTopCornerArc(canvas)
        prepareRightTopCornerArc(canvas)
        prepareBottomLeftCornerArc(canvas)
        prepareBottomRightCornerArc(canvas)
    }

    /**
     * Draw left top corner arc
     */
    private fun prepareLeftTopCornerArc(canvas: Canvas?) {
        // Get paint
        val paint = createLinePaint()
        // Create Rect Object
        val rect = RectF()
        // Calculate the rect / bounds of oval
        rect.set(
            (defaultPadding - cornerSizeRadius).toFloat(),
            (defaultPadding - cornerSizeRadius).toFloat(),
            (defaultPadding + cornerSizeRadius).toFloat(),
            (defaultPadding + cornerSizeRadius).toFloat()
        )
        // Draw on canvas
        canvas?.apply {
            canvas.drawArc(rect, 0f, 90f, false, paint)
        }
    }

    /**
     * Draw right top corner arc
     */
    private fun prepareRightTopCornerArc(canvas: Canvas?) {
        // Get paint
        val paint = createLinePaint()
        // Create Rect Object
        val rect = RectF()
        // Calculate the rect / bounds of oval
        rect.set(
            (width - defaultPadding - cornerSizeRadius).toFloat(),
            (defaultPadding - cornerSizeRadius).toFloat(),
            (width - defaultPadding + cornerSizeRadius).toFloat(),
            (defaultPadding + cornerSizeRadius).toFloat()
        )
        // Draw on canvas
        canvas?.apply {
            canvas.drawArc(rect, 90f, 90f, false, paint)
        }
    }

    /**
     * Draw bottom left corner arc
     */
    private fun prepareBottomLeftCornerArc(canvas: Canvas?) {
        // Get paint
        val paint = createLinePaint()
        // Create Rect Object
        val rect = RectF()
        // Calculate the rect / bounds of oval
        rect.set(
            (defaultPadding - cornerSizeRadius).toFloat(),
            (height - defaultPadding - cornerSizeRadius).toFloat(),
            (defaultPadding + cornerSizeRadius).toFloat(),
            (height - defaultPadding + cornerSizeRadius).toFloat()
        )
        // Draw on canvas
        canvas?.apply {
            canvas.drawArc(rect, 270f, 90f, false, paint)
        }
    }

    /**
     * Draw bottom right corner arc
     */
    private fun prepareBottomRightCornerArc(canvas: Canvas?) {
        // Get paint
        val paint = createLinePaint()
        // Create Rect Object
        val rect = RectF()
        // Calculate the rect / bounds of oval
        rect.set(
            (width - defaultPadding - cornerSizeRadius).toFloat(),
            (height - defaultPadding - cornerSizeRadius).toFloat(),
            (width - defaultPadding + cornerSizeRadius).toFloat(),
            (height - defaultPadding + cornerSizeRadius).toFloat()
        )
        // Draw on canvas
        canvas?.apply {
            canvas.drawArc(rect, 180f, 90f, false, paint)
        }
    }
    //endregion

    //region Center Lines and Circles
    /**
     * Prepare center line and circles
     */
    private fun prepareCenterViews(canvas: Canvas?) {
        prepareCenterLine(canvas)
        prepareCenterOuterCircle(canvas)
        prepareCenterInnerCircle(canvas)
    }
    /**
     * Draw center line
     */
    private fun prepareCenterLine(canvas: Canvas?) {
        // Create Line Paint
        val linePaint = createLinePaint()
        // Use Canvas to draw views
        canvas?.apply {
            // Draw on the Canvas
            drawLine(
                defaultPadding.toFloat(),
                (height / 2).toFloat(),
                (width - defaultPadding).toFloat(),
                (height / 2).toFloat(),
                linePaint)
        }
    }

    /**
     * Draw center circle
     */
    private fun prepareCenterOuterCircle(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = createLinePaint()
        // Use Canvas to draw views
        canvas?.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            // Draw on the Canvas
            canvas.drawCircle(centerX, centerY, centerOuterCircleRadius.toFloat(), linePaint)
        }
    }

    /**
     * Prepare Inner Circle
     */
    private fun prepareCenterInnerCircle(canvas: Canvas?) {
        // Get Line Paint
        val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color =  ResourcesCompat.getColor(
                context.resources,
                android.R.color.white,
                context.theme
            )
        }
        // Use Canvas to draw views
        canvas?.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            canvas.drawCircle(centerX, centerY, centerInnerCircleRadius.toFloat(), linePaint)
        }
    }
    //endregion

    /**
     * Draw all prepared views
     */
    private fun drawSoccerView(canvas: Canvas?) {
        prepareGrassRows(canvas)
        prepareBorders(canvas)
        prepareGoalAreas(canvas)
        prepareCornerArcs(canvas)
        prepareCenterViews(canvas)
    }

    /**
     * Draw Views on Canvas
     */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawSoccerView(canvas)
    }
}