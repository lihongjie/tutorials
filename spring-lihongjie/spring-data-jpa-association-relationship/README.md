domain6 : 继承和定制类型
5.1.1 每个带有隐式多态的具体类一张表
这种方法的主要问题在于，它不支持多态关联。因为BillingDetails与User关联;两张子类表都需要一个对USERS表的外键引用。或者，如果User与BillingDetails有个多对一的关系，USERS表就需要单个的外键列，它必须同时引用两个具体的子类表。
另外的的问题在于多态查询，