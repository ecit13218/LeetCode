Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.

题目意思是查找表中重复的数据
select Email from Person group by email having count(1) >1;
直接用group by having count >1 就可以了,当重复的数据量大于1 ,就是重复的

看了下还有另外种不一样的写法,倒是一下子没想过
SELECT distinct a.Email
FROM Person a,Person b
WHERE a.Id>b.Id
AND a.Email=b.Email
两张表连接起来,然后当id不同的时候,email相同则返回,不过我觉得此种效率应该更慢,distinct本身就要进行分组了,用group by 分组之后计算应该更快.