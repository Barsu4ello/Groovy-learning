package com.gorbunov.lesson19

import groovy.io.FileType

class IORunner {

    static void main(String[] args) {
        def file = new File("src/main/resources/test.txt")
        println file.text // Не нужно ни потоков ввода, вывода ни открывать или закрывать их.

        file.each {
            println 'вход'
            if (it != "123") {
                println it
            }
        }

        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }

        def writer = new StringWriter()
        //Если мы хотим создать Reader надо будет закрывать поток. Но как и в java можно использовать try with resources
        try (def reader = file.newReader()) {
            // todo: do something useful
            writer << reader
        }

        //write
        def file2 = new File("src/main/resources/test2.txt")
        file2.text = "Some text"
        file2 << "New line" << System.lineSeparator()
//        file2.withOutputStream {} // Не надо закрывать
//        file2.newWriter() // Надо закрывать
//        file2.newOutputStream() // Надо закрывать

        def srcDir = new File("src")
        srcDir.eachDir { println it}
        srcDir.eachDirRecurse { println it} // с входом в поддиректории
        srcDir.eachFileRecurse(FileType.FILES){println it.name} // с входом в поддиректории только по файлам. Или в зависимости от FileType.
    }
}
