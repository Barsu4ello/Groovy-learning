package com.gorbunov.lesson15

class RangeRunner {

    static void main(String[] args) {
        def range = 2..8
        assert range.getClass() == IntRange

        assert range.get(3) == 5
        assert range.contains(8)

        def range2 = 2<..<8 //не ключая 2 и 8
        assert !range2.contains(8)
        assert !range2.contains(2)

        range2.each { println it}

        ('a'..'d').each { println it}

        (WeekDay.MONDAY..<WeekDay.FRIDAY).each { println it}
        (WeekDay.WEDNESDAY..<WeekDay.MONDAY).each { println it} // Range поддерживает обратное направление

        //Range в switch работает как contains() в списках
        switch (7) {
            case 1..3 :  // аналогично List.of(1,2,3).contains(7)
                println 1
                break
            case 3..<7 :
                println 2
                break
            case 3..7 :
                println 3
                break
        }
    }
}
