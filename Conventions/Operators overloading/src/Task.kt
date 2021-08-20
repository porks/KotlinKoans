import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(interval: TimeInterval) = addTimeIntervals(interval, 1)

class MoreIntervals(val interval: TimeInterval, val n: Int)

operator fun TimeInterval.times(n: Int) = MoreIntervals(this, n)

operator fun MyDate.plus(moreIntervals: MoreIntervals) = addTimeIntervals(moreIntervals.interval, moreIntervals.n)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
