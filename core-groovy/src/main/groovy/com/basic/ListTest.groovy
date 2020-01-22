package com.basic

class ListTest {

    static void main(String[] args) {

        def numbers = [1, 2, 3]

        assert numbers instanceof List
        assert numbers.size() == 3

        // as 关键字, LinkedList
        def arrayList = [1, 2, 3]
        assert arrayList instanceof java.util.ArrayList

        def linkedList = [2, 3, 4] as LinkedList
        assert linkedList instanceof java.util.LinkedList

        LinkedList otherLinked = [3, 4, 5]
        assert otherLinked instanceof java.util.LinkedList

        // << 表示 append elements to a list.

        def letters = ['a', 'b', 'c', 'd']

        assert letters[0] == 'a'
        assert letters[1] == 'b'

        assert letters[-1] == 'd'
        assert letters[-2] == 'c'

        letters[2] = 'C'
        assert letters[2] == 'C'

        letters << 'e'
        assert letters[4] == 'e'
        assert letters[-1] == 'e'

        assert letters[1, 3] == ['b', 'd']
        assert letters[2..4] == ['C', 'd', 'e']

        // 多维list

        def multi = [[0, 1], [2, 3]]
        assert multi[1][0] == 2

        // 添加

        def letters2 = ['a', 'b', 'c', 'd']
        letters2.add("e")
        letters2 << 'f'
        assert letters2.size() == 6

        // 删除

        def letters3 = ['a', 'b', 'c', 'd']
        letters3.remove('d')
        assert letters3.size() == 3

        // 循环

        for (String s : letters3) {
            println(s)
        }

        // 闭包循环
        //闭包中的 it 变量是一个关键字，指向被调用的外部集合的每个值 — 它是默认值，可以用传递给闭包的参数覆盖它
        letters3.each {
            println it
        }

        letters3.each {
            value -> println value
        }

        // 闭包还允许使用多个参数

        def hash = [name: "Andy", "VPN-#": 45]
        hash.each { key, value ->
            println "${key} : ${value}"
        }
    }
}
