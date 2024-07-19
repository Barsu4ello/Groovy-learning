package com.gorbunov.lesson7

def value = "Hello \"World\" ''"
def value1 = 'Hello "World" \'\'' // !!!Нет экранирования двойных кавычек в данном варианте, но надо экранировать одинарные

def value3 = "Hello $value1" // в Java так делать нельзя
def value4 = 'Hello $value1' // C одинарными кавычками такое не прокатит
println value3

def value5 = """
SELECT * 
FROM user
WHERE name = $value1
''
""
"""
println value5

//в скриптах def можно опустить
value6 = '''  
SELECT * 
FROM user
WHERE name = $value1
''
""
'''
println value6

// ЧТО ДЕЛАТЬ С char типом? Ведь '' у нас объявляет String и 'N' будет String а не char
def string = 'N' //String
char charEl = 'N' // Явное указание типа char делает переменную типа char(если быть точным то типа класса Character)

def getWithPrefix(String name) {
    "prefix -" + name   // Заметьте нет return! В groovy если нет return, то он автоматически ставит к последней строке.
}

value7 = """ 
SELECT * 
FROM user
WHERE name = ${getWithPrefix(value1)}
"""
println value7

def value8 = /Hello $value1 ''' "" \/ world/
println value8

def value9 = $/Hello $value1 ''' "" \/ world/$
println value9

//Можно через массив получать доступ к буквам слова по индексу
def value10 = "0123456"
println value10[2]
//Если ставим - то обращаемся к элементу по индексу начиная с конца слова
println value10[-1]
//Можно получить символы в промежутке
println value10[2..5]
println value10[-2..-5]
//Есть умножение строк. То есть будет 3 строки подряд
println value10*3 // будет 012345601234560123456
// Можно вычитать из любой части строки
println value10 - "01"
println value10 - "23"
println value10 - "56"
