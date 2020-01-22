package com.basic

class StringsTest {

    static void main(String[] args) {

        // 字符串声明

        def s1 = 'a single-quoted string'

        // 声明多行字符串

        def aMultilineString = '''line one
        line two
        line three'''

        // 多了换行符
        def startingAndEndingWithANewline = '''
        line one
        line two
        line three
        '''
        // 通过转义 去掉 前面的换行
        def strippedFirstNewline = '''\
        line one
        line two
        line three
        '''

        // 字符串串联

        def s2 = 'a' + 'b'
        assert s2 == 'ab'

        // 字符串动态插值

        def name = 'Guillaume'
        def greeting = "Hello ${name}"
        assert greeting.toString() == 'Hello Guillaume'

        def sum = "The sum of 2 and 3 equals ${2 + 3}"
        assert sum.toString() == 'The sum of 2 and 3 equals 5'

        def person = [name: 'Guillaume', age: 36]
        assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'


    }
}
