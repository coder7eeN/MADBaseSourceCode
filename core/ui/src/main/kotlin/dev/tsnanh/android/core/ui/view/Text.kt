package dev.tsnanh.android.core.common.view

import android.text.TextUtils
import android.widget.TextView

fun TextView.expand(maxLinesCount: Int = Int.MAX_VALUE) {
    maxLines = maxLinesCount
}

fun TextView.collapse(lines: Int = 1) {
    maxLines = lines
}

fun TextView.ellipsizeStart() {
    ellipsize = TextUtils.TruncateAt.START
}

fun TextView.ellipsizeEnd() {
    ellipsize = TextUtils.TruncateAt.END
}

fun TextView.ellipsizeMiddle() {
    ellipsize = TextUtils.TruncateAt.MIDDLE
}

fun TextView.ellipsizeMarquee() {
    ellipsize = TextUtils.TruncateAt.MARQUEE
}
